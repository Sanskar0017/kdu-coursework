import React, { useState } from "react";
import { ListSection } from "./components/listsection/ListSection";
import { Header } from "./components/header/Header"
import './App.css'


interface IListItem {
    id: number;
    text: string;
}

export function App() {
    const [list, setList] = useState<IListItem[]>([]);
    const [searchQuery, setSearchQuery] = useState<string>("");

    const handleSearch = (query: string) => {
        setSearchQuery(query);
    };

    const handleAddItem = (text: string) => {
        const newItem: IListItem = {
            id: Date.now(),
            text: text,
        };
        setList([...list, newItem]);
    };

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
