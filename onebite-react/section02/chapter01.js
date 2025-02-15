// 1. Falsy한 값
let f1 = undefined;
let f2 = null;
let f3 = 0;
let f4 = -0;
let f5 = NaN``;
let f6 = "";
let f7 = 0n; //Big Integer

if(!f1){
    console.log("falsy");
}

// 2. Truthy한 값
// 7가지 Falsy한 값들을 제외한 나머지
let t1 = "hello";
let t2 = 123;
let t3 = [];
let t4 = {};
let t5 = () => {};

// 3. 활용 사례
function printName(person){
    // before
    if(person === undefined || person === null){
        console.log("no person data");
        return; //함수종료
    }
    // after
    if(!person){
        console.log("no person data");
        return; //함수종료
    }
    console.log(person.name);
}

let person; //undefined
// let person = {name : "kitty"};
printName(person);