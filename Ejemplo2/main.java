package Ejemplo2;

public class main {

    public static void mensaje(int v) {
        for (int i = 0; i < v; i++) {
            System.out.println("Principal " + i);
        }

    }

    public static void main(String[] args) {
        hilo h1 = new hilo();
        h1.start();
        mensaje(3);
        
        // h1.mensaje(5);

    }

}
