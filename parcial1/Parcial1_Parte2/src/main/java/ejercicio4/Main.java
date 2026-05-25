package ejercicio4;

/**
 * Ejecuta los casos de prueba del Ejercicio 4.
 * No es necesario modificar este archivo.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("  Ejercicio 4 - altura() y esAVL()");
        System.out.println("================================================");
        System.out.println();

        int pasados = 0;
        int total = 0;

        // Caso A: AVL valido, altura 2
        ElementoAB tA = new ElementoAB(10,
                new ElementoAB(5, new ElementoAB(2), new ElementoAB(7)),
                new ElementoAB(15, null, new ElementoAB(20)));
        total++; if (verificarAltura("Caso A", tA, 2)) pasados++;
        total++; if (verificarEsAVL("Caso A", tA, true)) pasados++;

        // Caso B: cadena desbalanceada
        ElementoAB tB = new ElementoAB(1, null,
                new ElementoAB(2, null,
                        new ElementoAB(3, null, new ElementoAB(4))));
        total++; if (verificarAltura("Caso B", tB, 3)) pasados++;
        total++; if (verificarEsAVL("Caso B", tB, false)) pasados++;

        // Caso C: raiz balanceada pero subarbol derecho no es AVL
        ElementoAB tC = new ElementoAB(10,
                new ElementoAB(5),
                new ElementoAB(20,
                        new ElementoAB(15),
                        new ElementoAB(25, null,
                                new ElementoAB(30, null, new ElementoAB(35)))));
        total++; if (verificarEsAVL("Caso C", tC, false)) pasados++;

        // Caso D: nodo unico
        ElementoAB tD = new ElementoAB(42);
        total++; if (verificarAltura("Caso D", tD, 0)) pasados++;
        total++; if (verificarEsAVL("Caso D", tD, true)) pasados++;

        System.out.println("================================================");
        System.out.println("  RESUMEN: " + pasados + " / " + total + " casos pasados");
        System.out.println("================================================");
    }

    private static boolean verificarAltura(String etiqueta, ElementoAB t, int esperado) {
        int obtenido;
        try {
            obtenido = t.altura();
        } catch (Exception e) {
            System.out.println("[" + etiqueta + " - altura()]");
            System.out.println("  Esperado: " + esperado);
            System.out.println("  Excepcion: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            System.out.println("  Resultado: FAIL");
            System.out.println();
            return false;
        }
        boolean ok = obtenido == esperado;
        System.out.println("[" + etiqueta + " - altura()]");
        System.out.println("  Esperado: " + esperado);
        System.out.println("  Obtenido: " + obtenido);
        System.out.println("  Resultado: " + (ok ? "PASS" : "FAIL"));
        System.out.println();
        return ok;
    }

    private static boolean verificarEsAVL(String etiqueta, ElementoAB t, boolean esperado) {
        boolean obtenido;
        try {
            obtenido = t.esAVL();
        } catch (Exception e) {
            System.out.println("[" + etiqueta + " - esAVL()]");
            System.out.println("  Esperado: " + esperado);
            System.out.println("  Excepcion: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            System.out.println("  Resultado: FAIL");
            System.out.println();
            return false;
        }
        boolean ok = obtenido == esperado;
        System.out.println("[" + etiqueta + " - esAVL()]");
        System.out.println("  Esperado: " + esperado);
        System.out.println("  Obtenido: " + obtenido);
        System.out.println("  Resultado: " + (ok ? "PASS" : "FAIL"));
        System.out.println();
        return ok;
    }
}
