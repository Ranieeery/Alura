function breakLine(qty) {
    let line = ("<br>");
    return qty != null ? qtyText = line.repeat(qty) : qtyText = line;
}

function show(text, qty) {
    document.write(text + breakLine(qty));
}

function inputCheck() {
    if (inLog == 10) {
        alert("Você acertou")
    } else {
        alert("Você errou");
    }
}

let inLog = document.querySelector("input");
let button = document.querySelector("button");
console.log(inLog);
button.onclick = inputCheck;