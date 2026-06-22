package com.ucu.clases;

import clases.Grafo;

public class UtilGrafoDirigido {

    public static Grafo crearGrafoTrabajo() {

        Grafo g = new Grafo();

        for (int i = 0; i <= 6; i++) {
            g.agregarVertice("V" + i);
        }

        g.agregarArista("V0", "V1", 2);
        g.agregarArista("V0", "V3", 1);

        g.agregarArista("V1", "V3", 3);
        g.agregarArista("V1", "V4", 10);

        g.agregarArista("V2", "V0", 4);
        g.agregarArista("V2", "V5", 5);

        g.agregarArista("V3", "V2", 2);
        g.agregarArista("V3", "V4", 2);
        g.agregarArista("V3", "V5", 8);
        g.agregarArista("V3", "V6", 4);

        g.agregarArista("V4", "V6", 6);

        g.agregarArista("V6", "V5", 1);

        return g;
    }
}