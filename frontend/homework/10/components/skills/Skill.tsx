import "../skills/Skill.css";

interface IListSkill {
  id: number;
  skill: string;
}

interface SkillsProps {
  readonly listSkills: IListSkill[];
}

export function Skill({ listSkills }: SkillsProps) {
  return (
    <div className="skill-section">
      <h3 id="skill-header">Skills</h3>
      <ul id="skillListing">
        {listSkills.map((skillItem) => (
          <li id="skillsList" key={skillItem.id}>
            {skillItem.skill}
          </li>
        ))}
      </ul>
    </div>
  );
}
