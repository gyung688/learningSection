console.log('hello js');

//common js 방식
// const moduleData = require("./math");
// console.log(moduleData);
// console.log(moduleData.add(1,2));
// console.log(moduleData.sub(1,2));

// ES 방식
import { add, sub } from "./math.js";
console.log(add(1,2));
console.log(sub(1,2));

import division from "./math.js";

const color = randomColor();
console.log(color);

