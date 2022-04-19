window.onload = function() {
	// move able
	let block = document.getElementById('block');

	let rgbaR = document.getElementById('rgba-r');
	let rgbaG = document.getElementById('rgba-g');
	let rgbaB = document.getElementById('rgba-b');
	let rgbaA = document.getElementById('rgba-a');
	let rgbaIps = document.querySelectorAll('.rgba-container>input');

	let posY = document.getElementById('pos-y');
	let posX = document.getElementById('pos-x');
	let size = document.getElementById('size');
	let opacity = document.getElementById('opacity');
	let shapeSelect = document.getElementById('shape-select');
	let shapeOk = document.getElementById('shape-ok');
	let hex = document.getElementById('hex');

	
	posY.onchange = function() {
		block.style.top = posY.value + 'px';
	};
	
	posX.onchange = function() {
		block.style.left = posX.value + 'px';
	};
	
	size.onchange = function() {
		block.style.transform = 'scale(' + size.value + ')';
	};
	
	opacity.onchange = function() {
		block.style.opacity = opacity.value;
		rgbaA.value = opacity.value;
	};

	shapeOk.onclick = function() {
		let option = shapeSelect.value;
		if (option === 'square') {
			block.style.borderRadius = '0';
			block.style.transform = 'rotate(0) scale(' + size.value + ')';
		} else if (option === 'circle') {
			block.style.borderRadius = '50%';
		} else if (option === 'rhombus') {
			block.style.borderRadius = '0';
			block.style.transform = 'rotate(45deg) scale(' + size.value + ')';
		}
	}

	hex.onkeypress = function(event) {
		if (event.which === 13) {
			block.style.background = '#' + hex.value;
			hex.value = '';
		}
	};

	for (let rgbaIp of rgbaIps) {
		rgbaIp.onchange = function() {
			block.style.background = `rgba(${rgbaR.value}, ${rgbaG.value}, ${rgbaB.value}, ${rgbaA.value})`;
			opacity.value = rgbaA.value;
		}
	}
}