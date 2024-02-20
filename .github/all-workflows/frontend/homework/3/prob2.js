function encodeString(str) {
    str = str.trim();

    const relationMap = {
        'a': '4',
        'e': '3',
        'i': '1',
        'o': '0',
        's': '5'
    };

    str = str.replace(/[aeious]/g, (match) => relationMap[match]);
    return str;
}

console.log(encodeString("javascript is cool  "));
console.log(encodeString("programming is fun"));
console.log(encodeString("  become a coder"));