# Dois retornos
def media(list):
    return (sum(list) / len(list), len(list))


print(media([1, 2, 3, 4, 5]))

# Atribuição múltipla
media, n = media([1, 2, 3, 4, 5])
print(media)
print(n)
