package ejercicio1;

/**
 * Ejecuta los casos de prueba del Ejercicio 1.
 * No es necesario modificar este archivo.
 *
 * Para ejecutar desde la terminal:
 *   mvn compile exec:java -Dexec.mainClass="ejercicio1.Main"
 * O simplemente desde VSCode hacer "Run" sobre el metodo main.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("  Ejercicio 1 - eliminarDuplicadosConsecutivos");
        System.out.println("================================================");
        System.out.println();

        int pasados = 0;
        int total = 0;

        // Caso 1
        total++;
        if (correrCaso("Caso 1", new int[]{1, 1, 2, 3, 3, 3, 4}, "[1, 2, 3, 4]")) {
            pasados++;
        }

        // Caso 2
        total++;
        if (correrCaso("Caso 2", new int[]{1, 2, 1, 2, 1}, "[1, 2, 1, 2, 1]")) {
            pasados++;
        }

        // Caso 3
        total++;
        if (correrCaso("Caso 3", new int[]{5, 5, 5, 5}, "[5]")) {
            pasados++;
        }

        // Caso 4
        total++;
        if (correrCaso("Caso 4", new int[]{}, "[]")) {
            pasados++;
        }

        // Caso 5
        total++;
        if (correrCaso("Caso 5", new int[]{7}, "[7]")) {
            pasados++;
        }

        System.out.println("================================================");
        System.out.println("  RESUMEN: " + pasados + " / " + total + " casos pasados");
        System.out.println("================================================");
    }

    private static boolean correrCaso(String etiqueta, int[] entrada, String esperado) {
        ListaEnlazada lista = new ListaEnlazada();
        for (int x : entrada) lista.agregarFinal(x);

        String entradaStr = lista.toString();

        try {
            lista.eliminarDuplicadosConsecutivos();
        } catch (Exception e) {
            System.out.println("[" + etiqueta + "]");
            System.out.println("  Entrada:  " + entradaStr);
            System.out.println("  Esperado: " + esperado);
            System.out.println("  Excepcion: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            System.out.println("  Resultado: FAIL");
            System.out.println();
            return false;
        }

        String obtenido = lista.toString();
        boolean ok = esperado.equals(obtenido);
        System.out.println("[" + etiqueta + "]");
        System.out.println("  Entrada:  " + entradaStr);
        System.out.println("  Esperado: " + esperado);
        System.out.println("  Obtenido: " + obtenido);
        System.out.println("  Resultado: " + (ok ? "PASS" : "FAIL"));
        System.out.println();
        return ok;
    }
}
