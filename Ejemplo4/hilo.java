package Ejemplo4;

public class hilo extends Thread {

    // esto es un objeto estatico
    private static final Object lock = new Object(); // Objeto de bloqueo para sincronización

    // Atributo
    private int idHilo;

    // Constructor
    public hilo(int i) {
        this.idHilo = i;
    }

    // Metodo run
    @Override
    public void run() {
        imprimir();
    }

    // Metodo imprimir
    public void imprimir() {

        synchronized (lock) {
            System.out.println("Hilo " + idHilo + "inicia impresion");
            for (int i = 0; i <= 5; i++) {
                System.out.println("Hilo " + idHilo + "# " + i);
            }
            System.out.println("Hilo " + idHilo + "finaliza impresion");

        }
    }
}
