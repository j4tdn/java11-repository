'use strict';
// debug
console.log("INFO --> Todo App");

/*==
Java: Static Type

ECMAScript 5, ES6 <==> JavaScript
JavaScript: Dynamic Type
JS Scope: let, var, constant
==*/

x = "Index page";
console.log("X1: " + x);
console.log("X1 type: " + (typeof x));

x = 28;
console.log("X2: " + x);
console.log("X2 type: " + (typeof x));

x = true;
console.log("X3: " + x);
console.log("X3 type: " + (typeof x));

let y;
console.log("Y1: " + y);

y = null;
console.log("Y2: " + y);

let age = 26;
// string template
console.log(`He is ${age} years old`);

// Converter
// +:  convert to number
// !!: convert to boolean