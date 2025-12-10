from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/multiplicacion')
def operacion():
    a = float(request.args.get('a', 0))
    b = float(request.args.get('b', 0))
    return jsonify({'resultado': a * b})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5003)
