// functions
// var calculateAge = function(yearOfBirth);

calculateAge(1999);

// function declaration
function calculateAge(yearOfBirth) {
	console.log('Age: ' + (new Date().getFullYear() - yearOfBirth));
}

// function expression
// retirement(1995);
var retirement = function(yearOfBirth) {
	console.log("Retirement in: " + (35 - (new Date().getFullYear() - yearOfBirth)));
}

retirement(1995);

// variables
// var age = undefined;
console.log(age);
var age = 36;
console.log(age);




