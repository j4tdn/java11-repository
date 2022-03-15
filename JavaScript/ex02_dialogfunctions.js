let question = "Are you 18 years old or older ?"


let isValidAge = confirm(question);

if (isValidAge){
    let accepted = confirm("Do you want to plkay game");
    if (accepted){
        let name = prompt ("Enter your game account name", "Your Name");
        alert(`Welcome ${name} to TODO game`)

        let a = +prompt("Enter A", "0");
        let b = +prompt("Enter B", "0");
        
        let result = +prompt("Enter result", "0")
        console.log("result type: " + (typeof result))
        console.log("a+b type: " + (typeof (a+b)))
        if (result == (a + b)){
            alert("Correct");
        } else {
            alert("Wrong");
        }
    } else {
        alert("See You around")
    }
}