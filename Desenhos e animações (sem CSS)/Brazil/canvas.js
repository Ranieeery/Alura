let canvas = document.querySelector('canvas');
var brush = canvas.getContext('2d');

brush.fillStyle = 'green';
brush.fillRect(0, 0, 600, 400);
brush.strokeStyle = 'black';
brush.strokeRect(0, 0, 600, 400);

brush.fillStyle = 'yellow';
brush.beginPath();
brush.moveTo(300, 100);
brush.lineTo(100, 200);
brush.lineTo(500, 200);
brush.fill();


brush.beginPath();
brush.moveTo(300, 300);
brush.lineTo(100, 200);
brush.lineTo(500, 200);
brush.fill();

brush.fillStyle = 'blue';
brush.beginPath();
brush.arc(300, 200, 70, 0, 2 * 3.14);
brush.fill();
