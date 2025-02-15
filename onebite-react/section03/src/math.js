//math module

function add(a,b) {
    return a + b
}

function sub(a,b) {
    return a - b;
}

// common js 방식
// module.exports = {
//     add : add,
//     sub : sub,
// };

// ES 방식
export {add, sub};
export function mul(a,b){
    return a * b;
}

// default : math.js를 대표하는 기본값
export default function div(a,b){
    return a / b;
}