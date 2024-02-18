document.addEventListener("DOMContentLoaded", function () {
  const socket = io();

  const historySection = document.getElementById("history");

  function createHistoryEntryElement(type, quantity) {
    const entryElement = document.createElement("div");
    entryElement.classList.add("history-entry");
    entryElement.textContent = `${type}: ${quantity} Qty - ${new Date().toLocaleString()}`;
    entryElement.style.border = "1px solid #red";
    entryElement.style.padding = "5px";
    entryElement.style.margin = "5apx 0";

    if (type === "Buy") {
      entryElement.style.border = "1px solid green";
      entryElement.style.color = "green";
    } else if (type === "Sell") {
      entryElement.style.border = "1px solid red";
      entryElement.style.color = "red";
    }

    return entryElement;
  }

  function addHistoryEntry(type, quantity) {
    const entryElement = createHistoryEntryElement(type, quantity);
    historySection.appendChild(entryElement);
  }

  const buyButton = document.getElementById("stock-buy-button");
  buyButton.addEventListener("click", () => {
    const quantityInput = document.getElementById("stock-qty-input").value;
    if (quantityInput.trim() !== "") {
      addHistoryEntry("Buy", quantityInput);
      document.getElementById("stock-qty-input").value = "";
      socket.emit("buy", quantityInput);
    }
  });

  const sellButton = document.getElementById("stock-sell-button");
  sellButton.addEventListener("click", () => {
    const quantityInput = document.getElementById("stock-qty-input").value;
    if (quantityInput.trim() !== "") {
      addHistoryEntry("Sell", quantityInput);
      socket.emit("sell", quantityInput);
    }
  });
});

document.addEventListener("DOMContentLoaded", function () {
  const socket = io();

  const priceInput = document.getElementById("stock-price-input");

  socket.on("update", (data) => {
    console.log("Data for price is reaching");
    priceInput.value = data.price.toFixed(2);
  });
});
