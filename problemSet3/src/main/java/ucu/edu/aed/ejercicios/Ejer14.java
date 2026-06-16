package ucu.edu.aed.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Ej 14: Inserta las 12 claves en tres tablas hash distintas y compara resultados.
   Tamaño M=17 (primo): 12/17 ≈ 70% de factor de carga inicial. */
public class Ejer14 {

    static final int[] CLAVES = {45, 12, 37, 82, 29, 54, 31, 76, 18, 93, 11, 68};
    static final int M = 17;
    /* 12 claves / M=17 ≈ 70% de carga. Se elige el primo más chico que cumpla n/M ≤ 0.7. */
    static final int[] BUSQ_INFRUCTUOSA = {2, 5, 25, 28, 46};

    public static void ejecutar() {
        System.out.println("===== EJERCICIO 14 — Tablas Hash =====");
        System.out.println("Claves: " + Arrays.toString(CLAVES));
        System.out.printf("M = %d  |  n = %d  |  factor de carga = %.0f%%%n", M, CLAVES.length, 100.0 * CLAVES.length / M);
        System.out.println("Función hash: h(k) = k mod " + M);
        System.out.println("Búsquedas infructuosas con: " + Arrays.toString(BUSQ_INFRUCTUOSA) + "\n");

        sondeoLineal();
        sondeoCuadratico();
        encadenamientoSeparado();
    }

    // ---- Sondeo lineal: h(i) = (h0 + i) mod M ----

    private static void sondeoLineal() {
        System.out.println("--- 1. Sondeo Lineal ---");
        int[] tabla = new int[M];
        Arrays.fill(tabla, -1);
        int colisiones = 0;
        long totalInsert = 0;

        for (int clave : CLAVES) {
            int pos = clave % M;
            int comps = 1;
            while (tabla[pos] != -1) {
                pos = (pos + 1) % M;
                comps++;
                colisiones++;
            }
            tabla[pos] = clave;
            totalInsert += comps;
        }

        imprimirTablaLineal(tabla);
        System.out.printf("Colisiones totales: %d%n", colisiones);
        System.out.printf("Prom. comp. inserción:           %.2f%n", (double) totalInsert / CLAVES.length);
        System.out.printf("Prom. comp. búsqueda exitosa:    %.2f%n", busqExitosaLineal(tabla));
        System.out.printf("Prom. comp. búsqueda infructuosa:%.2f%n%n", busqInfructuosaLineal(tabla));
    }

    private static double busqExitosaLineal(int[] tabla) {
        long total = 0;
        for (int clave : CLAVES) {
            int pos = clave % M;
            int comps = 0;
            while (tabla[pos] != clave) {
                pos = (pos + 1) % M;
                comps++;
            }
            total += comps + 1;
        }
        return (double) total / CLAVES.length;
    }

    private static double busqInfructuosaLineal(int[] tabla) {
        long total = 0;
        for (int clave : BUSQ_INFRUCTUOSA) {
            int pos = clave % M;
            int comps = 0;
            while (tabla[pos] != -1) {
                pos = (pos + 1) % M;
                comps++;
            }
            total += comps + 1; // incluye la comparación con el slot vacío
        }
        return (double) total / BUSQ_INFRUCTUOSA.length;
    }

    private static void imprimirTablaLineal(int[] tabla) {
        System.out.println("Pos | Valor");
        for (int i = 0; i < M; i++) {
            System.out.printf(" %2d |  %s%n", i, tabla[i] == -1 ? "-" : tabla[i]);
        }
    }

    // ---- Sondeo cuadrático: h(i) = (h0 + i²) mod M ----

    private static void sondeoCuadratico() {
        System.out.println("--- 2. Sondeo Cuadrático ---");
        int[] tabla = new int[M];
        Arrays.fill(tabla, -1);
        int colisiones = 0;
        long totalInsert = 0;

        for (int clave : CLAVES) {
            int h0 = clave % M;
            int pos = h0;
            int i = 0;
            int comps = 1;
            while (tabla[pos] != -1 && i < M) {
                i++;
                pos = (h0 + i * i) % M;
                comps++;
                colisiones++;
            }
            tabla[pos] = clave;
            totalInsert += comps;
        }

        imprimirTablaLineal(tabla);
        System.out.printf("Colisiones totales: %d%n", colisiones);
        System.out.printf("Prom. comp. inserción:           %.2f%n", (double) totalInsert / CLAVES.length);
        System.out.printf("Prom. comp. búsqueda exitosa:    %.2f%n", busqExitosaCuadratica(tabla));
        System.out.printf("Prom. comp. búsqueda infructuosa:%.2f%n%n", busqInfructuosaCuadratica(tabla));
    }

    private static double busqExitosaCuadratica(int[] tabla) {
        long total = 0;
        for (int clave : CLAVES) {
            int h0 = clave % M;
            int pos = h0;
            int i = 0;
            int comps = 0;
            while (tabla[pos] != clave && i < M) {
                i++;
                pos = (h0 + i * i) % M;
                comps++;
            }
            total += comps + 1;
        }
        return (double) total / CLAVES.length;
    }

    private static double busqInfructuosaCuadratica(int[] tabla) {
        long total = 0;
        for (int clave : BUSQ_INFRUCTUOSA) {
            int h0 = clave % M;
            int pos = h0;
            int i = 0;
            int comps = 0;
            while (tabla[pos] != -1 && i < M) {
                i++;
                pos = (h0 + i * i) % M;
                comps++;
            }
            total += comps + 1;
        }
        return (double) total / BUSQ_INFRUCTUOSA.length;
    }

    // ---- Encadenamiento separado ----

    @SuppressWarnings("unchecked")
    private static void encadenamientoSeparado() {
        System.out.println("--- 3. Encadenamiento Separado ---");
        List<Integer>[] tabla = new List[M];
        for (int i = 0; i < M; i++) tabla[i] = new ArrayList<>();
        int colisiones = 0;

        for (int clave : CLAVES) {
            int pos = clave % M;
            if (!tabla[pos].isEmpty()) colisiones++;
            tabla[pos].add(clave);
        }

        System.out.println("Pos | Lista");
        for (int i = 0; i < M; i++) {
            System.out.printf(" %2d | %s%n", i, tabla[i].isEmpty() ? "-" : tabla[i]);
        }
        System.out.printf("Colisiones totales: %d%n", colisiones);
        System.out.printf("Prom. comp. búsqueda exitosa:    %.2f%n", busqExitosaChaining(tabla));
        System.out.printf("Prom. comp. búsqueda infructuosa:%.2f%n%n", busqInfructuosaChaining(tabla));
    }

    private static double busqExitosaChaining(List<Integer>[] tabla) {
        long total = 0;
        for (int clave : CLAVES) {
            int pos = clave % M;
            int comps = 0;
            for (int elem : tabla[pos]) {
                comps++;
                if (elem == clave) break;
            }
            total += comps;
        }
        return (double) total / CLAVES.length;
    }

    private static double busqInfructuosaChaining(List<Integer>[] tabla) {
        long total = 0;
        for (int clave : BUSQ_INFRUCTUOSA) {
            int pos = clave % M;
            total += tabla[pos].size(); // recorre toda la cadena sin encontrar
        }
        return (double) total / BUSQ_INFRUCTUOSA.length;
    }
}
