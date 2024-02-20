function tipCalculator(bills) {
  if (!Array.isArray(bills)) {
    throw new TypeError("bills must be an array");
  }
  const tips = bills.map((bill) => {
    let tip;
    if (bill < 50) {
      tip = bill * 0.2;
    } else if (bill < 200) {
      tip = bill * 0.15;
    } else {
      tip = bill * 0.1;
    }
    return parseFloat(tip.toFixed(2));
  });

  const totalAmounts = bills.map((bill, index) => {
    return (parseFloat(bill) + tips[index]).toFixed(2);
  });

  return [tips, totalAmounts];
}

const bills = [140, 45, 280];

try {
  const [tips, totalAmounts] = tipCalculator(bills);
  console.log("Tips:", tips);
  console.log("Totals:", totalAmounts);
} catch (error) {
  console.error("Error:", error.message);
}
