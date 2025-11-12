from flask import Flask

servidor = Flask (__name__)

@servidor.route('/')
def hola():
    return "Richard: Hola desde servidor1"

if __name__ == '__main__':
    servidor.run (host='0.0.0.0', port=5000)


