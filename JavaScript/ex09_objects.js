// declare and initial data for object directly

let person = {
	name: 'John',
	age: 28,
	job: 'Tester',

	getSkills: function(){
		console.log('Manual, Automation, Manage');
	}
};

console.log(person);
person.getSkills();

// ES5
let Person5 = function(name, year, job){
	this.name = name;
	this.year = year;
	this.job = job;

	// this.showAge = function() {
	// 	let age = new Date().getFullYear() - this.year;
	// 	console.log(this.name + ' now is ' + age + ' years old');
	// }
};

Person5.prototype.showAge = function() {
	let age = new Date().getFullYear() - this.year;
	console.log(this.name + ' now is ' + age + ' years old');
};

let john5 = new Person5('John',1992,'Developer');
let kaka5 = new Person5('Kaka',1988,'Player');
console.log(john5);
console.log(kaka5);
kaka5.showAge();

//ES6
class Person6{
	constructor(firstName, lastName, year, job){
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
		this.job = job;
	}

	printFullName(){
		console.log(this.firstName + " " + this.lastName);
	}

	calculateAge(){
		let age = new Date().getFullYear() - this.year;
		console.log(this.firstName + ' now is ' + age + ' years old');
	}
}

let hanna6 = new Person6('Hanna', 'Fielder', 1982, 'HR');
hanna6.printFullName();
hanna6.calculateAge();