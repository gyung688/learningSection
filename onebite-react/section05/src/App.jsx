import './App.css'
import Register from "./components/Register.jsx"
import HookExam from "./hooks/HookExam.jsx"

function App() { 
  // 자바스크립트 함수가 html태그를 반환할 수 있고, 
  // 이런 함수를 component라고 부름
  return (
    <>
      <Register/>
      <HookExam/>
    </>

  )
}

export default App
