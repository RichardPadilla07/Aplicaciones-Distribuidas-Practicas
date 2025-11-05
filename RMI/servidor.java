package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class servidor {

    public static void main(String[] args) {

        try {
            // Instanciar la implementacion e la interfaz
            interfaz objRemoto = new implementacionInterfaz();

            // Crear registro RMI en un puerto especifico
            Registry registro = LocateRegistry.createRegistry(1099);

            // vincular la implementacion de la interfaz con un nombre especifico:
            // "ClienteRemoto"
            registro.rebind("ClienteRemoto", objRemoto);

            System.out.println("Servidor iniciado...");

        } catch (RemoteException e) {
            e.printStackTrace();

        }

    }
}
