carros = tuple(['Fusca', 'Gol', 'Palio', 'Uno', 'Celta'])

type(carros)

# Acessando elementos
print(carros[0])  # Primeiro elemento
print(carros[-1])
print(carros[1:3])

for carro in carros:
    print(carro)

# Métodos
print(carros.count('Fusca'))
print(carros.index('Palio'))

# Operações
print(carros + ('Civic', 'Corolla'))
print(carros * 2)

# Funções
print(len(carros))
print(max(carros))
print(min(carros))

# Conversão
print(list(carros))
print(set(carros))

# Desempacotamento
carro1, carro2, carro3, carro4, carro5 = carros
print(carro1, carro2, carro3, carro4, carro5)

# Comparação
print(carros == ('Fusca', 'Gol', 'Palio', 'Uno', 'Celta'))
