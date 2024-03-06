import React, { useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import {
  selectRoomTypes,
  selectRoomId,
  fetchRoomDetails,
} from "../redux/BookingSlice";
import { AddOn } from "../utils/types";
import { useEffect } from "react";

const AddOnsSelector: React.FC = () => {
  const roomTypes = useSelector(selectRoomTypes);
  const selectedRoomId = useSelector(selectRoomId);
  const selectedRoom = roomTypes.find((room) => room.id === selectedRoomId);
  const [selectedAddOns, setSelectedAddOns] = useState<string[]>([]);
  const dispatch = useDispatch();

  useEffect(() => {
    if (selectedRoomId) {
      dispatch(fetchRoomDetails());
    }
  }, [selectedRoomId, dispatch]);

  const handleAddOnsChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedOptions = Array.from(
      e.target.selectedOptions,
      (option) => option.value
    );
    setSelectedAddOns(selectedOptions);
  };

  if (!selectedRoom) {
    console.log(roomTypes);
    console.log(selectRoomId);
    return <p>Please choose a room type first.</p>;
  }

  const addOns: AddOn[] = selectedRoom ? selectedRoom.addOns : [];

  return (
    <div>
      <h3>Add Ons / Preferences:</h3>
      <select multiple onChange={handleAddOnsChange} value={selectedAddOns}>
        {addOns.map((addOn) => (
          <option key={addOn.name} value={addOn.name}>
            {addOn.name}
          </option>
        ))}
      </select>
    </div>
  );
};

export default AddOnsSelector;
