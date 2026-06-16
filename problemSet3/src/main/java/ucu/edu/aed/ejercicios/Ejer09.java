package ucu.edu.aed.ejercicios;

import java.util.Arrays;

/* Ej 9: evalúa cómo crece el promedio de comparaciones de sondeo lineal
   a medida que sube el factor de carga (70% → 99%).
   Usa una simulación directa sobre un arreglo para poder fijar el tamaño
   de tabla exacto sin que el auto-resize de THashLineal interfiera. */
public class Ejer09 {

    private static final int M = 1009; // primo, suficientemente grande

    public static void ejecutar() {
        System.out.println("===== EJERCICIO 9 — Rendimiento de tabla hash (sondeo lineal) =====");
        System.out.printf("Tamaño de tabla: M = %d%n%n", M);
        System.out.printf("%-12s %22s %22s%n", "Factor (%)", "Prom. Comp. Inserción", "Prom. Comp. Búsq. Exitosa");
        System.out.println("-".repeat(58));

        int[] factores = {70, 75, 80, 85, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};

        for (int fc : factores) {
            int n = M * fc / 100;
            double[] res = simular(n);
            System.out.printf("%-12d %22.2f %22.2f%n", fc, res[0], res[1]);
        }
    }

    /* Inserta n claves en una tabla de tamaño M y mide comparaciones. */
    private static double[] simular(int n) {
        int[] tabla = new int[M];
        Arrays.fill(tabla, -1);

        long totalInsert = 0;
        for (int clave = 1; clave <= n; clave++) {
            int pos = clave % M;
            int comps = 0;
            while (tabla[pos] != -1) {
                pos = (pos + 1) % M;
                comps++;
            }
            comps++;
            tabla[pos] = clave;
            totalInsert += comps;
        }

        long totalBusq = 0;
        for (int clave = 1; clave <= n; clave++) {
            int pos = clave % M;
            int comps = 0;
            while (tabla[pos] != clave) {
                pos = (pos + 1) % M;
                comps++;
            }
            comps++;
            totalBusq += comps;
        }

        return new double[]{(double) totalInsert / n, (double) totalBusq / n};
    }
}
