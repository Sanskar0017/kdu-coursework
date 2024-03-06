import { configureStore, ThunkAction, Action } from "@reduxjs/toolkit";
import bookingReducer from "../redux/BookingSlice";

export const store = configureStore({
  reducer: {
    booking: bookingReducer,
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<
  ReturnType,
  RootState,
  unknown,
  Action<string>
>;
