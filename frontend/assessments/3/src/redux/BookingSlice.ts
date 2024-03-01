import { createSlice, createAsyncThunk, PayloadAction } from "@reduxjs/toolkit";
import { RoomType, RoomDetails } from "../utils/types";
import { RootState, AppThunk } from "./store";

interface BookingState {
  roomTypes: RoomType[];
  selectedRoomId: string;
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
}

const initialState: BookingState = {
  roomTypes: [],
  selectedRoomId: "",
  status: "idle",
  error: null,
};

export const fetchRoomDetails = createAsyncThunk(
  "fetchRoomDetails",
  async (_, { rejectWithValue }) => {
    try {
      console.log("fetching");
      const response = await fetch(
        "https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/assessment-3.json"
      );
      return response.json();
    } catch (error) {
      return rejectWithValue("Failed to fetch room details");
    }
  }
);

const bookingSlice = createSlice({
  name: "booking",
  initialState,
  reducers: {
    selectRoomType(state, action: PayloadAction<string>) {
      state.selectedRoomId = action.payload;
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(fetchRoomDetails.pending, (state) => {
        state.status = "loading";
      })
      .addCase(fetchRoomDetails.fulfilled, (state, action) => {
        state.status = "succeeded";
        state.roomTypes = action.payload.roomTypes;
      })
      .addCase(fetchRoomDetails.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      });
  },
});

export const { selectRoomType } = bookingSlice.actions;

export const selectRoomTypes = (state: RootState) => state.booking.roomTypes;
export const selectRoomId = (state: RootState) => state.booking.selectedRoomId;

export const selectBookingStatus = (state: RootState) => state.booking.status;
export const selectBookingError = (state: RootState) => state.booking.error;

export default bookingSlice.reducer;
