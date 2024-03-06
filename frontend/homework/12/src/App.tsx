import React, { useState, useEffect } from "react";
import { fetchRandomQuotes } from "../src/utils/API";
import { APIQuote } from "../src/types/quotes.types";
import "./App.css";
import Filter from "../src/components/filter/Filter";
import Quote from "./components/quote/Quote";

function App() {
  // State variables for quotes and filters
  const [quotes, setQuotes] = useState<APIQuote[]>([]);
  const [filters, setFilters] = useState<string[]>([]);

  // Fetch initial quotes on component mount
  useEffect(() => {
    // Effect runs only once on mount
    fetchRandomQuotes(3)
      .then((data) => {
        setQuotes(data); // Set fetched quotes to state
      })
      .catch((error) => {
        console.error("Error fetching quotes, check again!", error);
      });
  }, []); // Empty dependency array means it only runs once on mount

  // Function to filter quotes by tag
  const filterByTag = (tag: string) => {
    // If tag is not already applied, add it to filters
    if (!filters.includes(tag)) {
      setFilters([...filters, tag]);
    }
  };

  // Filter quotes based on applied filters
  const filteredQuotes = quotes.filter((quote: APIQuote) =>
    filters.every((filter) => quote.tags.includes(filter))
  );

  // Function to add a new random quote
  const addNewQuote = () => {
    fetch("https://api.quotable.io/quotes/random")
      .then((response) => response.json())
      .then((data: APIQuote[]) => {
        setQuotes([...data, quotes[0], quotes[1]]); // Add new quote to existing quotes
      })
      .catch((error) => {
        console.error("Error fetching new quote: ", error);
      });
  };

  // Function to remove a filter tag
  const removeTag = (tag: string) => {
    setFilters(filters.filter((item) => item !== tag)); // Remove tag from filters
  };

  return (
    <div className="container">
      <button className="new-quote-btn" onClick={addNewQuote}>
        New Quote
      </button>

      <Filter filters={filters} removeTag={removeTag} />

      {filteredQuotes.map((quote) => (
        <Quote key={quote._id} quote={quote} filterByTag={filterByTag} />
      ))}
    </div>
  );
}

export default App;
