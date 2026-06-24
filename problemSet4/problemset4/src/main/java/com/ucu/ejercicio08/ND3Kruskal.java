package com.ucu.ejercicio08;

import com.ucu.clases.*;

import java.util.*;

public class ND3Kruskal {

    public static void ejecutar() {

        Grafo g = UtilGrafoNoDirigido.crearGrafoTrabajo();

        List<int[]> aristas = obtenerAristas(g);

        aristas.sort(Comparator.comparingInt(a -> a[2]));

        Map<String, String> padre = new HashMap<>();
        for (Vertice v : g.getVertices()) {
            padre.put(v.getEtiqueta(), v.getEtiqueta());
        }

        List<String> aristasArbol = new ArrayList<>();
        List<String> descartadas = new ArrayList<>();
        int costoTotal = 0;

        List<String> orden = new ArrayList<>();

        for (int[] arista : aristas) {

            String a = String.valueOf(arista[0]);
            String b = String.valueOf(arista[1]);
            int costo = arista[2];

            orden.add(a + "-" + b);

            String raizA = encontrar(padre, a);
            String raizB = encontrar(padre, b);

            if (!raizA.equals(raizB)) {
                padre.put(raizA, raizB);
                aristasArbol.add(a + "-" + b);
                costoTotal += costo;
            } else {
                descartadas.add(a + "-" + b);
            }
        }

        System.out.println("Orden de proceso: "
                + String.join(", ", orden));

        System.out.println("Aristas del arbol: "
                + String.join(", ", aristasArbol)
                + "     Costo = " + costoTotal);

        System.out.println("Descartadas por ciclo: "
                + String.join(", ", descartadas));
    }

    private static List<int[]> obtenerAristas(Grafo g) {

        Set<String> vistas = new HashSet<>();
        List<int[]> resultado = new ArrayList<>();

        for (Vertice v : g.getVertices()) {

            int origen = Integer.parseInt(v.getEtiqueta());

            for (Arista a : v.getAdyacentes()) {

                int destino = Integer.parseInt(
                        a.getDestino().getEtiqueta());

                String clave = Math.min(origen, destino)
                        + "-" + Math.max(origen, destino);

                if (!vistas.contains(clave)) {
                    vistas.add(clave);
                    resultado.add(new int[]{
                            origen, destino, a.getCosto()});
                }
            }
        }

        return resultado;
    }

    private static String encontrar(
            Map<String, String> padre, String v) {

        while (!padre.get(v).equals(v)) {
            v = padre.get(v);
        }

        return v;
    }
}
