import React from "react";
import { render, screen } from "@testing-library/react";
import { App } from "./App";

// Test to check if the "learn react" link is rendered
test("renders learn react link", () => {
  // Render the App component
  render(<App />);

  // Find the element containing text "learn react" case-insensitively
  const linkElement = screen.getByText(/learn react/i);

  // Assert that the link element is present in the document
  expect(linkElement).toBeInTheDocument();
});
