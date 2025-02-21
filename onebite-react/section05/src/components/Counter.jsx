import {useState} from "react"
//리렌더링 조건
// 1. State변화
// 2. Props 변화
// 3. 부모 변화

// App에 count, light이 동시에 있으면 count가 리렌더링되면서 light도 리렌더링 됨
// Bulb같은 자식 컴포넌트는 부모(APP())로부터 받는 props 값이 바뀌게되면 리렌더링이 발생
// count가 바뀌면 App이 리렌더링되면서 Bulb도 리렌더링됨 성능 안좋아짐. 따로로 뺌
const Counter= () =>{
    const [count, setCount] = useState(0);
    console.log(count);
    return (
        <div>
          <h1>{count}</h1>
          <button onClick={()=>{
            setCount(count + 1);
          }}
          >
           + 
          </button>
        </div>
    );
   }

export default Counter;