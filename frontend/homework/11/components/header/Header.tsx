import React from "react";
import './Header.css'

interface HeaderProps {
    readonly onSearch: (query: string) => void;
}

export function Header({ onSearch }: HeaderProps) {
    const handleSearch = (e: React.ChangeEvent<HTMLInputElement>) => {
        onSearch(e.target.value);
    };

    return (
        <div id="header">
            <h1 id="heading">Item Lister</h1>
            <input
                id="search-bar"
                type="text"
                placeholder="Search items..."
                onChange={handleSearch}
            />
        </div>
    );
}
