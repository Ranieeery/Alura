let canvas = document.querySelector('canvas');
let brush = canvas.getContext('2d');
brush.fillStyle = 'lightgray';
brush.fillRect(0, 0, 600, 400);

function screenCircle(x, y, raio) {

    brush.fillStyle = 'blue';
    brush.beginPath();
    brush.arc(x, y, raio, 0, 2 * Math.PI);
    brush.fill();
}

function screenClear() {
    brush.clearRect(0, 0, 600, 400);
}

var x = 20;

function screeanUpdate() {
    screenClear();
    screenCircle(x, 20, 10);
    x++;
}

setInterval(screeanUpdate, 10);