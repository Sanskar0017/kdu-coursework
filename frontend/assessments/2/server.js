const express = require("express");
const http = require("http");
const socketIo = require("socket.io");
const path = require("path");

const app = express();
const server = http.createServer(app);
const io = socketIo(server);

const PORT = process.env.PORT || 3000;

let currentPrice = 100;

setInterval(() => {
  currentPrice += Math.random() * 10 - 5;
  console.log(currentPrice);
  io.emit("update", { price: currentPrice });
}, 5000);

app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "index.html"));
});

io.on("connection", (socket) => {
  socket.emit("initialData", { price: currentPrice });
});

server.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
