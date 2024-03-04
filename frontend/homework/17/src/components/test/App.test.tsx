import { render, screen } from "@testing-library/react";
import { App } from "../../App";
import { Provider } from "react-redux";
import { store } from "../redux/Store";
import "@testing-library/jest-dom";

describe("App component", () => {
  test("renders App component with Header and ListSection", () => {
    render(
      <Provider store={store}>
        <App />
      </Provider>
    );

    expect(screen.getByText("Item Lister")).toBeInTheDocument();
    expect(screen.getByTestId("input-field")).toBeInTheDocument();
    expect(screen.getByTestId("submit-btn")).toBeInTheDocument();
    expect(screen.getByTestId("search-bar")).toBeInTheDocument();
  });
});
