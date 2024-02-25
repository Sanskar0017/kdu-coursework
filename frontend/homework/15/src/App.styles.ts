import { CSSProperties } from "react";

export const styles: { [key: string]: CSSProperties } = {
  container: {
    maxWidth: "800px",
    margin: "0 500px",
    padding: "20px",
    fontFamily: "Arial, sans-serif",
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "center",
  },
  persistingdata: {
    backgroundColor: "#9d9684",
    color: "#000",
    alignSelf: "center",
    width: "40vw",
    display: "flex",
    flexDirection: "column",
    margin: "20px 200px",
    padding: "20px 20px",
    alignItems: "center",
    justifyContent: "center",
    fontSize: "30px",
  },
  header: {
    fontSize: "24px",
    fontWeight: "bold",
    marginBottom: "20px",
    border: "2px solid red",
  },
  inputField: {
    backgroundColor: "#9d9684",
    marginBottom: "20px",
    display: "flex",
    flexDirection: "column",
    padding: "20px 20px",
    alignItems: "center",
    color: "black",
    fontSize: "30px",
  },
  timerApplication: {
    backgroundColor: "#9d9684",
    marginBottom: "20px",
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "center",
    color: "#000",
    fontSize: "30px",
  },
  focusPostn: {
    padding: "10px 10px",
    margin: "10px 10px",
  },
  timerBtn: {
    display: "flex",
    flexDirection: "row",
    margin: "20px 20px",
    padding: "20px 20px",
  },
  scrollToTop: {
    textAlign: "center",
    fontSize: "30px",
  },
};
