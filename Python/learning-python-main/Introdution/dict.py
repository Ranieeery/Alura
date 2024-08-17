dicionario = {'Fusca': 1969, 'Gol': 1980,
              'Palio': 1999, 'Uno': 2002, 'Celta': 2001}
print(dicionario)

# Criando dicionário com zip
carros = tuple(['Fusca', 'Gol', 'Palio', 'Uno', 'Celta'])
anos = tuple([1969, 1980, 1999, 2002, 2001])

dicionario_zip = dict(zip(carros, anos))
print(dicionario_zip)

# Acessando elementos
list(zip(dicionario.keys(), dicionario.values()))
print(dicionario['Fusca'])

# Adicionando elementos
dicionario['Civic'] = 2007
print(dicionario)

# Removendo elementos
del dicionario['Civic']
print(dicionario)

# Métodos
print(dicionario.keys())
print(dicionario.values())
print(dicionario.items())

# Operações
print('Fusca' in dicionario)
print('Ferrari' not in dicionario)
print(len(dicionario))
print(sum(dicionario.values()))

# Funções
print(max(dicionario))
print(min(dicionario))

# Conversão
print(list(dicionario))
print(set(dicionario))

# Desempacotamento
carro1, carro2, carro3, carro4, carro5 = dicionario
print(carro1, carro2, carro3, carro4, carro5)

# Comparação
print(dicionario == {'Fusca': 1969, 'Gol': 1980,
      'Palio': 1999, 'Uno': 2002, 'Celta': 2001})

# Imutabilidade
dicionario['Fusca'] = 1970
print(dicionario)

# Iterando
for carro in dicionario:
    print(carro)

for carro, ano in dicionario.items():
    print(carro, ano)

# Compreensão
print({carro: ano for carro, ano in dicionario.items() if ano > 2000})
