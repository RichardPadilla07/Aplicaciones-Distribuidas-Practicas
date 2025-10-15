package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class HiloCliente extends Thread {

    private DatagramSocket socket;
    private DatagramPacket paqueteEntrada;

    // Constructor
    public HiloCliente(DatagramSocket socket, DatagramPacket paqueteEntrada) {
        this.socket = socket;
        this.paqueteEntrada = paqueteEntrada;
    }

    @Override
    public void run() {

        // Extraer informacion del datagrama recibido
        String mensaje = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
        System.out.println("Mensaje recibido: " + mensaje);

        // Obtener la direccion IP del cliente
        InetAddress ip_cliente = paqueteEntrada.getAddress();

        // Obtener el puerto del cliente
        int puerto_cliente = paqueteEntrada.getPort();

        // Mensaje de respuesta
        String respuesta = "Hola, desde el servidor";

        // Arreglo de bytes para enviar datos
        byte[] bufferSalida = respuesta.getBytes();

        // Enviar la respuesta al cliente
        DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, ip_cliente,
                puerto_cliente);

        // Enviar el datagrama de respuesta al cliente
        try {
            socket.send(paqueteSalida);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
