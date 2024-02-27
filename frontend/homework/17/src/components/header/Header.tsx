import React from "react";
import "./Header.css";
import { useDispatch } from "react-redux";
import { setSearchQuery } from "../redux/ToDoSlice";

export function Header() {
  const dispatch = useDispatch();

  const handleSearch = (e: React.ChangeEvent<HTMLInputElement>) => {
    dispatch(setSearchQuery(e.target.value));
  };

  return (
    <div id="header">
      <h1 id="heading">Item Lister</h1>
      <input
        id="search-bar"
        type="text"
        data-testid="search-bar"
        placeholder="Search items..."
        onChange={handleSearch}
      />
    </div>
  );
}
