import React, { useContext } from "react";
import "./Header.css";
import { ThemeContext } from "../../App";

/**
 * Header component for displaying a search bar.
 * @param {object} props - The props object.
 * @param {function} props.onSearch - Function to handle search queries.
 * @returns {JSX.Element} Header component.
 */
export function Header() {
  /**
   * Handles the change event of the search input.
   * @param {React.ChangeEvent<HTMLInputElement>} e - The event object.
   */

  const { handleSearch } = useContext(ThemeContext);

  return (
    <div id="header">
      <h1 id="heading">Item Lister</h1>
      <input
        id="search-bar"
        type="text"
        placeholder="Search items..."
        onChange={(e) => handleSearch(e.target.value)}
      />
    </div>
  );
}
