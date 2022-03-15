// forindex, foreach
let text = "loosely type";

console.log("length: " + text.length);

alert("ForLoop ---> First Way !!!")
for (let i = 0; i < text.length; i++){
    console.log(text[i] + " ");
}

alert("ForLoop ---> Second Way !!!")
for (let i in text){
    console.log(text[i] + " ")
}

alert("ForLoop-Each ---> Second Way !!!")
for (let letter of text){
    console.log(letter + " ");
}