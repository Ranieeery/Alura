// As "chaves" de criptografia que utilizaremos são:
// A letra "e" é convertida para "enter"
// A letra "i" é convertida para "imes"
// A letra "a" é convertida para "ai"
// A letra "o" é convertida para "ober"
// A letra "u" é convertida para "ufat"

const textareaInput = document.querySelector("#textarea");
const textareaMsg = document.querySelector("#textarea--show");

const buttonCrip = document.querySelector(".button--crip");
const buttonDescrip = document.querySelector(".button--descrip");
const buttonCopy = document.querySelector(".button--copy");

let css = document.querySelector(".input--msg");
let css2 = document.querySelector(".msg--warn");

function criptografar(stringTexto) {
  let matriz = [
    ["e", "enter"],
    ["i", "imes"],
    ["a", "ai"],
    ["o", "ober"],
    ["u", "ufat"],
  ];
  stringTexto = stringTexto.toLowerCase();

  for (let i = 0; i < matriz.length; i++) {
    if (stringTexto.includes(matriz[i][0])) {
      stringTexto = stringTexto.replaceAll(matriz[i][0], matriz[i][1]);
    }
  }
  return stringTexto;
}

buttonCrip.addEventListener("click", () => {
  const textoCrip = criptografar(textareaInput.value);
  textareaMsg.value = textoCrip;
  textareaInput.value = "";

  css.style.cssText =
    "background: #FFF;" +
    "background-image: none" +
    "background-repeat: no-repeat;" +
    "background-position-x: center;" +
    "background-position-y: 5em;" +
    "margin-top: .5rem;" +
    "margin-left: 10rem;" +
    "padding: 20px 20px 10px 30px;" +
    "font-weight: bold;" +
    "resize: none;" +
    "border: none;" +
    "border-radius: 32px;" +
    "color: #0A3871;" +
    "position: fixed;" +
    "width: 15em;" +
    "height: 30em;" +
    "box-shadow: 0px 24px 32px -8px rgba(0, 0, 0, 0.08);";

  css2.style.display = "none";

  buttonCopy.style.cssText =
    "position: relative;" +
    "margin-left: 370px;" +
    "margin-top: 690px;" +
    "display: inline;";
});

function descriptografar(stringTexto) {
  let matriz = [
    ["e", "enter"],
    ["i", "imes"],
    ["a", "ai"],
    ["o", "ober"],
    ["u", "ufat"],
  ];
  stringTexto = stringTexto.toLowerCase();

  for (let i = 0; i < matriz.length; i++) {
    if (stringTexto.includes(matriz[i][1])) {
      stringTexto = stringTexto.replaceAll(matriz[i][1], matriz[i][0]);
    }
  }
  return stringTexto;
}

buttonDescrip.addEventListener("click", () => {
  const textoDescrip = descriptografar(textareaInput.value);
  textareaMsg.value = textoDescrip;
  textareaInput.value = "";

  css.style.cssText =
    "background: #FFF;" +
    "background-image: none" +
    "background-repeat: no-repeat;" +
    "background-position-x: center;" +
    "background-position-y: 5em;" +
    "margin-top: .5rem;" +
    "margin-left: 10rem;" +
    "padding: 20px 20px 10px 30px;" +
    "font-weight: bold;" +
    "resize: none;" +
    "border: none;" +
    "border-radius: 32px;" +
    "color: #0A3871;" +
    "position: fixed;" +
    "width: 15em;" +
    "height: 30em;" +
    "box-shadow: 0px 24px 32px -8px rgba(0, 0, 0, 0.08);";

  css2.style.display = "none";

  buttonCopy.style.cssText =
    "position: relative;" +
    "margin-left: 370px;" +
    "margin-top: 690px;" +
    "display: inline;";
});

buttonCopy.addEventListener("click", () => {
  navigator.clipboard.writeText(textareaMsg.value);
});