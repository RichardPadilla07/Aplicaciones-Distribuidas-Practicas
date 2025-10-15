package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

    public static void main(String[] args) {
        // Puerto del servidor
        int puertoServidor = 5000; // Aqui puede ser cualquier puerto que no este en uso

        // Crear el socket UPD
        try {
            InetAddress ip_servidor = InetAddress.getByName("Localhost"); // Aqui va la IP del servidor
            DatagramSocket socket = new DatagramSocket();

            /////// TODO ESTO ES PARA ENVIAR EL MENSAJE AL SERVIDOR ///////
            // Mensaje de respuesta
            String respuesta = "Hola, desde el servidor";

            // Arreglo de bytes para enviar datos
            byte[] bufferSalida = respuesta.getBytes();

            // Enviar la respuesta al cliente
            DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, ip_servidor,
                    puertoServidor);

            // Enviar el datagrama de respuesta al cliente
            socket.send(paqueteSalida);

            /////// TODO ESTO ES PARA RECIBIR EL MENSAJE DEL SERVIDOR ///////
            // Arreglo de bytes para recibir los datos
            byte[] bufferEntrada = new byte[1024];

            // Creamos el datagrama para recibir los datos
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);

            // Esprando recibir el mensaje del cliente
            socket.receive(paqueteEntrada);

            // Extraer informacion del datagrama recibido
            String mensaje = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength()); //
            System.out.println("Mensaje recibido: " + mensaje);


            // Cerramos el socket
            socket.close();

        } catch (Exception e) {
        }

    }

}
