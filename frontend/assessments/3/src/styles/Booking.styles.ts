import { CSSProperties } from "react";

export const styles: { [key: string]: CSSProperties } = {
  mainContainer: {
    display: "flex",
    flexDirection: "column",
    justifyContent: "space-evenly",
    margin: "0",
    padding: "0",
    height: "100vh",
    width: "100vw",
  },
  roomContainer: {
    height: "20vh",
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-evenly",
    margin: "20px 20px",
  },
};
