import { createSlice, PayloadAction } from "@reduxjs/toolkit";

interface SnackbarState {
  open: boolean;
  message: string | null;
  type: "success" | "error";
}

const initialState: SnackbarState = {
  open: false,
  message: null,
  type: "success",
};

export const SnackbarSlice = createSlice({
  name: "snackbar",
  initialState,
  reducers: {
    showSnackbar(
      state,
      action: PayloadAction<{ message: string; type: "success" | "error" }>
    ) {
      state.open = true;
      state.message = action.payload.message;
      state.type = action.payload.type;
    },
    hideSnackbar(state) {
      state.open = false;
      state.message = null;
      state.type = "success";
    },
  },
});

export const { showSnackbar, hideSnackbar } = SnackbarSlice.actions;
export default SnackbarSlice.reducer;
