const express = require('express');
const cors = require('cors');
const http = require('http');
const socketIo = require('socket.io');

const app = express();

const server = http.createServer(app);
const io = new socketIo.Server(server, {
    cors: {
        origin: "*" 
    }
});

app.use(cors())
app.use(express.json());

// Simple Check Validation, by GetMapping
app.get("/", (req, res) => {
    res.json({
        "msg":"Sanskar, hi!"
    })
});

io.on("connection", (socket) => {
    console.log("connection created");
    socket.on("message", (payload) => {
        console.log("payload", payload);
        io.except(socket.id).emit("newMessage", payload)
    })
});


server.listen(3000, () => {
    console.log(`app starting at port 3000`)
});