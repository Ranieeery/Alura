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
$ git log --graph

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
# Adiciona um vínculo com o repositório online
$ git remote add origin link

# Push para o repositório
$ git push -u origin master

# Para trocar a branch de master para main
$ git branch -m master main
$ git push -u origin main

```

# Branch e merge

```shell
# Visualiza branches atuais
$ git branch

# Cria nova branch
$ git branch nome
    -> git branch formContato

# Troca de branch
$ git checkout nome
    -> git checkout formContato

# Cria a branch e muda para ele
$ git checkout -b nome
```
```shell
# Junta duas branches
$ git merge nome
    -> git merge formContato 

$ git rebase nome
    -> git rebase formContato

"O merge junta os trabalhos e gera um merge commit. O rebase aplica os commits de outra branch na branch atual."
```
| Merge | Rebase |
| --- | --- |
| Funde duas branches | Integra as mudanças de uma branch em outra |
| Todo registro permanece nos logs | Logs lineares |
| Todos os commits serão unidos em apenas um | Os commits são integrados e o mesmo número de commits são adicionados na master branch |
| Usado quando a branch alvo é uma branch compartilhada | Deve ser usada quando o alvo é uma branch privada |

![merge x branch](https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2022/01/fig13.png)

# Histórico de versões

```shell
# Remove alterações antes de adicionar para um commit
$ git checkout -- arquivo
    -> git checkout -- index.html

# Remove alterações adicionadas para um commit
$ git reset HEAD arquivo
    -> git reset HEAD index.html

# Remove alterações após o commit
$ git revert hash
    -> git revert 4ff313864729eda2e45d5e4607eade3f5c8f146b

# Salva o estado dos arquivos sem adicionar para commit
$ git stash

# Lista as versões salvas
$ git stash list

# Retorna para o estado do arquivo
$ git stash pop
    
# Retorna para outro commit anterior
$ git log --oneline
$ git checkout hash
    -> git checkout 4ff3138
$ git checkout -b nome
    -> git checkout -b backlog  

# Diferença do commit para a versão em desenvolvimento
$ git diff

# Diferença entre dois commits
$ git diff hash..hash
    -> git diff 2c47611..675e22d
```

# Tags e releases

```shell
# Mostrar tags
$ git tag

# Criar tag
$ git tag -a versao
 -> git tag -a v0.1.0 -m "Versão beta"

# Push para gerar release
$ git push nome tag
 -> git push meuSite v0.1.0
$ git push origin v0.1.0
```
