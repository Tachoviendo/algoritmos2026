package general;
import java.util.Scanner;

import ejercicios.PruebaAtributos;

public class App {
    public static void main(String[] args) {
        System.out.println("\n==== EJERCICIOS GRUPALES OBLIGATORIOS - ALGORITMOS 1S 2026 ====");
        Scanner sc = new Scanner(System.in);
        while (true) { 
            try {
                System.out.println("Ingrese un número para ejecutar un ejercicio (1 a 14) o ingrese 0 para salir: ");
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 0:
                        sc.close();
                        return;
                    case 1:
                        ejercicio1();
                        break;
                    default:
                        System.out.println("Opción invalida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ingresó una opción invalida.");
            }
        }
    }

    public static void ejercicio1(){
        System.out.println("\n==== EJERCICIO 1 ====");
        PruebaAtributos pa = new PruebaAtributos();
        pa.imprimirValoresAtributos();
        pa.probarNombresVariables();
        pa.probarVariablesLocales();
        System.out.println("\n==== FIN EJERCICIO 1 ====");
    }
}


