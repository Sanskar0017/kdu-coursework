import React from "react";
import { APIQuote } from "../../types/quotes.types";
import "./Quote.css";

interface FilterType {
  quote: APIQuote;
  filterByTag: (tag: string) => void;
}

const Quote: React.FC<FilterType> = ({ quote, filterByTag }) => {
  return (
    <div className="quote">
      <div className="static-content">
        <p id="quote-content">{quote.content}</p>
        <p id="quote-author">~{quote.author}</p>
        <p id="quote-date">{quote.dateAdded}</p>
      </div>
      <div className="quote-tags">
        {quote.tags.map((tags) => (
          <span key={tags} className="tag" onClick={() => filterByTag(tags)}>
            {tags}
          </span>
        ))}
      </div>
    </div>
  );
};

export default Quote;
