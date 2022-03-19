//alert("Hello Friends !!!");
//alert("My name is Teo");
//alert(text): void
//confirm(text): boolean
//prompt(question, default_answer): string

let question = "Are you 18 years old or older?";

// boolean: true || false
let isValidAge = confirm(question);

if (isValidAge){
	let accepted = confirm("Do you want to play game");
	if (accepted){
		let name = prompt("Enter your game account name:","Your Name");
		alert(`Welcome ${name} to CALCULATION game`);

		let a = +prompt("Enter A:","0"); // string
		let b = +prompt("Enter B:","0"); // string

		let result = +prompt("Enter result:","0");
		console.log("result type: " + (typeof result)); //string
		console.log("a+b type: " + (typeof (a+b))); //number
		console.log(`a + b = ${a + b}`);

		// ===: type checking, value checking
		// == : auto convert to the same type before checking value
		if (result === (a+b)){
			alert("Correct");
		} else {
			alert("Wrong");
		}
	}
} else {
	alert("See you around");
}

console.log(isValidAge);