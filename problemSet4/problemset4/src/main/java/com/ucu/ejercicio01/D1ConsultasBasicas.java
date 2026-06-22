package com.ucu.ejercicio01;

import com.ucu.clases.Arista;
import com.ucu.clases.Grafo;
import com.ucu.clases.Vertice;
import com.ucu.clases.UtilGrafoDirigido;

public class D1ConsultasBasicas {

    public static void ejecutar() {

        Grafo g = UtilGrafoDirigido.crearGrafoTrabajo();

        System.out.println(
                "gradoSalida(V3) = "
                        + gradoSalida(g, "V3"));

        System.out.println(
                "gradoEntrada(V3) = "
                        + gradoEntrada(g, "V3"));

        System.out.println(
                "gradoSalida(V5) = "
                        + gradoSalida(g, "V5"));

        System.out.println(
                "sonAdyacentes(V0,V1) = "
                        + sonAdyacentes(g, "V0", "V1"));

        System.out.println(
                "sonAdyacentes(V1,V0) = "
                        + sonAdyacentes(g, "V1", "V0"));

        System.out.println("Adyacentes de V3:");

        listarAdyacentes(g, "V3");
    }

    public static int gradoSalida(
            Grafo g,
            String etiqueta) {

        return g.buscarVertice(etiqueta)
                .getAdyacentes()
                .size();
    }

    public static int gradoEntrada(
            Grafo g,
            String etiqueta) {

        int contador = 0;

        for (Vertice v : g.getVertices()) {

            for (Arista a : v.getAdyacentes()) {

                if (a.getDestino()
                        .getEtiqueta()
                        .equals(etiqueta)) {

                    contador++;
                }
            }
        }

        return contador;
    }

    public static boolean sonAdyacentes(
            Grafo g,
            String origen,
            String destino) {

        Vertice v = g.buscarVertice(origen);

        for (Arista a : v.getAdyacentes()) {

            if (a.getDestino()
                    .getEtiqueta()
                    .equals(destino)) {

                return true;
            }
        }

        return false;
    }

    public static void listarAdyacentes(
            Grafo g,
            String etiqueta) {

        Vertice v = g.buscarVertice(etiqueta);

        for (Arista a : v.getAdyacentes()) {

            System.out.print(
                    a.getDestino().getEtiqueta()
                            + "("
                            + a.getCosto()
                            + ") ");
        }

        System.out.println();
    }
}
