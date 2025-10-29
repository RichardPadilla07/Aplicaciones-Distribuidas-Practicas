package socket_tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 4000;

        try {

            // Crear el socket del servidor
            ServerSocket socketServidor = new ServerSocket(puerto);
            System.out.println("Esperando conexiones...");

            while (true) {
                // Esperar la conexion de los clientes
                Socket socketCliente = socketServidor.accept();

                // Hilo cliente para manejar la conexion del cliente
                HiloCliente hilo = new HiloCliente(socketCliente);
                hilo.start();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
