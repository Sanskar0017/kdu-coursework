import { CSSProperties } from "react";

export const styles: { [key: string]: CSSProperties } = {
  stockPageContainer: {
    display: "flex",
    flexDirection: "row",
    flexWrap: "wrap",
    width: "90vw",
    margin: "40px auto",
    justifyContent: "flex-start",
    height: "80vh",
    overflow: "hidden",
    backgroundColor: "#f8f9fa",
  },
  stockParticulars: {
    display: "flex",
    flexDirection: "column",
    justifyContent: "space-evenly",
    width: "65vw",
    alignItems: "center",
    height: "100%",
  },
  stockSelection: {
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-evenly",
    margin: "10px auto",
    width: "90%",
    height: "10%",
    fontSize: "1.5rem",
  },
  stockChart: {
    width: "90%",
    height: "100%",
    overflowX: "auto",
    border: "1px solid #000",
    display: "flex",
    flexDirection: "row",
    justifyContent: "bottom",
  },
  stockIdentifier: {
    border: "1px solid #000",
    minWidth: "25%",
    height: "80%",
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-around",
    alignItems: "center",
    fontSize: "1.3rem",
    flexWrap: "wrap",
  },
  stockPrice: {
    border: "1px solid #000",
    width: "30%",
    height: "80%",
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-evenly",
    fontSize: "1.3rem",
    alignItems: "center",
  },
  stockQty: {
    width: "25%",
    height: "80%",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
  },
  stockBtn: {
    height: "80%",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
  },
  allBtn: {
    height: "90%",
    margin: "5px",
    fontSize: "1.2rem",
  },
  qtyHolder: {
    width: "100%",
    height: "100%",
    textAlign: "center",
    border: "1px solid #000",
    fontSize: "1rem",
  },
  stockIdnSymbol: {
    border: "1px solid #f4a629",
    backgroundColor: "#ffec99",
    padding: "5px",
    color: "#f4a629",
  },
  stockTransactions: {
    width: "25%",
    display: "flex",
    flexDirection: "column",
    justifyContent: "space-evenly",
  },
  stockHistory: {
    border: "1px solid #000",
    borderRadius: "4px",
    padding: "10px",
    height: "48%",
    maxHeight: "300px",
    overflowY: "auto",
  },
  stockNotifications: {
    border: "1px solid #000",
    borderRadius: "4px",
    padding: "10px",
    width: "90%",
    height: "42%",
    margin: "20px auto",
    maxHeight: "300px",
    overflowY: "auto",
  },
  transactionHistory: {
    border: "1px solid #000",
    borderRadius: "10px",
    padding: "8px",
    listStyleType: "none",
    width: "90%",
    margin: "10px 5px",
  },
  historySection: {
    flexDirection: "row",
    display: "flex",
    alignItems: "center",
    justifyContent: "space-around",
    margin: "5px 5px",
  },
  stockTransactionQty: {
    fontSize: "1.5rem",
  },
  stockTransactionDesc: {
    display: "flex",
    flexDirection: "column",
    padding: "0px 10px",
    width: "80%",
  },
  stockTransactionType: {
    fontSize: "1.3rem",
  },
  stockNotification: {
    listStyleType: "none",
    margin: "10px 10px",
    width: "90%",
    fontSize: "1.2rem",
  },
};
