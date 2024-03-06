import React, { useMemo } from "react";
import { useSelector } from "react-redux";
import { RootState } from "../redux/store";

const CostCalculator: React.FC = () => {
  const { roomTypes, selectedRoomId } = useSelector(
    (state: RootState) => state.booking
  );
  const selectedRoom = roomTypes.find((room) => room.id === selectedRoomId);

  const taxPercentage = 0.1;

  const totalCost = useMemo(() => {
    if (selectedRoom) {
      const roomCost = selectedRoom.price;
      const taxAmount = roomCost * taxPercentage;
      const total = roomCost + taxAmount;
      return total.toFixed(2);
    }
    return 0;
  }, [selectedRoom, taxPercentage]);

  return (
    <div>
      <h3>Cost Calculation:</h3>
      {selectedRoom ? (
        <div>
          <p>Room Type: {selectedRoom.name}</p>
          <p>Room Price: ${selectedRoom.price}</p>
          <p>Tax (10%): ${(selectedRoom.price * taxPercentage).toFixed(2)}</p>
          <p>Total Cost: ${totalCost}</p>
        </div>
      ) : (
        <p>Error: Please select a room type to calculate the cost.</p>
      )}
    </div>
  );
};

export default CostCalculator;
