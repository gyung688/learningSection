// 1. create Obect
let obj1 = new Object(); //객체 생성자
let obj2 = {}; // 객체 리터럴(대부분 사용)

// 2. 객체 프로퍼티(객체 속성)
let person = {
    name : "lee",
    age : 27,
    hobby : "tennis",
    job : "developer",
    extra : {}, //함수
    10 : 20,
    "like cat" : true,
}

// 3. 객체 프로퍼티 접근법
// 3.1. 특정 프로퍼티에 접근(점 표기법, 괄호 표기법)
let name = person.name;

let age = person["age"]; //person[age]로 표기하면 변수로 인식하게 됨됨

let property = "hobby";
let hobby = person[property];
console.log(hobby);

// 3.1 새로운 프로퍼티 추가 방법
person.job = "fe developer";
person["favouriteFood"] = "tteokbokki";

// 3.3 프로퍼티 수정방법
person.job = "educator";

// 3.4 프로퍼티 삭제방법
delete person.job;