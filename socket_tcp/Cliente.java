package socket_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {

        try {
            // Crear el socket del cliente para conectarse al servidor
            Socket socketCliente = new Socket("localhost", 4000); // poner IPS adecuadas

            // Crear los buffers de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            // Este es el buffer de salida
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);

            while (true) {

                // Recibir mensajes
                String datosRecibidos = entrada.readLine();
                System.out.println(datosRecibidos);

                // Enviar mensajes
                String datosEnviar = "Hola, soy el cliente";
                salida.println(datosEnviar);
            }

        } catch (

        Exception e) {

            e.printStackTrace();
        }
    }

}
