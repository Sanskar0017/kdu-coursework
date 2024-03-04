import { fireEvent, render, screen } from "@testing-library/react";
import { Header } from "../header/Header";
import "@testing-library/jest-dom";
import { Provider } from "react-redux";
import { store } from "../redux/Store";

describe("<Header />", () => {
  it("render the header", () => {
    render(
      <Provider store={store}>
        <Header />
      </Provider>
    );

    expect(screen.getByText("Item Lister")).toBeInTheDocument();
    expect(screen.getByPlaceholderText("Search items...")).toBeInTheDocument();
  });

  test("search input change triggers dispatch", () => {
    render(
      <Provider store={store}>
        <Header />
      </Provider>
    );

    const searchInput = screen.getByTestId("search-bar");
    fireEvent.change(searchInput, { target: { value: "Test" } });
  });
});
