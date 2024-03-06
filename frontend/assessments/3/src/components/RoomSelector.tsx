import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../redux/store";
import { selectRoomType } from "../redux/BookingSlice";

const RoomSelector: React.FC = () => {
  const dispatch = useDispatch();
  const { roomTypes, selectedRoomId } = useSelector(
    (state: RootState) =>
      (state.booking || { roomTypes: [], selectedRoomId: "" }) as any
  );

  const handleRoomTypeChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedRoomId = e.target.value;
    dispatch(selectRoomType(selectedRoomId));
  };

  return (
    <div>
      <label>Select Room Type:</label>
      <select value={selectedRoomId} onChange={handleRoomTypeChange}>
        <option value="">Select Room Type</option>
        {roomTypes.map((roomType: any) => (
          <option key={roomType.id} value={roomType.id}>
            {roomType.name}
          </option>
        ))}
      </select>
    </div>
  );
};

export default RoomSelector;
