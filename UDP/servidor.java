package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class servidor {

    public static void main(String[] args) {

        // Puerto en el que escuchara el servidor
        int puerto = 5000;

        // Crear el socket UPD
        try {

            DatagramSocket socket = new DatagramSocket(puerto);
            System.out.println("Servidor iniciado...");
            

            // Arreglo de bytes para recibir los datos
            byte[] bufferEntrada = new byte[1024];

            // Creamos el datagrama para recibir los datos
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);

            // Esprando recibir el mensaje del cliente
            socket.receive(paqueteEntrada);

            // Tenemos que enviar el socket y el datagrama para que sepa en donde se esta
            // estableciendo la conexion
            HiloCliente hilo = new HiloCliente(socket, paqueteEntrada);
            hilo.start();

            // Capturamos todas las excepciones que puedan ocurrir
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
