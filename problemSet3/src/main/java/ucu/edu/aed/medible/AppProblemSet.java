package ucu.edu.aed.medible;

import java.util.Scanner;

import ucu.edu.aed.ejercicios.*;

public class AppProblemSet {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n===== UT03 - Problem Set =====");
            System.out.println("7  - Ejercicio 07");
            System.out.println("9  - Ejercicio 09");
            System.out.println("11 - Ejercicio 11");
            System.out.println("12 - Ejercicio 12");
            System.out.println("13 - Ejercicio 13");
            System.out.println("14 - Ejercicio 14");
            System.out.println("15 - Ejercicio 15");
            System.out.println("16 - Ejercicio 16");
            System.out.println("0  - Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 7  -> Ejer07.ejecutar();
                case 9  -> Ejer09.ejecutar();
                case 11 -> Ejer11.ejecutar();
                case 12 -> Ejer12.ejecutar();
                case 13 -> Ejer13.ejecutar();
                case 14 -> Ejer14.ejecutar();
                case 15 -> Ejer15.ejecutar();
                case 16 -> Ejer16.ejecutar();
                case 0  -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }
        }
        sc.close();
	}
}