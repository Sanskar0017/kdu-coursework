import { useState, useRef } from "react";
import { styles } from "./App.styles";

function App() {
  const mutableVariable = useRef(0);
  const [value, setValue] = useState(0);
  const inputRef = useRef<HTMLInputElement>(null);
  const scrollToTop = useRef<HTMLDivElement>(null);

  const scrolltotopp = () => {
    console.log(scrollToTop.current);
    if (scrollToTop.current) {
      console.log("listening");
      return scrollToTop.current.scrollIntoView({ behavior: "smooth" });
    }
  };

  const increment = () => {
    mutableVariable.current++;
    console.log("Incremented mutable variable:", mutableVariable.current);
  };

  const handlebuttonChange = () => {
    inputRef.current?.focus();
  };

  const incrementChange = () => {
    setValue(mutableVariable.current);
  };

  const timerId = useRef(0);
  const [seconds, setSeconds] = useState(0);

  const startTimer = () => {
    timerId.current = setInterval(() => {
      setSeconds((prev) => prev + 1);
    }, 1000);
  };
  const stopTimer = () => {
    clearInterval(timerId.current);
    timerId.current = 0;
  };
  const resetTimer = () => {
    if (seconds) {
      setSeconds(0);
    }
  };

  return (
    <div className="container" ref={scrollToTop} style={styles.container}>
      <div className="persistingdata" style={styles.persistingdata}>
        <p>Mutable variable: {mutableVariable.current}</p>
        <p>State variable: {value}</p>
        <button style={styles.focusPostn} onClick={increment}>
          Increment mutable
        </button>
        <button style={styles.focusPostn} onClick={incrementChange}>
          Change state with mutable
        </button>
      </div>
      <div className="inputfield" style={styles.inputField}>
        <p>Focusing when the component renders on the page</p>
        <input
          style={styles.focusPostn}
          className="focus-postn"
          type="text"
          id="first-input"
          ref={inputRef}
          placeholder="first Input focus"
        />
        <input style={styles.focusPostn} className="focus-postn" type="text" />
        <input style={styles.focusPostn} className="focus-postn" type="text" />
        <button
          style={styles.focusPostn}
          className="focus-postn"
          onClick={handlebuttonChange}
        >
          Focus
        </button>
      </div>

      <div className="timer-application" style={styles.timerApplication}>
        <p>Seconds: {seconds}</p>
        <div className="timer-btn" style={styles.timerBtn}>
          <button style={styles.focusPostn} onClick={startTimer}>
            Start Timer
          </button>
          <button style={styles.focusPostn} onClick={stopTimer}>
            Stop Timer
          </button>
          <button style={styles.focusPostn} onClick={resetTimer}>
            Reset Timer
          </button>
        </div>
      </div>

      <div className="scroll-to-top" style={styles.scrollToTop}>
        <button onClick={scrolltotopp}>ScrollToTop</button>
      </div>
    </div>
  );
}

export default App;
