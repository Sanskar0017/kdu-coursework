import React from "react";
import "./App.css";

import { Title } from "./components/title/Title";
import { Skill } from "./components/skills/Skill";
import { Hobbies } from "./components/hobbies/Hobbies";

import data from "./components/utils/data.json";

function App() {
  return (
    <div className="to-list">
      <div id="title-header">
        <Title />
      </div>
      <div id="skill-hobby-description">
        <Skill listSkills={data.skills} />
        <Hobbies listHobbies={data.hobbies} />
      </div>
    </div>
  );
}

export default App;
