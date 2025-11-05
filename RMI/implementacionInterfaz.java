package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class implementacionInterfaz extends UnicastRemoteObject implements interfaz {

    // Constructor
    public implementacionInterfaz() throws RemoteException {
        super();
    }

    // Implementar todos los metodos
    @Override
    public float sumar(float a, float b) throws RemoteException {

        return a + b;
    }

    @Override
    public float restar(float a, float b) throws RemoteException {

        return a - b;
    }

    @Override
    public float multiplicar(float a, float b) throws RemoteException {

        return a * b;
    }

    @Override
    public float dividir(float a, float b) throws RemoteException {

        if (b == 0) {
            throw new RemoteException("Error: Division por cero");
        }
        return a / b;
    }

    //convesion de temperatura
    public float celsiusAFahrenheit(float celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public float fahrenheitACelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public String mensaje(String n) {
        return "Hola " + n + " bienvenido a RMI";
    }

    

    @Override
    public void registrarCliente(String ip) throws RemoteException {
        System.out.println("Cliente conectado: " + ip);
    }

    @Override
    public void desconectarCliente(String ip) throws RemoteException {
        System.out.println("Cliente desconectado: " + ip);
    }

}
