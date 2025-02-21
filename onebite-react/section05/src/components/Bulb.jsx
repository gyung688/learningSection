import {useState} from "react"

//Bulb같은 자식 컴포넌트는 부모로부터 받는 props 값이 바뀌게되면 리렌더링이 발생한다
const Bulb = () =>{
  const [light, setLight] = useState("OFF");

  return (
    <div>
        {light === "ON" ? (
          <h1 style={{backgroundColor:"orange"}}>ON</h1>
        )  : (
          <h1 style={{backgroundColor:"gray"}}>OFF</h1>
        )}
        <button onClick={() => {
            setLight(light === "ON" ? "OFF" : "ON");
          }}
        >
          {light === "ON" ? "OFF" : "ON"}
        </button>
    </div>
  );
 };

 export default Bulb;