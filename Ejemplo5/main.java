package Ejemplo5;

public class main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            hilo nHilo = new hilo(i); // Instancia del hilo
            nHilo.start(); // Iniciar el hilo
        }

    }

}
