const colors = ["blue", "green", "red", "violet", "yellow"];
let screenWidth = screen.width;
let screenHeight = screen.height;
let widthBalloon = 75;
let heightBalloon = 150;
let score = 0;
let gameOver = false;
let auto = 0;
// let total = 0;
let game;

// score winer game
let scoreWin = 10;

// create balloon
function createBalloon() {
  let balloon = document.createElement("div");
  let colorType = random(colors.length);
  // random location
  let location = random(screenWidth - widthBalloon);

  // create balloon
  balloon.classList.add("balloon", "balloon-" + colors[colorType]);
  document.body.appendChild(balloon);

  balloon.style.left = `${location}px`;
  balloon.dataset.id = auto++;

  // auto fly
  fly(balloon);
}

// fly balloon
function fly(balloon) {
  let distance = -150;
  let exists;
  setInterval(() => {
    // check ballon exists
    exists =
      document.querySelector(`[data-id="${balloon.dataset.id}"]`) !== null;

    if (exists) {
      if (distance < screenHeight) {
        balloon.style.bottom = `${distance}px`;
        distance++;
      } else if (!gameOver) {
        showBlock("block-lose");
        updateTotal();
        removeAll();
        clearInterval(game);
      }
    }
  }, (10 + random(10)) / (1 + score / 10));
}

// show block finish
function showBlock(box) {
  let screen = document.querySelector(".block-finish");
  let block = document.querySelector(`.${box}`);
  screen.style.display = "flex";
  block.style.display = "flex";
  pause();
  if (box == "block-lose") {
    playSound("sounds/loser.mp3");
  } else {
    playSound("sounds/winner.mp3");
  }
}

// close block finish
function closeBlock(box) {
  let block = document.querySelector(`.${box}`);
  let screen = document.querySelector(".block-finish");
  block.style.display = "none";
  screen.style.display = "none";
}

// remove balloon
document.addEventListener("click", (event) => {
  if (event.target.classList.contains("balloon")) {
    event.target.remove();
    if (!gameOver) {
      score++;
    }
    if (!gameOver && score === scoreWin) {
      // check finish
      showBlock("block-win");
      gameOver = true;
      updateTotal();
      clearInterval(game);
    }
    playSound("./sounds/pop.mp3");
    updateScore();
  }
});

// remove all balloons
function removeAll() {
  let balloons = document.querySelectorAll(".balloon");
  for (let balloon of balloons) {
    balloon.remove();
  }
}

// update score
function updateScore() {
  let scoreEdit = document.querySelector(".score");
  scoreEdit.textContent = score;
}

// update total
function updateTotal() {
  let totalScoreEdits = document.querySelectorAll(".total-score");
  total = score;
  for (let i = 0; i < totalScoreEdits.length; i++) {
    totalScoreEdits[i].textContent = total;
  }
}

// click button yes play again
let btnYes = document.querySelector(".btn-yes");
btnYes.onclick = () => {
  // << idea 1 >>
  // location.reload();

  // << idea 2>>
  reset();
};

// reset game
function reset() {
  score = 0;
  gameOver = 0;
  total = 0;
  updateScore();
  updateTotal();
  closeBlock("block-lose");
  startGame();
}
// click button no play again
let btnNo = document.querySelector(".btn-no");
btnNo.onclick = () => {
  closeBlock("block-lose");
};

// random
function random(bound) {
  return Math.floor(Math.random() * bound);
}

// create sound
function playSound(path) {
  let sound = document.createElement("audio");
  sound.src = path;
  sound.play();
  
}

// remvove sound
function pause() {
  let sound = document.querySelector(".sound-play");
  sound.pause();
}

// start
function startGame() {
  document.querySelector(".sound-play").play();
  game = setInterval(() => {
    createBalloon();
  }, (500 + random(800)) / (1 + score / 10));
}

// run game
startGame();
