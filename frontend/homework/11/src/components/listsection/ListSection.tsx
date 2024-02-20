import React, { useState } from "react";
import { SectionProps } from "../utils/SectionProps";
import "./ListSection.css";

/**
 * ListSection component for managing items.
 * @param {Readonly<SectionProps>} props - The props object.
 * @returns {JSX.Element} ListSection component.
 */
export function ListSection({
  list,
  searchQuery,
  onAddItem,
  onDeleteItem,
}: Readonly<SectionProps>) {
  const [inputText, setInputText] = useState("");

  /**
   * Handles adding a new item to the list.
   */
  const handleAddItemClick = () => {
    if (inputText.trim() === "") return;
    onAddItem(inputText);
    setInputText("");
  };

  /**
   * Handles deleting an item from the list.
   * @param {number} id - The id of the item to delete.
   */
  const handleDeleteItemClick = (id: number) => {
    onDeleteItem(id);
  };

  // Filter the list based on the search query
  const filteredList = list.filter((item) =>
    item.text.toLowerCase().includes(searchQuery.toLowerCase())
  );

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
