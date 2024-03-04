import { ListSection } from "./components/listsection/ListSection";
import { Header } from "./components/header/Header";
import { Provider } from "react-redux";
import { store, persistor } from "./components/redux/Store";
import { PersistGate } from "redux-persist/integration/react";

export function App() {
  return (
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <div>
          <Header />
          <ListSection />
        </div>
      </PersistGate>
    </Provider>
  );
}
