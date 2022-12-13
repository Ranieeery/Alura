# Comandos Git Bash

Navegação inicial se faz com dir (Windows) e cd (Linux) até o local onde será o repositório.

[Git Cheatsheet](https://devhints.io/git-log)

```shell
# Inicia um repositório no diretório atual
$ git init

# Navega entre diretórios, caso tenha espaço no nome do diretório este deverá ser citado entre aspas simples
$ cd pasta
$ cd 'Documents/Curso Git e GitHub' 


# Mostra status do projeto como branch, commits, arquivos"
$ git status

# Configuração inicial do Git:
$ git config --local user.name "Seu nome aqui"
$ git config --local user.email "seu@email.aqui"

# Adicionar arquivos ao repositório. Para adicionar todos basta trocar o nome por um " . "
$ git add index.html
$ git add .

# Commit
$ git commit -m "mensagem do commit"

# Histórico do repositório, aperte Q para sair
$ git log
    > commit c1d8b413e9fdd58d39ccd0bae636a7a87090f240 (HEAD -> main, origin/main, origin/HEAD)
    Author: Ranieeery <raniery2003@hotmail.com>
    Date:   Tue Dec 13 11:26:19 2022 -0300

        final css course

$ git log --oneline
$ git log -p

# Arquivos inseridos em .gitignore serão ignorados pelo git
$ git add .gitignore
```

# Repositórios remotos

```shell
# Gera um local para onde vão as alterações
$ git init --bare

# Adicionar em um endereço
$ git remote add nome endereco
 -> git remote add meurepositorio C:\Users\actdigital\Desktop\Alura\Servidor

# Lista locais remotos
$ git remote
$ git remote -v
$ git remote rename nomeatual nomenovo

# Clonar repositório
$ git clone endereco nomepasta
    -> git clone https://github.com/Ranieeery/Ranieeery.git readme 

# Enviar dados
$ git push nome branch
    -> git push meurepositorio master    
"A branch principal costuma ser main ou master"

# Receber dados
$ git pull nome branch
    -> git pull meurepositorio master
```
# GitHub

```shell
$ git remote add origin link
$ git push -u origin master

```


