import data from "../utils/data.json";
import "../title/Title.css";

interface IListSkill {
  name: string;
  fullName: string;
  qualification: string;
}

export function Title() {
  const jsonData: IListSkill = data;

  return (
    <div className="title">
      <p id="title-name">{jsonData.name}</p>
      <p id="title-fullName">{jsonData.fullName}</p>
      <p id="title-qualification">{jsonData.qualification}</p>
    </div>
  );
}
