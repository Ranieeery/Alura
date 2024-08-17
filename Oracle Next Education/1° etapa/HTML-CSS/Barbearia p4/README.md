# Seletores avançados CSS3

* Selecionar filhos diretos:

```css
main > p {
    background: red; 
}
```

* Selecionar o primeiro irmão:

```css
img + p { 
    background: blue;
}
```

* Selecionar todos elementos após a ocorrência de outro:

```css
img ~ p {
    background: yellow
} 
```

* Excluir itens não inclusos no id/classe:

```css
.principal p:not(#missao) {
    background: orange;
}
```