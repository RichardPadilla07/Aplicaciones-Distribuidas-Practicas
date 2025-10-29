package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        int puertoServidor = 4000;

        try {
            InetAddress ip_servidor = InetAddress.getByName("localhost");
            DatagramSocket socket = new DatagramSocket();
            String respuesta = "";

            do {
                // Obtener mensaje del usuario
                Scanner scanner = new java.util.Scanner(System.in);
                System.out.print("Mensaje para el servidor (escriba 'exit' para salir): ");
                respuesta = scanner.nextLine();

                // Enviar mensaje al servidor
                byte[] bufferSalida = respuesta.getBytes();
                DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, ip_servidor, puertoServidor);
                socket.send(paqueteSalida);

                // Si el usuario escribió exit, salimos
                if (respuesta.equalsIgnoreCase("exit")) {
                    System.out.println("Cerrando conexión...");
                    socket.close();
                    break;
                }

                // Recibir respuesta del servidor
                byte[] bufferEntrada = new byte[1024];
                DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);
                socket.receive(paqueteEntrada);

                String mensaje = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
                System.out.println("Mensaje recibido: " + mensaje);

            } while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
