import React, { useState } from "react";

export function AppendUser() {
  const [users, setUsers] = useState([
    { id: 1, name: "Sanskar" },
    { id: 2, name: "Veerbhadra" },
  ]);

  const addNewUser = () => {
    console.log("button clicked");
    const newUser = {
      id: users.length + 1,
      name: `User ${users.length + 1}`,
    };

    setUsers([...users, newUser]);
  };

  return (
    <>
      <h1>User list</h1>
      <ul>
        {users.map((item) => (
          <li key={item.id}>{item.name}</li>
        ))}
      </ul>
      <button onClick={addNewUser}>Add</button>
    </>
  );
}
