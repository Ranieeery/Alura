function breakLine(qty) {
    let line = ("<br>");
    return qty != null ? qtyText = line.repeat(qty) : qtyText = line;
}

function show(text, qty) {
    document.write(text + breakLine(qty));
}


let numTable = parseInt(prompt("Insira um número para ver sua tabuada"))
for (let i = 1; i <= 10; i++){
    show(`${numTable} * ${i} = ${numTable * i}`);
}
show("Fim")