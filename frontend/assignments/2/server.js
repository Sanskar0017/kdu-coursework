const express = require("express");
const http = require("http");
const cors = require("cors");
const socketIo = require("socket.io");
const { loginUser } = require("./Controller/UserRoutes");
const User = require("./models/user");
const { log } = require("console");

const app = express();
const server = http.createServer(app);
const io = new socketIo.Server(server, {
  cors: {
    origin: "*",
  },
});

app.use(cors());
app.use(express.json());

const activeUsers = new Set();
const userObj = new User();
let currentUser = "";

app.post("/api/user/login", (req, res) => {
  const { username, password } = req.body;
  currentUser = username;
  console.log("api/user/login");

  const user = userObj.verifyUser(username, password);
  console.log("server.js");
  console.log(user);
  if (user.user_name == username) {
    console.log("fetching vaidation");
    activeUsers.add(username);
    res.json({ message: "Login successful", user });
    console.log("response successful");
  } else {
    res.status(401).json({ error: "Invalid username or password" });
  }
});

app.get("/api/active-users", (req, res) => {
  const activeUsersArray = Array.from(activeUsers);
  res.json(activeUsersArray);
});

io.on("connection", (socket) => {
  console.log("New client connected");

  socket.on("userConnected", (username) => {
    console.log("Adding user to active users", username);
    activeUsers.add(username);
    io.emit("activeUsers", Array.from(activeUsers));
  });

  socket.on("disconnect", () => {
    console.log("Client disconnected");
    activeUsers.delete(socket.username);

    io.emit("activeUsers", Array.from(activeUsers));
  });

  socket.on("chatMessage", (currentUser, message) => {
    console.log("Input message on server side is:", message);
    io.emit("chatMessage", currentUser, message);
  });
});

const PORT = process.env.PORT || 3000;
server.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
