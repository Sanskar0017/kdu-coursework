const shoes = [
    {type : 'sneakers', color: 'blue', size: 9, price: 50},
    { type: 'boots', color: 'brown', size: 10, price: 80 }
];

const shirts = [
    {type: 'polo', color: 'white', size: 'M', price:30},
    { type: 't-shirt', color: 'blue', size: 'L', price: 20 },
    { type: 'dress shirt', color: 'blue', size: 'S', price: 40 }
];

const wareHouse = [...shoes, ...shirts];
const totalWorth = wareHouse.reduce((acc, item) => acc + item.price, 0);

wareHouse.sort((a, b) => b.price - a.price);

const blueProducts = wareHouse.filter((product) => product.color === 'blue');

console.log("Warehouse ", wareHouse);
console.log("Total Worth: ", totalWorth);
console.log("Warehouse Sorting", wareHouse);
console.log("Warehouse Products blue in color: ", blueProducts);
