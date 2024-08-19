# Matplot é uma biblioteca para plotagem de gráficos,
# muito utilizada para visualização de dados.
# A biblioteca é importada com o nome de plt.

import matplotlib.pyplot as plt
from random import randrange, seed

seed(20042003)


def roll_dice(attempts):
    dice_numbers = []
    for dado in range(attempts):
        dice_numbers.append(randrange(1, 6))
    print(dice_numbers)
    return dice_numbers


numbers = roll_dice(100)

x = list(range(len(numbers)))
y = numbers

print(f'{type (x), type (y)}')

plt.plot(x, y, color="purple", marker=".")
plt.title("Lançamento de Dados")
plt.xlabel("Número de Lançamentos")
plt.ylabel("Número Sorteado")
plt.show()
