const http = require('http');
const fs = require('path');

const PORT = 8000;

const server = http.createServer((req, res) => {
    if (req.method === 'GET' && req.url === '/system-info') {
        const os = require('os');
        const sysInfo = {
            hostname: os.hostname(),
            operatingSystem: os.type(),
            architecture: os.arch(),
            osRelease: os.release(),
            uptimeMinutes: Math.floor(os.uptime() / 60),
            cpuCores: os.cpus().length,
            totalMemoryMB: Math.floor(os.totalmem() / 1024 / 1024),
            freeMemoryMB: Math.floor(os.freemem() / 1024 / 1024),
            // cwd: process.cwd() // Optional if needed
        };

        res.setHeader('Content-Type', 'application/json');
        res.end(JSON.stringify(sysInfo, null, 4)); // Pretty-print JSON
    } else {
        res.statusCode = 404;
        res.end('Not Found');
    }
});

server.listen(PORT, () => {
    console.log(`Server listening on port ${PORT}`);
});
