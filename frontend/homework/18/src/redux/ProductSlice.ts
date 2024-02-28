import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { ProductTypesTs } from "../utils/Product.types";
import { getProducts } from "./thunk/getProducts";

interface ProductState {
  productList: ProductTypesTs[];
  state: "fulfilled" | "pending" | "rejected";
  error: string | null;
}

const initialState: ProductState = {
  productList: [],
  state: "pending",
  error: null,
};

export const ProductSlice = createSlice({
  name: "products",
  initialState,
  reducers: {
    setData: (state, action: PayloadAction<ProductTypesTs[]>) => {
      state.productList = action.payload;
      state.state = "fulfilled";
      state.error = null;
    },

    setError: (state, action: PayloadAction<string>) => {
      state.state = "pending";
      state.error = action.payload;
    },
  },
  // handling extra actions by getProducts thunk
  extraReducers(builder) {
    builder
      .addCase(getProducts.pending, (state) => {
        state.state = "pending";
        state.error = null;
      })
      .addCase(getProducts.fulfilled, (state, action) => {
        state.productList = action.payload;
        state.state = "fulfilled";
        state.error = null;
      })
      .addCase(getProducts.rejected, (state, action) => {
        state.state = "rejected";
        state.error = action.payload as string;
      });
  },
});

export const { setData, setError } = ProductSlice.actions;
export default ProductSlice.reducer;
