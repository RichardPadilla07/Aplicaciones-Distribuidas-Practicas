package socket2_tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor2 {
    public static void main(String[] args) {
        int puerto2 = 4000;

        try {

            // Crear el socket del servidor
            ServerSocket socketServidor2 = new ServerSocket(puerto2);
            System.out.println("Esperando conexiones...");

            while (true) {
                // Esperar la conexion de los clientes
                Socket socketCliente2 = socketServidor2.accept();

                // Hilo cliente para manejar la conexion del cliente
                HiloCliente2 hilo2 = new HiloCliente2(socketCliente2);
                hilo2.start();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
