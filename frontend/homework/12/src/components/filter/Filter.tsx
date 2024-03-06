import React from "react";
import { MdClose } from "react-icons/md";
import "./Filter.css";

interface FilterType {
  filters: string[];
  removeTag: (tag: string) => void;
}

const Filter: React.FC<FilterType> = ({ filters, removeTag }) => {
  return (
    <div className="filters">
      <h3>Filters</h3>
      <div className="filter-tag-collection">
        {filters.map((tag) => (
          <span id="filtered-tag" key={tag} className="filter">
            <div id="tag-name">{tag}</div>
            <div onClick={() => removeTag(tag)}>
              <MdClose />
            </div>
          </span>
        ))}
      </div>
      <div id="line-boundary-tag"></div>
    </div>
  );
};

export default Filter;
