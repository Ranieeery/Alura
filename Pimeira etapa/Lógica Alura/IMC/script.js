let qtyText, soma = 0;

function breakLine(qty) {
    let line = ("<br>");
    return qty != null ? qtyText = line.repeat(qty) : qtyText = line;
}

function show(text, qty) {
    document.write(text + breakLine(qty));
}

function imc(name, weight, height, qty) {
    let imcCalc = weight / Math.pow(height, 2);
    show("O imc de " + name + " é " + imcCalc.toFixed(2), qty);
    soma += imcCalc;
}

function user() {
    let nameUser, weightUser, heightUser, qtyUser;

    nameUser = prompt("Insira o seu nome: ");
    weightUser = prompt("Insire seu peso: ");
    heightUser = prompt("Insira sua altura");
    let imcCalc = weightUser / Math.pow(heightUser, 2);
    show(nameUser + ", o seu imc é " + imcCalc.toFixed(2) + imcTotal(imcCalc), 2);
    show("FIM")

}

function imcTotal(imcCalc) {
    if (imcCalc > 35) {
        return " e está alto."
    } else if (imcCalc < 18.5) {
        return " e está baixo."
    } else {
        return " e está na média."
    }

}

imc("Pedro", 82, 1.86);
imc("Ronaldo", 79, 1.75, 2);
show("A soma dos imc de todos presentes é " + soma.toFixed(2));

show("<h2>*** Calcule seu IMC ***</h2>", 2)
//user();
show("<a href=\"../index.html\">Menu</a>");