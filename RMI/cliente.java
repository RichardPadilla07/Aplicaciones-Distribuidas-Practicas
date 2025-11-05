package RMI;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {

        try {
            // Conexión al servidor
            Registry registro = LocateRegistry.getRegistry("172.31.115.141", 1099);
            interfaz objRemoto = (interfaz) registro.lookup("ClienteRemoto");

            String ipCliente = InetAddress.getLocalHost().getHostAddress();
            objRemoto.registrarCliente(ipCliente);
            System.out.println("Conectado al servidor desde: " + ipCliente);

            Scanner input = new Scanner(System.in);
            int opcionPrincipal;

            do {
                System.out.println("\n===== MENÚ PRINCIPAL =====");
                System.out.println("1. Calculadora remota");
                System.out.println("2. Conversor de temperatura");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                opcionPrincipal = input.nextInt();

                switch (opcionPrincipal) {
                    case 1 -> menuCalculadora(objRemoto, input);
                    case 2 -> menuConversor(objRemoto, input);
                    case 3 -> {
                        System.out.println("Desconectando del servidor...");
                        objRemoto.desconectarCliente(ipCliente);
                    }
                    default -> System.out.println("Opción no válida.");
                }

            } while (opcionPrincipal != 3);

            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ===== Submenú de calculadora =====
    public static void menuCalculadora(interfaz objRemoto, Scanner input) {
        int opcion;
        float a, b, resultado;

        try {
            do {
                System.out.println("\n===== CALCULADORA REMOTA =====");
                System.out.println("1. Sumar");
                System.out.println("2. Restar");
                System.out.println("3. Multiplicar");
                System.out.println("4. Dividir");
                System.out.println("5. Volver al menú principal");
                System.out.print("Seleccione una opción: ");
                opcion = input.nextInt();

                if (opcion >= 1 && opcion <= 4) {
                    System.out.print("Ingrese el primer número: ");
                    a = input.nextFloat();
                    System.out.print("Ingrese el segundo número: ");
                    b = input.nextFloat();

                    switch (opcion) {
                        case 1 -> resultado = objRemoto.sumar(a, b);
                        case 2 -> resultado = objRemoto.restar(a, b);
                        case 3 -> resultado = objRemoto.multiplicar(a, b);
                        case 4 -> resultado = objRemoto.dividir(a, b);
                        default -> resultado = 0;
                    }

                    System.out.println("Resultado: " + resultado);
                }

            } while (opcion != 5);
        } catch (Exception e) {
            System.out.println("Error en la calculadora: " + e.getMessage());
        }
    }

    // ===== Submenú de conversor =====
    public static void menuConversor(interfaz objRemoto, Scanner input) {
        int opcion;
        float temp, resultado;

        try {
            do {
                System.out.println("\n===== CONVERSOR DE TEMPERATURAS =====");
                System.out.println("1. Celsius a Fahrenheit");
                System.out.println("2. Fahrenheit a Celsius");
                System.out.println("3. Volver al menú principal");
                System.out.print("Seleccione una opción: ");
                opcion = input.nextInt();

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese la temperatura en °C: ");
                        temp = input.nextFloat();
                        resultado = objRemoto.celsiusAFahrenheit(temp);
                        System.out.println(temp + "°C = " + resultado + "°F");
                    }
                    case 2 -> {
                        System.out.print("Ingrese la temperatura en °F: ");
                        temp = input.nextFloat();
                        resultado = objRemoto.fahrenheitACelsius(temp);
                        System.out.println(temp + "°F = " + resultado + "°C");
                    }
                    case 3 -> System.out.println("Volviendo al menú principal...");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 3);
        } catch (Exception e) {
            System.out.println("Error en el conversor: " + e.getMessage());
        }
    }
}