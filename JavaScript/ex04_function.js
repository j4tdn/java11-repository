// declaration
function sum(a,b) {
	return a + b;
}

function print(preText, input){
	console.log(preText + ": " + input);
}

let result = sum(5, 10);
print("Sum of 5 and 10", result);

// arrow function, anonymous function
// expression function
// sub is object type, everything(object, function) is object in JS
let sub = (a, b) => a - b
print("Sub of 12 and 8", sub(12,8));

console.log("===============================");

// callback function
let numbers = [1,2,3,4,5];
function filter(elements, predicate){
	for (let element of elements){
		if(predicate(element)){
			console.log("matched element: " + element);
		}
	}
}

function isEven(element){
	return element %2 == 0;
}

//filter(numbers,isEven);
// filter(numbers,function(element){
// 	return element %2 == 0;
// });
filter(numbers, element => element % 3 == 0);