package com.ucu.clases;

public class UtilGrafoNoDirigido {

    public static Grafo crearGrafoTrabajo() {

        Grafo g = new Grafo();

        for (int i = 1; i <= 6; i++) {
            g.agregarVertice(String.valueOf(i));
        }

        agregarAristaNoDirigida(g, "1", "3", 1);
        agregarAristaNoDirigida(g, "3", "2", 2);
        agregarAristaNoDirigida(g, "3", "6", 3);
        agregarAristaNoDirigida(g, "6", "4", 4);
        agregarAristaNoDirigida(g, "2", "5", 5);
        agregarAristaNoDirigida(g, "1", "2", 6);
        agregarAristaNoDirigida(g, "1", "4", 7);

        return g;
    }

    public static void agregarAristaNoDirigida(
            Grafo g, String a, String b, int costo) {

        g.agregarArista(a, b, costo);
        g.agregarArista(b, a, costo);
    }
}
