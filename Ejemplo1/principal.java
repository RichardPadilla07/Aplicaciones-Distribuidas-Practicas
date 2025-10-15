package Ejemplo1;

public class principal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hilo principal: P" + i);
        }

        // Instanciar objetos (debe tener el nombre del archivo)
        HiloA hilo1 = new HiloA();
        HiloB hilo2 = new HiloB();

        // Iniciar hilos
        hilo1.start();
        hilo2.start();
    }
}
