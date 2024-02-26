import { configureStore } from "@reduxjs/toolkit";
import ToDoSlice from "./ToDoSlice";

// Configuring and creating the redux store
export const store = configureStore({
  // Combining all reducers
  reducer: {
    todos: ToDoSlice,
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
