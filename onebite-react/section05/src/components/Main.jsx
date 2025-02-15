// JSX 주의 사항
// 1. 중괄호 내부에는 자바스크립트 표현식만 넣을 수 있다.
const Main = () => {
    const number = 10;
    
    return(
        <main>
            <h1>main</h1>
            <h2>{number + 10}</h2>
        </main>
    )
}

export default Main;