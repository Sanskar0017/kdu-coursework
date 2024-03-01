import React from "react";

const DateSelector: React.FC = () => {
  return (
    <div>
      <label>Check-in Date:</label>
      <input type="date" />

      <label>Check-out Date:</label>
      <input type="date" />
    </div>
  );
};

export default DateSelector;
