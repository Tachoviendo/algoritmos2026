package ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
Ejercicio 11: lectura desde archivo y desde teclado.
Todo está separado en métodos estáticos para mantener clara la responsabilidad de cada parte.
*/
public class Principal {

    // ===== PARTE A: leer desde archivo =====
    // El archivo tiene que tener este formato (una cosa por línea):
    //   línea 1: un entero
    //   línea 2: un real (double)
    //   línea 3: una cadena de texto
    public static void leerEntradaArchivo(String rutaArchivo) {
        System.out.println("--- Parte A: lectura desde archivo ---");

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

            String lineaEntero = br.readLine();
            String lineaReal   = br.readLine();
            String cadena      = br.readLine();

            // Si alguna línea no está, el archivo no tiene el formato esperado
            if (lineaEntero == null || lineaReal == null || cadena == null) {
                System.out.println("El archivo no tiene el formato esperado (faltan líneas).");
                return;
            }

            int entero;
            double real;

            try {
                entero = Integer.parseInt(lineaEntero.trim());
            } catch (NumberFormatException e) {
                System.out.println("La primera línea no es un entero válido: " + lineaEntero);
                return;
            }

            try {
                real = Double.parseDouble(lineaReal.trim());
            } catch (NumberFormatException e) {
                System.out.println("La segunda línea no es un real válido: " + lineaReal);
                return;
            }

            System.out.println("Entero leído: " + entero);
            System.out.println("Real leído: " + real);
            System.out.println("Cadena leída: " + cadena);
            System.out.println("Suma (entero + real): " + (entero + real));
            System.out.println("División entera (entero / 7): " + (entero / 7));
            System.out.println("Resto (entero % 7): " + (entero % 7));

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo '" + rutaArchivo + "': " + e.getMessage());
        }
    }

    // ===== PARTE B: leer desde teclado =====
    // Le pedimos al usuario el radio y calculamos área y perímetro de la circunferencia.
    // Usamos Scanner para leer desde stdin.
    public static void leerEntradaStdin(Scanner sc) {
        System.out.println("--- Parte B: lectura desde teclado ---");
        System.out.println("Ingrese el radio de la circunferencia:");

        try {
            double radio = Double.parseDouble(sc.nextLine().trim());

            if (radio < 0) {
                System.out.println("El radio no puede ser negativo.");
                return;
            }

            double area      = Math.PI * radio * radio;
            double perimetro = 2 * Math.PI * radio;

            System.out.printf("Radio: %.2f%n", radio);
            System.out.printf("Área: %.4f%n", area);
            System.out.printf("Perímetro: %.4f%n", perimetro);

        } catch (NumberFormatException e) {
            System.out.println("Lo que ingresaste no es un número válido.");
        }
    }
}
