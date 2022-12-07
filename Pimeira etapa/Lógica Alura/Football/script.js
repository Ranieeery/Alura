function breakLine(qty) {
    let line = ("<br>");
    return qty != null ? qtyText = line.repeat(qty) : qtyText = line;
}

function show(text, qty) {
    document.write(text + breakLine(qty));
}

function score(points) {
    if (points > lastYear) {
        show("A pontuação está melhor que no ano passado por " + (points - lastYear) + " pontos.");
    } else if (points < lastYear) {
        show("A pontuação está pior que no ano passado por " + (lastYear - points) + " pontos.");
    } else {
        show("Sua pontuação está igual ao ano passado.");
    }
    show("FIM")
}

let victory, draw, lastYear, points;
victory = parseInt(prompt("Insira o número de vitórias."));
draw = parseInt(prompt("Insira o número de empates."));
lastYear = parseInt(prompt("Insira a pontuação do ano passado."));

points = (victory * 3) + draw;
show("O total de pontos é " + points, 2);
score(points);

show("<a href=\"../index.html\">Calculadora de IMC</a>");