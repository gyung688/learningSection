// 단락함수 예시시

function returnFalse(){
    console.log("false function");
    return false;
}

function returnTrue(){
    console.log("true function");
    return true;
}

console.log(returnFalse() && returnTrue()); // false
// returnFalse결과가 false이므로 returnTrue를 타지 않음

// 2. 단락함수 예시시

function returnFalse(){
    console.log("false function");
    return undefined;
}

function returnTrue(){
    console.log("true function");
    return 0;
}

console.log(returnTrue() || returnFalse()); 
// returnTrue가 무조건 truthy이므로 returnFalse를 타지 않음 

// 3. 단락함수 활용 사례
function printName(person){
    const name = person && person.name;
    console.log(name || "no person data");
}

printName();