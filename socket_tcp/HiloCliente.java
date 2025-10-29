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

            while (true) {

                // Enviar mensajes
                String datosEnviar = "Hola desde el servidor";
                salida.println(datosEnviar);

                // Recibir mensajes
                String datosRecibidos = entrada.readLine();
                System.out.println(datosRecibidos);

            }

            // Preguntas

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
