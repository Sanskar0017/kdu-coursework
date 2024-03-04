import { useState } from "react";
import "./ListSection.css";
import { useDispatch, useSelector } from "react-redux";
import { addItemToList, deleteListItem, toggleItem } from "../redux/ToDoSlice";
import { RootState } from "../redux/Store";

export function ListSection() {
  const [inputText, setInputText] = useState("");
  const list = useSelector((state: RootState) => state.todos.list);
  const searchQuery = useSelector(
    (state: RootState) => state.todos.searchQuery
  );

  const dispatch = useDispatch();

  const handleAddItemClick = () => {
    if (inputText.trim() === "") return;
    dispatch(addItemToList(inputText));
    setInputText("");
  };

  const handleDeleteItemClick = (id: number) => {
    dispatch(deleteListItem(id));
  };

  const handleToggleItem = (id: number) => {
    dispatch(toggleItem(id));
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
        className="inputValue"
        data-testid="input-field"
        onChange={(e) => setInputText(e.target.value)}
        value={inputText}
      />
      <button
        id="submit-btn"
        data-testid="submit-btn"
        onClick={handleAddItemClick}
      >
        Submit
      </button>
      <h2 id="sub-heading">Items</h2>
      {filteredList.length === 0 && searchQuery !== "" ? (
        <p>No match found</p>
      ) : (
        <ul id="list-container">
          {filteredList.map((item) => (
            <li key={item.id} id="list-item">
              <input
                id="checkbox-input"
                type="checkbox"
                checked={item.completed}
                onChange={() => handleToggleItem(item.id)}
              />

              <span
                style={{
                  textDecoration: item.completed ? "line-through" : "none",
                }}
              >
                {item.text}
              </span>
              <button
                id="delete-btn"
                data-testid="delete-btn"
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
