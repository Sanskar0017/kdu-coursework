import React, { useState } from "react";
import { ListSection } from "./components/listsection/ListSection";
import { Header } from "./components/header/Header"
import './App.css'


interface IListItem {
    id: number;
    text: string;
}

/**
 * Main functional component representing the TODO application.
 * @returns {JSX.Element} The TODO application component.
 */

export function App() {
    const [list, setList] = useState<IListItem[]>([]);
    const [searchQuery, setSearchQuery] = useState<string>("");

    /**
     * Handles the search query change.
     * @param {string} query - The search query.
     */
    const handleSearch = (query: string) => {
        setSearchQuery(query);
    };

     /**
     * Handles adding a new item to the list.
     * @param {string} text - The text of the new item.
     */
    const handleAddItem = (text: string) => {
        const newItem: IListItem = {
            id: Date.now(),
            text: text,
        };
        setList([...list, newItem]);
    };

    /**
     * Handles deleting an item from the list.
     * @param {number} id - The ID of the item to delete.
     */
    const handleDeleteItem = (id: number) => {
        setList(list.filter(item => item.id !== id));
    };

    return (
        <div>
            <Header onSearch={handleSearch} />
            <ListSection
                list={list}
                searchQuery={searchQuery}
                onAddItem={handleAddItem}
                onDeleteItem={handleDeleteItem}
            />
        </div>
    );
}
