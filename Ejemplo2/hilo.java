package Ejemplo2;

public class hilo extends Thread {

    @Override
    public void run() {
        mensaje(5);
    }

    public void mensaje(int v) {
        for (int i = 0; i < v; i++) {
            System.out.println("Hilo " + i);
        }
    }

    public static void main(String[] args) {
        hilo h = new hilo();
        h.start();
    }

}
