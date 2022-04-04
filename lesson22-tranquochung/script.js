// script

window.onload = function () {
  // get block main
  let block = document.querySelector("#block");
  // Position y
  let posY = document.querySelector("#pos-y");
  posY.onchange = function () {
    // block.style.marginTop = `${posY.value}px`;
    block.style.transform = `translateY(${posY.value}px)`;
  };

  //Position x
  let posX = document.querySelector("#pos-x");
  posX.onchange = function () {
    block.style.marginLeft = `${posX.value}px`;
  };

  // Size
  let size = document.querySelector("#size");
  size.onchange = function () {
    block.style.transform = `scale(${size.value})`;
  };

  // Opacity
  let opacity = document.querySelector("#opacity");
  opacity.onchange = function () {
    block.style.opacity = opacity.value;
  };

  // Shape Type
  let shapeType = document.querySelector("#shapeType");
  let submitShape = document.querySelector("#submitShape");
  submitShape.onclick = function () {
    let type = shapeType.value;
    if (type == "S1") {
      block.style.borderRadius = "10px";
      block.style.transform = `rotate(${0}deg)`;
    } else if (type == "S2") {
      block.style.borderRadius = "50%";
    } else if (type == "S3") {
      block.style.borderRadius = "";
      block.style.transform = `rotate(${40}deg)`;
    }
  };

  // Hex
  let hex = document.querySelector("#hex");
  hex.onkeypress = function (event) {
    if (event.which == 13) {
        block.style.background = `#${hex.value}`;
    }
  };

  // rgba
  let rgbaR = document.querySelector('#rgba-r');
  let rgbaG = document.querySelector('#rgba-g');
  let rgbaB = document.querySelector('#rgba-b');
  let rgbaA = document.querySelector('#rgba-a');

  let rgbaContainer = document.querySelector('#rgba-container');
  let rgbaInputs = rgbaContainer.querySelectorAll('input');

  for (let i = 0; i < rgbaInputs.length; i++) {
    rgbaInputs[i].onchange = () => block.style.background= `rgba(${rgbaR.value}, ${rgbaG.value}, ${rgbaB.value}, ${rgbaA.value})`;
  }

};
