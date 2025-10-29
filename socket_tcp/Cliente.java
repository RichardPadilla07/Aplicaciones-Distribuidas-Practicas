package socket_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        try {
            // Crear el socket del cliente para conectarse al servidor
            Socket socketCliente = new Socket("localhost", 4000); // poner IPS adecuadas

            // Crear los buffers de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            // Este es el buffer de salida
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);

            Scanner input = new Scanner(System.in);
            while (true) {

                // Recibir mensajes
                String datosRecibidos = entrada.readLine();
                System.out.println(datosRecibidos);

                if (datosRecibidos.contains("Total")) {
                    // Si el mensaje contiene el puntaje total, podemos finalizar la comunicación
                    socketCliente.close();
                    break;
                }

                // Enviar mensajes
                System.out.println("Ingresa su mensaje: ");
                String datosEnviar = input.nextLine();
                salida.println(datosEnviar);
            }
            System.out.println("Saliendo del servidor...");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
