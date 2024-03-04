import { fireEvent, render, screen } from "@testing-library/react";
import { ListSection } from "../listsection/ListSection";
import { Provider } from "react-redux";
import { store } from "../redux/Store";
import "@testing-library/jest-dom";

describe("Render the list section", () => {
  beforeEach(() => {
    render(
      <Provider store={store}>
        <ListSection />
      </Provider>
    );
  });

  test("render the list section", () => {
    expect(screen.getByText("Add Items")).toBeInTheDocument();
    expect(screen.getByText("Items")).toBeInTheDocument();
  });

  test("adding and deleting items to the list", () => {
    const inputField = screen.getByTestId("input-field");
    const btnField = screen.getByTestId("submit-btn");

    fireEvent.change(inputField, {
      target: { value: "Sanskar adds an item into the list" },
    });
    fireEvent.click(btnField);

    const addedItem = screen.getByText("Sanskar adds an item into the list");
    expect(addedItem).toBeInTheDocument();

    const deleteBtn = screen.getByTestId("delete-btn");
    fireEvent.click(deleteBtn);

    expect(
      screen.queryByText("Sanskar adds an item to delete from the list")
    ).not.toBeInTheDocument();
  });

  test("adding items to the list", () => {
    const inputField = screen.getByTestId("input-field");
    const btnField = screen.getByTestId("submit-btn");

    fireEvent.change(inputField, {
      target: { value: "Sanskar adds an item into the list" },
    });
    fireEvent.click(btnField);

    const addedItem = screen.getByText("Sanskar adds an item into the list");
    expect(addedItem).toBeInTheDocument();

  });

  test("input box changing with user", () => {
    const inputField = screen.getByTestId("input-field");
    const data = "Sanskar entering value into input";

    fireEvent.change(inputField, { target: { value: data } });
    expect(inputField).toHaveProperty("value", data);
  });
});
