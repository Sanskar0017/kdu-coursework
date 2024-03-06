// App.tsx
import React from 'react';
import { Provider } from 'react-redux';
import { store } from './redux/store';
import BookingPage from './components/BookingPage';
const App: React.FC = () => {
  return (
    <Provider store={store}>
      <div className="App">
        <BookingPage />
      </div>
    </Provider>
  );
}

export default App;
