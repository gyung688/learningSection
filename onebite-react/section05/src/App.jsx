import './App.css'
import Header from "./components/Header.jsx"
import Main from "./components/Main.jsx"
import Footer from "./components/Footer.jsx"

function App() { 
  // 자바스크립트 함수가 html태그를 반환할 수 있고, 
  // 이런 함수를 component라고 부름
  return (
    <>
        <Header/>
        <Main/>
        <Footer/>
    </>

  )
}

export default App
