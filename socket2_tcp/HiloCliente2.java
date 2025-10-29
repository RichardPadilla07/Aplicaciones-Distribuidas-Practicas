package socket2_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloCliente2 extends Thread {

    private Socket socketCliente2;

    String[] preguntas = { "1.- Capital de Francia?", "2.- Capital de España?", "3.- Capital de Italia?," };

    String[] respuestas = { "Paris", "Madrid", "Roma" };

    public HiloCliente2(Socket socketCliente2) {
        this.socketCliente2 = socketCliente2;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente2.getInputStream()));
            PrintWriter salida = new PrintWriter(socketCliente2.getOutputStream(), true);

            String respuestaServidor;
            int puntaje = 0;

            for (int i = 0; i < 3; i++) {
                // Enviar pregunta
                salida.println(preguntas[i]);

                // Recibir respuesta del cliente
                String datosRecibidos = entrada.readLine();
                if (datosRecibidos == null) break;
                
                System.out.println("Respuesta recibida: " + datosRecibidos);

                // Verificar la respuesta
                if (datosRecibidos.equalsIgnoreCase(respuestas[i])) {
                    respuestaServidor = "Correcto";
                    puntaje++;
                } else {
                    respuestaServidor = "Incorrecto";
                }
                salida.println(respuestaServidor);
            }
            
            // Enviar puntaje final
            salida.println("Puntaje final: " + puntaje + "/3");
            socketCliente2.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
