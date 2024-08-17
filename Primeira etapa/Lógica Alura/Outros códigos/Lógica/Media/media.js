function breakLine(qty) {
    let line = ("<br>");
    return qty != null ? qtyText = line.repeat(qty) : qtyText = line;
}

function show(text, qty) {
    document.write(text + breakLine(qty));
}

let numUm = 1;
let numFamiliar = parseInt(prompt("Insira o total de familiares")), totalIdade = 0;
while(numUm <= numFamiliar){
    let soma = parseInt(prompt(`Insira a idade do ${numUm}° familiar:`));
    totalIdade += soma;
    numUm++;
}
show("A média das idades é " + Math.round(totalIdade/numFamiliar));
show("Fim")