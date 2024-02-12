const path = require('path')

function extractFileInfo(filePath){
    return{
        extension: path.extname(filePath),
        baseName: path.basename(filePath),
        directory: path.dirname(filePath)
    };
}

function processFilePaths(filePath){
    return filePath.map(extractFileInfo);
}

const filePaths = [
    'dir1/dir2/file1.txt',
    'dir1/dir3/file2.txt',
    'dir1/dir3/file3.md',
    'dir4/file4.jpg',
    'dir4/file5.pdf',
];

const fileInfo = processFilePaths(filePaths);
console.log(fileInfo);