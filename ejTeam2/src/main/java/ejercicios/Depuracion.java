package ejercicios;

/*
Ejercicio 12: detección y corrección de errores frecuentes.

Para cada fragmento se documenta:
  - Problema observado
  - Causa probable
  - Corrección aplicada
  - Versión que falla de forma controlada
  - Buenas prácticas que habrían evitado el error
*/
public class Depuracion {

    public void ejercicio12() {

        // ================================================================
        // FRAGMENTO 1: División por cero sin manejo de excepción
        // ================================================================

        /*
        Problema observado: el programa revienta con ArithmeticException y se corta la ejecución.
        Causa probable: no se valida que el divisor sea distinto de cero antes de dividir.
        Buena práctica: siempre validar entradas antes de operar, o usar try-catch para manejar el error.
        */

        System.out.println("===== FRAGMENTO 1: División por cero =====");

        // Versión que falla de forma controlada (la excepción se atrapa y el programa sigue)
        System.out.println("-- Versión que falla de forma controlada --");
        try {
            int resultado = 10 / 0;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error atrapado: " + e.getMessage());
        } finally {
            // finally siempre se ejecuta, haya error o no
            // útil para cerrar recursos, imprimir logs, etc.
            System.out.println("Bloque finally: esto siempre se ejecuta.");
        }

        // Versión correcta: validar antes de dividir, sin depender del try-catch
        System.out.println("-- Versión correcta --");
        int dividendo = 10;
        int divisor = 0;
        if (divisor != 0) {
            System.out.println("Resultado: " + (dividendo / divisor));
        } else {
            System.out.println("No se puede dividir por cero.");
        }

        // ================================================================
        // FRAGMENTO 3: Comparar Strings con == en vez de equals
        // ================================================================

        /*
        Problema observado: la condición nunca se cumple aunque los Strings parezcan iguales,
        o se cumple cuando no debería. El comportamiento es impredecible según cómo se creó el String.
        Causa probable: == compara referencias en memoria, no contenido.
          - Dos String con el mismo texto pueden ser objetos distintos si alguno fue creado con new.
          - Con literales puede funcionar por el string pool, pero es una coincidencia, no una garantía.
        Buena práctica: siempre usar equals() para comparar contenido de Strings. Nunca ==.
        */

        System.out.println("\n===== FRAGMENTO 3: Comparar Strings con == =====");

        // Versión que falla de forma controlada
        System.out.println("-- Versión que falla de forma controlada --");
        String a = new String("hola");
        String b = new String("hola");
        if (a == b) {
            System.out.println("Son iguales (con ==)");
        } else {
            // esto siempre se imprime porque a y b son objetos distintos en memoria
            System.out.println("Son distintos (con ==) aunque tengan el mismo contenido. Bug!");
        }

        // Versión correcta: usar equals
        System.out.println("-- Versión correcta --");
        if (a.equals(b)) {
            System.out.println("Son iguales (con equals). Correcto.");
        } else {
            System.out.println("Son distintos.");
        }

        // Caso extra: el bucle infinito clásico por este mismo error
        System.out.println("-- Bucle con == (limitado a 5 iteraciones para no colgar) --");
        String s = "1";
        int iteraciones = 0;
        // con == esto nunca terminaría porque s nunca es la misma referencia que "6"
        while (s != "6" && iteraciones < 5) {
            s = String.valueOf(Integer.parseInt(s) + 1);
            iteraciones++;
            System.out.println("s = " + s);
        }

        System.out.println("-- Bucle corregido con equals --");
        s = "1";
        while (!s.equals("6")) {
            s = String.valueOf(Integer.parseInt(s) + 1);
            System.out.println("s = " + s);
        }
        System.out.println("Bucle terminó correctamente.");
    }
}
