
// funtions
// var calculateAge = function(yearOfBirth);

calculateAge(1999);

// function declaration
function calculateAge(yearOfBirth){
	console.log('Age: ' + (new Date().getFullYear() - yearOfBirth));
};

// function expression
// retirement(1999);
var retirement = function(yearOfBirth) {
	console.log("retirement in: " + (35 - (new Date().getFullYear() - yearOfBirth)));
}

retirement(1999);

// variable
// var age = undefined;
console.log(age);
var age = 36;
console.log(age);

