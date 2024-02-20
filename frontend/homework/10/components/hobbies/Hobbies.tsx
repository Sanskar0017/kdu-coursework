import "../hobbies/Hobbies.css";

interface IListHobby {
  id: number;
  hobby: string;
}

interface HobbiesProps {
  readonly listHobbies: IListHobby[];
}

export function Hobbies({ listHobbies }: HobbiesProps) {
  return (
    <div className="hobby-section">
      <h3 id="hobbies-header">Hobbies</h3>
      <ul>
        {listHobbies.map((hobbyItem) => (
          <li id="listHobbies" key={hobbyItem.id}>
            {hobbyItem.hobby}
          </li>
        ))}
      </ul>
    </div>
  );
}
