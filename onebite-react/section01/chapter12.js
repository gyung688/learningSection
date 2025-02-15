// FUNCTION

function funcA() {
    console.log("funcA");
}

let varA = funcA;
varA();

// 함수표현식으로 만든 함수들은 hoisting 대상이 안됨
let varB = function (){ //이름이 없어서 익명함수
    console.log("funcB");
}

//화살표 함수
let varC = () => {
    return 1;
}
// return이 간결하면 아래와 같이 쓸 수도 있음음
// let varC = () => 1;
// let varC = (value) => value + 1;
console.log(varC(10));