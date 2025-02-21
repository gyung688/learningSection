import './App.css'
import {useState} from "react";
function App() { 
  // 자바스크립트 함수가 html태그를 반환할 수 있고, 
  // 이런 함수를 component라고 부름

  function App(){
    const [count, setCount] = useState(0);
    const [light, setLight] = useState("OFF");
    console.log(count);

    return (
      <>
        <div>
          <h1>{light}
            <button onClick={() => {
                setLight(light === "ON" ? "OFF" : "ON");
              }}
            >
              {light === "ON" ? "OFF" : "ON"}
            </button>
          </h1>
        </div>
        <h1>{count}</h1>
        <button onClick={()=>{
          setCount(count + 1);
        }}
        >
         + 
        </button>
      </>
  
    )
  }
}

export default App
