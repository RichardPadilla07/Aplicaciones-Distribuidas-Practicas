package Ejemplo5;

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
            System.out.println("Iniciando descarga del archivo " + idHilo);
            System.out.println("Descargando archivo" + idHilo + ".pdf (3 MB)...");
            System.out.println("Descarga completa del archivo" + idHilo + ".pdf \n");

        }
    }
}
