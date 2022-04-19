let body = document.body;
let windowWith = window.innerWidth;
let windowHeight = window.innerHeight;
const balloonWidth = 100;
const balloonHeight = 203;

// window size change >> update innerWidth, innerHeight
window.onresize = function() {
	windowWith = window.innerWidth;
	windowHeight = window.innerHeight
}
 
let audio = document.createElement('audio');
audio.src = 'sounds/pop.mp3';

let score = 0;
let balloonId = 0;
let isGameOver = false;
const total = 10;
const colors = ['blue', 'green', 'red', 'violet', 'yellow'];

/*
  Create a balloon
    + Random color
    + Random horizontal position
    + Animate: move from bottom to top
 */
function create() {
	let rand = random(colors.length);

	let balloon = document.createElement('div');
	balloon.className = 'balloon balloon-' + colors[rand];

	rand = random(windowWith - balloonWidth);
	balloon.style.left = rand + 'px';

	// <div data-id = 'balloonId++' />
	// balloon.dataset.id = balloonId++;

	// <div id = 'balloonId++' />
	balloon.id = balloonId++;

	body.appendChild(balloon);
	animate(balloon);
}

// pop >> remove out of body(document)
// reference
function animate(balloon) {
	let moved = 0;
	// move top every 10ms
	let animateInterval = setInterval(function() {
		moved++;

		// balloon is poped(removed), isn't it ? How to know
		// >> check current balloon is exist in body or not
		let isPoped = document.querySelector('div[id="' + balloon.id + '"]') === null;

		if (!isPoped) {
			if (moved >= windowHeight + balloonHeight) {
				// stop moving balloon if balloon bottom position touched window top
				clearInterval(animateInterval);
				isGameOver = true;
				
				// test with balloon has id=0. Poped
				// removed from body but still keep a reference to poped baloon >> moved still increase
				console.log("FAILED");
				console.log(balloon);
			} else {
				balloon.style.top = windowHeight - moved + 'px';
			}
		}
	}, 10);
}

function startGame() {
	// config win point
	document.querySelector('.total').textContent = total;

	// generate a new balloon every 600ms
	let initBalloonInterval = setInterval(function() {
		if (!isGameOver) {
			create();
			if (score === total) {
				// show win popup
				showPopup('.win');

				// stop creating new balloon
				clearInterval(initBalloonInterval);	
			}
		} else {
			// show lose popup
			showPopup('.lose');

			// stop creating new balloon
			clearInterval(initBalloonInterval);
		}
	}, 600);
}

startGame();

// ========================= events ========================= //
document.addEventListener('click', function(event) {
	let target = event.target;
	if (target.classList.contains('balloon')) {
		pop(target);
	}
});

// play again

let restartBtn = document.querySelector('.restart');
let cancelBtn = document.querySelector('.cancel');

restartBtn.addEventListener('click', function() {
	// remove remaining baloons in previous game
	let remainingBaloons = document.querySelectorAll('.balloon');
	for (let balloon of remainingBaloons) {
		balloon.remove();
	}

	// hide total-shadow(lose) element
	hidePopup('.lose');

	// score = 0 >> updateUI
	score = 0;
	updateScore();

	// startGame
	isGameOver = false;
	startGame();
});

cancelBtn.addEventListener('click', function(event) {
	// hide total-shadow(lose) element
	hidePopup('.lose');
});

// ========================= UI function ========================= //
function pop(balloon) {
	audio.play();
	balloon.remove();
	score++;
	updateScore();
}

function updateScore() {
	let scoreItems = document.querySelectorAll('.score');
	for (let scoreItem of scoreItems) {
		scoreItem.textContent = score;
	}
}

function showPopup(popupClass) {
	document.querySelector('.total-shadow').style.display = 'flex';
	document.querySelector(popupClass).style.display = 'block';
}

function hidePopup(popupClass) {
	document.querySelector('.total-shadow').style.display = 'none';
	document.querySelector(popupClass).style.display = 'none';
}

// ========================= utils function ========================= //

function random(input) {
	return Math.floor(Math.random() * input);
}