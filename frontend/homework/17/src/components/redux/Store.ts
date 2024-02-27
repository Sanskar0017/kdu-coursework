import { configureStore } from "@reduxjs/toolkit";
import ToDoSlice from "./ToDoSlice";
import {persistReducer, persistStore }from "redux-persist";
import storage from "redux-persist/lib/storage";

// persisting all the reducers defined, can also use whitelist to specify indivisual 
const persistConfig = {
  key: 'root',
  storage,  
};

const persistedReducer = persistReducer(persistConfig, ToDoSlice);

// Configuring and creating the redux store
export const store = configureStore({
  // Combining all reducers
  reducer: {
    todos: persistedReducer,
  },
});

export const persistor = persistStore(store);
export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
