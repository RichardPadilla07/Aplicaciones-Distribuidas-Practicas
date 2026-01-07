import requests
from collections import Counter

respuestas = []

for _ in range(100):
    respuesta = requests.get('http://localhost:8080')
    respuestas.append(respuesta.text.strip())

contador=Counter(respuestas)
print(contador) 
