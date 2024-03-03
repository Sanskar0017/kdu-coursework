import { configureStore } from "@reduxjs/toolkit";
import productReducer from "./ProductSlice";
import snackReducer from "./SnackbarSlice";

export const store = configureStore({
  reducer: {
    products: productReducer,
    snackbar: snackReducer,
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
