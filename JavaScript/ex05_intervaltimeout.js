// timer repeat every 2 seconds
// timeout: JUST 1 times
let counter = 0;;
setTimeout(function(){
	console.log(`timeout --> ${counter++}`);
}, 2000);

// interval: FOREVER
let runner = setInterval(function(){
	if (counter === 5){
		clearInterval(runner);
	}
	console.log(`interval --> ${counter++}`);
}, 1000);

// authorization