import React, { useState, createContext, useMemo } from "react";
import { ListSection } from "./components/listsection/ListSection";
import { Header } from "./components/header/Header";
import "./App.css";
import {
  IThemeContext,
  IListItem,
  ThemeProviderProps,
} from "./components/utils/Interfaces";

// Create a context for managing theme-related data
export const ThemeContext = createContext<IThemeContext>({
  list: [],
  searchQuery: "",
  handleSearch: () => {},
  handleAddItem: () => {},
  handleDeleteItem: () => {},
});

// ThemeProvider component manages the state related to the theme
const ThemeProvider = ({ children }: ThemeProviderProps) => {
  // State variables to manage the list and search query
  const [list, setList] = useState<IListItem[]>([]);
  const [searchQuery, setSearchQuery] = useState<string>("");

  // Function to update the search query
  const handleSearch = (query: string) => {
    setSearchQuery(query);
  };

  // Function to add an item to the list
  const handleAddItem = (text: string) => {
    const newItem: IListItem = {
      id: Date.now(),
      text: text,
    };
    setList((prevList) => [...prevList, newItem]);
  };

  // Function to delete an item from the list
  const handleDeleteItem = (id: number) => {
    setList(list.filter((item) => item.id !== id));
  };

  // Memoize the context value to avoid unnecessary re-renders
  const contextValue = useMemo(
    () => ({
      list,
      searchQuery,
      handleSearch,
      handleAddItem,
      handleDeleteItem,
    }),
    [list, searchQuery]
  );

  // Provide the context value to its children components
  return (
    <ThemeContext.Provider value={contextValue}>
      {children}
    </ThemeContext.Provider>
  );
};

// App component, the entry point of the application
export function App() {
  return (
    // Wrap the components with the ThemeProvider to provide theme-related data
    <ThemeProvider>
      <Header /> {/* Render the Header component */}
      <ListSection /> {/* Render the ListSection component */}
    </ThemeProvider>
  );
}
