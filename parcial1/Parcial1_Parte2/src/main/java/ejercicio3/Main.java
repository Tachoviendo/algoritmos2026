package ejercicio3;

/**
 * Ejecuta los casos de prueba del Ejercicio 3.
 * No es necesario modificar este archivo.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("  Ejercicio 3 - contarEnRango(min, max)");
        System.out.println("================================================");
        System.out.println();

        // Arbol comun a todos los casos
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        int[] claves = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        for (int k : claves) arbol.insertar(k);

        System.out.print("Arbol construido insertando en orden: ");
        for (int i = 0; i < claves.length; i++) {
            System.out.print(claves[i]);
            if (i < claves.length - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.println();

        int pasados = 0;
        int total = 0;

        total++; if (correrCaso(arbol, 20, 40, 5)) pasados++;
        total++; if (correrCaso(arbol, 35, 65, 5)) pasados++;
        total++; if (correrCaso(arbol, 0, 100, 11)) pasados++;
        total++; if (correrCaso(arbol, 100, 200, 0)) pasados++;
        total++; if (correrCaso(arbol, 45, 45, 1)) pasados++;

        System.out.println("================================================");
        System.out.println("  RESUMEN: " + pasados + " / " + total + " casos pasados");
        System.out.println("================================================");
    }

    private static boolean correrCaso(ArbolBinarioBusqueda arbol, int min, int max, int esperado) {
        int obtenido;
        try {
            obtenido = arbol.contarEnRango(min, max);
        } catch (Exception e) {
            System.out.println("[contarEnRango(" + min + ", " + max + ")]");
            System.out.println("  Esperado: " + esperado);
            System.out.println("  Excepcion: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            System.out.println("  Resultado: FAIL");
            System.out.println();
            return false;
        }
        boolean ok = obtenido == esperado;
        System.out.println("[contarEnRango(" + min + ", " + max + ")]");
        System.out.println("  Esperado: " + esperado);
        System.out.println("  Obtenido: " + obtenido);
        System.out.println("  Resultado: " + (ok ? "PASS" : "FAIL"));
        System.out.println();
        return ok;
    }
}
