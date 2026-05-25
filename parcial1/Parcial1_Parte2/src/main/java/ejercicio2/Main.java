package ejercicio2;

/**
 * Ejecuta los casos de prueba del Ejercicio 2.
 * No es necesario modificar este archivo.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("  Ejercicio 2 - intercalar(c1, c2)");
        System.out.println("================================================");
        System.out.println();

        int pasados = 0;
        int total = 0;

        total++;
        if (correrCaso("Caso 1",
                new int[]{1, 2, 3},
                new int[]{10, 20, 30},
                "[1, 10, 2, 20, 3, 30]")) pasados++;

        total++;
        if (correrCaso("Caso 2",
                new int[]{1, 2, 3, 4, 5},
                new int[]{10, 20},
                "[1, 10, 2, 20, 3, 4, 5]")) pasados++;

        total++;
        if (correrCaso("Caso 3",
                new int[]{1},
                new int[]{10, 20, 30},
                "[1, 10, 20, 30]")) pasados++;

        total++;
        if (correrCaso("Caso 4",
                new int[]{},
                new int[]{10, 20},
                "[10, 20]")) pasados++;

        total++;
        if (correrCaso("Caso 5",
                new int[]{},
                new int[]{},
                "[]")) pasados++;

        System.out.println("================================================");
        System.out.println("  RESUMEN: " + pasados + " / " + total + " casos pasados");
        System.out.println("================================================");
    }

    private static boolean correrCaso(String etiqueta, int[] datos1, int[] datos2, String esperado) {
        ColaEnlazada<Integer> c1 = new ColaEnlazada<>();
        ColaEnlazada<Integer> c2 = new ColaEnlazada<>();
        for (int x : datos1) c1.encolar(x);
        for (int x : datos2) c2.encolar(x);

        String c1Str = c1.toString();
        String c2Str = c2.toString();

        ColaEnlazada<Integer> resultado;
        try {
            resultado = ColaEnlazada.intercalar(c1, c2);
        } catch (Exception e) {
            System.out.println("[" + etiqueta + "]");
            System.out.println("  c1:       " + c1Str);
            System.out.println("  c2:       " + c2Str);
            System.out.println("  Esperado: " + esperado);
            System.out.println("  Excepcion: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            System.out.println("  Resultado: FAIL");
            System.out.println();
            return false;
        }

        if (resultado == null) {
            System.out.println("[" + etiqueta + "]");
            System.out.println("  c1:       " + c1Str);
            System.out.println("  c2:       " + c2Str);
            System.out.println("  Esperado: " + esperado);
            System.out.println("  Obtenido: null  (el metodo aun no fue implementado)");
            System.out.println("  Resultado: FAIL");
            System.out.println();
            return false;
        }

        String obtenido = resultado.toString();
        boolean ok = esperado.equals(obtenido);
        System.out.println("[" + etiqueta + "]");
        System.out.println("  c1:       " + c1Str);
        System.out.println("  c2:       " + c2Str);
        System.out.println("  Esperado: " + esperado);
        System.out.println("  Obtenido: " + obtenido);
        System.out.println("  Resultado: " + (ok ? "PASS" : "FAIL"));
        System.out.println();
        return ok;
    }
}
