package Ejemplo1;

public class HiloB extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hilo B: B" + i);
        }

    }

}
