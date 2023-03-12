let canvas = document.querySelector('canvas');
let brush = canvas.getContext('2d');

brush.fillStyle = 'white';
brush.fillRect(0, 0, 600, 400);

let rad = 10;
let randomX;
let randomY;

function showCircle(x, y, rad, color) {
    brush.fillStyle = color;
    brush.beginPath();
    brush.arc(x, y, rad, 0, 2 * Math.PI);
    brush.fill();
}

function screenClear() {
    brush.clearRect(0, 0, 600, 400);
}

function desenhaAlvo(x, y) {
    showCircle(x, y, rad + 20, 'red');
    showCircle(x, y, rad + 10, 'white');
    showCircle(x, y, rad, 'red');
}

function circlePos(max) {
    return Math.floor(Math.random() * max);
}

function screenUpdate() {
    screenClear();
    randomX = circlePos(600);
    randomY = circlePos(400);
    desenhaAlvo(randomX, randomY);
}

setInterval(screenUpdate, 1000);

document.addEventListener("click", function (mouseClick) {
    let x = mouseClick.pageX - canvas.offsetLeft;
    let y = mouseClick.pageY - canvas.offsetTop;
    if ((x > randomX - rad)
        && (x < randomX + rad)
        && (y > randomY - rad)
        && (y < randomY + rad)) {

        alert('Acertou!');

    }
})