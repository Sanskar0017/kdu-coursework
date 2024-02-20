import React, { useState } from "react";
import { SectionProps } from "../utils/SectionProps";
import './ListSection.css'



export function ListSection({ list, searchQuery, onAddItem, onDeleteItem }: Readonly<SectionProps>) {
    const [inputText, setInputText] = useState("");

    const handleAddItemClick = () => {
        if (inputText.trim() === "") return;
        onAddItem(inputText);
        setInputText("");
    };

    const handleDeleteItemClick = (id: number) => {
        onDeleteItem(id);
    };

    const filteredList = list.filter(item => item.text.toLowerCase().includes(searchQuery.toLowerCase()));

    return (
        <div id="section">
            <h2 id="sub-heading">Add Items</h2>
            <input
                id="input-field"
                type="text"
                onChange={(e) => setInputText(e.target.value)}
                value={inputText}
                placeholder="Enter item content"
            />
            <button id="submit-btn" onClick={handleAddItemClick}>Submit</button>
            <h2 id="sub-heading">Items</h2>
            {filteredList.length === 0 && searchQuery !== "" ? (
                <p>No match found</p>
            ) : (
                <ul id="list-container">
                    {filteredList.map(item => (
                        <li key={item.id} id="list-item">
                            <span>{item.text}</span>
                            <button id="delete-btn" onClick={() => handleDeleteItemClick(item.id)}>Delete</button>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}
