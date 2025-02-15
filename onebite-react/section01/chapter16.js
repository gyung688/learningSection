//1.상수객체
const animal = {
    type : "cat",
    name : "kitty",
    color : "black"
}

animal.age = 2; //추가
animal.name = "butterfly" //수정
delete animal.color; //삭제

console.log(animal);

// 2. 메서드
// 값이 함수인 프로퍼티

const person = {
    // method 선언
    sayHi : function (){
        console.log("hi");
    },
};

person.sayHi();
person["sayHi"]();
