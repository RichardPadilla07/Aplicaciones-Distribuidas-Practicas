package socket_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloCliente extends Thread {

    private Socket socketCliente;

    public HiloCliente(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    @Override
    public void run() {
        try {
            // Crear los buffers de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            // Este es el buffer de salida
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);

            // Variable para la respuesta
            String respuesta;
            int puntaje = 0;

            while (true) {

                // Pregunta 1
                // Enviar mensajes
                String datosEnviar = "Cuanto es 2 + 2?";
                salida.println(datosEnviar);

                // Recibir mensajes
                String datosRecibidos = entrada.readLine();
                System.out.println(datosRecibidos);

                if (datosRecibidos.equalsIgnoreCase("4")) {
                    respuesta = "Correcto";
                    puntaje++;

                } else {
                    respuesta = "Incorrecto";
                }
                salida.println(respuesta + " \n" + "Cuanto es 5 * 6?"); // Pregunta 2
                datosRecibidos = entrada.readLine();
                System.out.println(datosRecibidos);

                if (datosRecibidos.equalsIgnoreCase("30")) {
                    respuesta = "Correcto";
                    puntaje++;
                } else {
                    respuesta = "Incorrecto";
                }
                salida.println(respuesta + " \nCuanto es 12 / 4?");// Pregunta 3
                datosRecibidos = entrada.readLine();
                System.out.println(datosRecibidos);

                if (datosRecibidos.equalsIgnoreCase("3")) {
                    respuesta = "Correcto";
                    puntaje++;
                } else {
                    respuesta = "Incorrecto";
                }
                salida.println(respuesta + " \nTotal Puntaje: " + puntaje); // Con esto enviamos la respuesta al cliente
                break;

            }
            System.out.println("Cliente desconectado.");
            socketCliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
