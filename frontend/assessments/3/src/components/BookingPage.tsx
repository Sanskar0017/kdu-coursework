import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../redux/store";
import RoomSelector from "./RoomSelector";
import DateSelector from "./DateSelector";
import AddOnsSelector from "./AddOnsSelector";
import CostCalculator from "./CostCalculator";
import SubmitButton from "./SubmitButton";
import { fetchRoomDetails } from "../redux/BookingSlice";
import { styles } from "../styles/Booking.styles";

const BookingPage: React.FC = () => {
  const dispatch = useDispatch();
  const { roomDetails } = useSelector((state: RootState) => state.booking);

  useEffect(() => {
    dispatch(fetchRoomDetails());
  }, [dispatch]);

  return (
    <div className="main-container" style={styles.mainContainer}>
      <h1 style={styles.roomContainer}>Hotel Booking</h1>
      <div className="roomselector" style={styles.roomContainer}>
        <RoomSelector />
      </div>
      <div className="roomselector" style={styles.roomContainer}>
        <DateSelector />
      </div>
      <div className="roomselector" style={styles.roomContainer}>
        <AddOnsSelector />
      </div>
      <div className="roomselector" style={styles.roomContainer}>
        <CostCalculator />
      </div>
      <div className="roomselector" style={styles.roomContainer}>
        <SubmitButton />
      </div>
    </div>
  );
};

export default BookingPage;
