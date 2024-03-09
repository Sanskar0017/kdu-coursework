import { ListSection } from "./components/listsection/ListSection";
import { Header } from "./components/header/Header";
import { Provider } from "react-redux";
import { store } from "./components/redux/Store";

export function App() {
  return (
    <Provider store={store}>
      <div>
        <Header />
        <ListSection />
      </div>
    </Provider>
  );
}
