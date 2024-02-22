import React, { useContext, useState } from "react";
import { ThemeContext } from "../../App";
import "./ListSection.css";

export function ListSection() {
  // Accessing context values
  const { list, searchQuery, handleAddItem, handleDeleteItem } =
    useContext(ThemeContext);

  // Local state for input text
  const [inputText, setInputText] = useState("");

  // Filter the list based on the search query
  const filteredList = list.filter((item) =>
    item.text.toLowerCase().includes(searchQuery.toLowerCase())
  );

  // Handles adding a new item to the list
  const handleAddItemClick = () => {
    if (inputText.trim() === "") return;
    handleAddItem(inputText);
    setInputText("");
  };

  // Handles deleting an item from the list
  const handleDeleteItemClick = (id: number) => {
    handleDeleteItem(id);
  };

  return (
    <div id="section">
      <h2 id="sub-heading">Add Items</h2>
      <input
        id="input-field"
        type="text"
        onChange={(e) => setInputText(e.target.value)}
        value={inputText}
      />
      <button id="submit-btn" onClick={handleAddItemClick}>
        Submit
      </button>
      <h2 id="sub-heading">Items</h2>
      {/* Render items based on the filtered list */}
      {filteredList.length === 0 && searchQuery !== "" ? (
        <p>No match found</p>
      ) : (
        <ul id="list-container">
          {filteredList.map((item) => (
            <li key={item.id} id="list-item">
              <span>{item.text}</span>
              <button
                id="delete-btn"
                onClick={() => handleDeleteItemClick(item.id)}
              >
                X
              </button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
