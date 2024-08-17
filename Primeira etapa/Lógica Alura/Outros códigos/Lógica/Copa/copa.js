function breakLine(qty) {
    let line = ("<br>");
    return qty != null ? qtyText = line.repeat(qty) : qtyText = line;
}

function show(text, qty) {
    document.write(text + breakLine(qty));
}

let anoCopa = 1930;

while(anoCopa <= 2022){
    show("Houve copa em " + anoCopa);
    anoCopa += 4;
}

show("FIM");