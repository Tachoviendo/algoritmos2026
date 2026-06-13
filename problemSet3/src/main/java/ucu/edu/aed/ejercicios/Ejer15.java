package ucu.edu.aed.ejercicios;

import java.util.HashSet;

import ucu.edu.aed.ejer15.Libro;

public class Ejer15 {

    public static void ejecutar() {

        System.out.println("========== EJERCICIO 15 ==========\n");

        System.out.println("1. Identidad lógica de un libro");
        System.out.println("--------------------------------");
        System.out.println("La identidad lógica de un libro está determinada por el ISBN.");
        System.out.println("El ISBN es un identificador único internacional para cada edición de un libro.");
        System.out.println("Por lo tanto, dos libros con el mismo ISBN representan el mismo libro.\n");

        System.out.println("2. Implementación de equals() y hashCode()");
        System.out.println("------------------------------------------");
        System.out.println("equals() compara únicamente el ISBN.");
        System.out.println("hashCode() también se calcula utilizando únicamente el ISBN.");
        System.out.println("Así se cumple el contrato general de Java.\n");

        System.out.println("3. Error conceptual");
        System.out.println("-------------------");
        System.out.println("Si equals() compara por ISBN pero hashCode() usa el título,");
        System.out.println("dos libros podrían ser iguales según equals()");
        System.out.println("pero tener hashCode() distintos.");
        System.out.println("Esto rompe el funcionamiento de HashSet y HashMap.\n");

        System.out.println("4. Demostración práctica con HashSet");
        System.out.println("------------------------------------");

        Libro libro1 = new Libro(
                "9780134685991",
                "Effective Java",
                "Joshua Bloch",
                2018);

        Libro libro2 = new Libro(
                "9780134685991",
                "Effective Java",
                "Joshua Bloch",
                2018);

        System.out.println("libro1 == libro2: " + (libro1 == libro2));
        System.out.println("libro1.equals(libro2): " + libro1.equals(libro2));

        System.out.println("hashCode libro1: " + libro1.hashCode());
        System.out.println("hashCode libro2: " + libro2.hashCode());

        HashSet<Libro> biblioteca = new HashSet<>();

        biblioteca.add(libro1);
        biblioteca.add(libro2);

        System.out.println("\nCantidad de libros en el HashSet: "
                + biblioteca.size());

        System.out.println("\nResultado esperado:");
        System.out.println("El tamaño del HashSet debe ser 1 porque ambos");
        System.out.println("objetos representan el mismo libro (mismo ISBN).\n");

        System.out.println("5. Casos de prueba sugeridos");
        System.out.println("----------------------------");

        System.out.println("Reflexividad:");
        System.out.println("  libro1.equals(libro1) -> "
                + libro1.equals(libro1));

        System.out.println("\nSimetría:");
        System.out.println("  libro1.equals(libro2) -> "
                + libro1.equals(libro2));
        System.out.println("  libro2.equals(libro1) -> "
                + libro2.equals(libro1));

        System.out.println("\nIgualdad implica mismo hashCode:");
        System.out.println("  "
                + (libro1.hashCode() == libro2.hashCode()));

        System.out.println("\nInserción en HashSet:");
        System.out.println("  Tamaño final = "
                + biblioteca.size());

        System.out.println("\n========== FIN DEL EJERCICIO ==========");
    }
}