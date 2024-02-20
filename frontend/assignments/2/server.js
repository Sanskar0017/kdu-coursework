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

const postList = [
  {
    id: 1,
    tweet: "This is the first tweet.",
  },
  {
    id: 2,
    tweet: "Here's the second tweet.",
  },
  {
    id: 3,
    tweet: "The third tweet is here.",
  },
  {
    id: 4,
    tweet: "Tweet number four is up.",
  },
  {
    id: 5,
    tweet: "Fifth tweet is ready.",
  },
  {
    id: 6,
    tweet: "This is tweet number six.",
  },
  {
    id: 7,
    tweet: "Seventh tweet is here.",
  },
  {
    id: 8,
    tweet: "Eighth tweet is ready.",
  },
  {
    id: 9,
    tweet: "This is tweet number nine.",
  },
  {
    id: 10,
    tweet: "Tenth tweet is here.",
  },
  {
    id: 11,
    tweet: "Eleventh tweet is ready.",
  },
  {
    id: 12,
    tweet: "This is tweet number twelve.",
  },
  {
    id: 13,
    tweet: "Thirteenth tweet is here.",
  },
  {
    id: 14,
    tweet: "Fourteenth tweet is ready.",
  },
  {
    id: 15,
    tweet: "This is tweet number fifteen.",
  },
  {
    id: 16,
    tweet: "Sixteenth tweet is here.",
  },
  {
    id: 17,
    tweet: "Seventeenth tweet is ready.",
  },
  {
    id: 18,
    tweet: "This is tweet number eighteen.",
  },
  {
    id: 19,
    tweet: "Nineteenth tweet is here.",
  },
  {
    id: 20,
    tweet: "Twentieth tweet is ready.",
  },
  {
    id: 21,
    tweet: "This is tweet number twenty-one.",
  },
  {
    id: 22,
    tweet: "Twenty-second tweet is here.",
  },
  {
    id: 23,
    tweet: "Twenty-third tweet is ready.",
  },
  {
    id: 24,
    tweet: "This is tweet number twenty-four.",
  },
  {
    id: 25,
    tweet: "Twenty-fifth tweet is here.",
  },
];

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

app.post("/api/posts", (req, res) => {
  const { postInput } = req.body;
  console.log("postinput at server side: ", postInput);
  if (!postInput) {
    return res
      .status(400)
      .json({ error: "Content and creator are required fields." });
  }

  const newPost = {
    id: postList.length + 1,
    postInput,
  };
  postList.push(newPost);
  res.status(201).json({ success: true, data: newPost });
});

app.get("/api/active-users", (req, res) => {
  const activeUsersArray = Array.from(activeUsers);
  res.json(activeUsersArray);
});

// applying pagination
app.get("/api/posts", (req, res) => {
  const { pageNumber, pageSize } = req.query;

  const page = Number(pageNumber);
  const size = Number(pageSize);

  const start = (page - 1) * size;
  const end = start + size;
  const paginatedPosts = postList.slice(start, end);
  res.json(paginatedPosts);
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
