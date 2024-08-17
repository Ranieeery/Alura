function breakLine(qty) {
    let line = ("<br>");
    return qty != null ? qtyText = line.repeat(qty) : qtyText = line;
}

function show(text, qty) {
    document.write(text + breakLine(qty));
}

function check() {
    const answer = document.querySelector("input");
    if (parseInt(answer.value) < findNumber) {
        alert("Valor inserido menor");
    } else if (parseInt(answer.value) > findNumber) {
        alert("Valor inserido maior");
    } else {
        show('<div style="background-color:green; color:gold; text-align: center"><h2>Você acertou!!</h2><a href="../index.html" style="color: white;">Voltar para o menu</a></div>');
    }

}
show("<h1>Adivinhe o número</h1> Digite um número de 1 a 100 para começar <br>");

let findNumber = Math.round(Math.random() * 100)
document.write('<input type="text" id="answerExercise" placeholder="Digite seu palpite" autofocus="autofocus" />');
document.write("<button>Resposta</button>");
const button = document.querySelector("button");
button.onclick = check;
