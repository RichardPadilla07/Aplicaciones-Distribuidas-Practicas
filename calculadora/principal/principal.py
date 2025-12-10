from flask import Flask, request, jsonify
import requests

app = Flask(__name__)

MICROSERVICIOS = {
    'suma': 'http://suma:5001/suma',
    'resta': 'http://resta:5002/resta',
    'multiplicacion': 'http://multiplicacion:5003/multiplicacion',
    'division': 'http://division:5004/division'
}

@app.route('/calcular/<operacion>')
def calcular(operacion):
    a = request.args.get('a')
    b = request.args.get('b')
    if operacion not in MICROSERVICIOS:
        return jsonify({'error': 'Operación no válida'}), 400
    res = requests.get(MICROSERVICIOS[operacion], params={'a': a, 'b': b})
    return res.json()

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
