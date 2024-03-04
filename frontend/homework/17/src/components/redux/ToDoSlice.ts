import { createSlice, PayloadAction } from "@reduxjs/toolkit";

export interface IListItem {
  id: number;
  text: string;
  completed: boolean;
}

interface IListItemState {
  list: IListItem[];
  searchQuery: string;
}

// Initializing Initial State
const initialState: IListItemState = {
  list: [],
  searchQuery: "",
};

// Creating a slice for managing the to-do list state
const todoSlice = createSlice({
  name: "todos",
  initialState,
  reducers: {
    // Reducer to update the search query
    setSearchQuery(state, action: PayloadAction<string>) {
      state.searchQuery = action.payload;
    },
    // Reducer to add a new to-do item to the list
    addItemToList(state, action: PayloadAction<string>) {
      const newItem: IListItem = {
        id: Date.now(),
        text: action.payload,
        completed: false,
      };
      state.list.push(newItem);
    },
    // Reducer to delete a to-do item from the list based on its ID
    deleteListItem(state, action: PayloadAction<number>) {
      state.list = state.list.filter((item) => item.id !== action.payload);
    },
    // Reducer to toggle the completion status of a to-do item based on its ID
    toggleItem(state, action: PayloadAction<number>) {
      const itemId = action.payload;
      const findItem = state.list.find((item) => item.id === itemId);
      if (findItem) {
        findItem.completed = !findItem.completed;
      }
    },
  },
});

export const { setSearchQuery, addItemToList, deleteListItem, toggleItem } =
  todoSlice.actions;
export default todoSlice.reducer;
