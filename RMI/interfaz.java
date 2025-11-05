package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaz extends Remote {

    // metodos que el cliente puede invocar de forma remota
    float sumar(float a, float b) throws RemoteException;
    float restar (float a, float b) throws RemoteException;
    float  multiplicar (float a, float b) throws RemoteException;
    float  dividir (float a, float b) throws RemoteException;

    //conversion de la temperatura
    float celsiusAFahrenheit(float celsius) throws RemoteException;
    float fahrenheitACelsius(float fahrenheit) throws RemoteException;

    void registrarCliente(String ip) throws RemoteException;
    void desconectarCliente(String ip) throws RemoteException;
}
