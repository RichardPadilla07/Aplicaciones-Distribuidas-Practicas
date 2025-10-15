package Ejemplo3;

public class hilo extends Thread {

    @Override
    public void run() {
        contador("Hilo"); // Llama al metodo contador
    }


    // el synchronized hace que el metodo sea sincronizado y no pueda ser accedido por otro hilo hasta que termine
    public synchronized static void contador(String m) {
        for (int i = 0; i <= 7; i++) {
            System.out.println(m + " " + i);

        }

    }

}
