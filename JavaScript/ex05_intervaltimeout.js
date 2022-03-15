// timeout: just 1 time
let counter = 0;
setTimeout(function(){
    console.log(`timeout --> ${counter++}`);
}, 2000);

// interval: forever
let runner = setInterval(function(){
    console.log(`interval --> ${counter++}`)
    if (counter === 10){
        clearInterval(runner)
    }
}, 1000)