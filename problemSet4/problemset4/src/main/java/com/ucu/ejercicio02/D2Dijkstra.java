package com.ucu.ejercicio02;

import clases.Arista;
import clases.Grafo;
import clases.Vertice;
import clases.UtilGrafoDirigido;

import java.util.*;

public class D2Dijkstra {

    private static final int INF = Integer.MAX_VALUE;

    public static void ejecutar() {

        Grafo g = UtilGrafoDirigido.crearGrafoTrabajo();

        Map<String, Integer> distancias =
                dijkstra(g, "V2");

        System.out.println(
                "Costos mínimos desde V2:");

        System.out.println(distancias);

        System.out.println(
                "Costo a V6 = "
                        + distancias.get("V6"));

        System.out.println(
                "Camino V2→V6 = "
                        + reconstruirCamino(
                                g,
                                "V2",
                                "V6"));
    }

    public static Map<String, Integer> dijkstra(
            Grafo g,
            String origen) {

        Map<String, Integer> dist =
                new HashMap<>();

        Set<String> visitados =
                new HashSet<>();

        for (Vertice v : g.getVertices()) {

            dist.put(
                    v.getEtiqueta(),
                    INF);
        }

        dist.put(origen, 0);

        while (visitados.size()
                < g.cantidadVertices()) {

            String actual =
                    obtenerMenorNoVisitado(
                            dist,
                            visitados);

            if (actual == null)
                break;

            visitados.add(actual);

            Vertice vActual =
                    g.buscarVertice(actual);

            for (Arista a :
                    vActual.getAdyacentes()) {

                String vecino =
                        a.getDestino()
                                .getEtiqueta();

                int nuevaDist =
                        dist.get(actual)
                                + a.getCosto();

                if (nuevaDist
                        < dist.get(vecino)) {

                    dist.put(
                            vecino,
                            nuevaDist);
                }
            }
        }

        return dist;
    }

    private static String obtenerMenorNoVisitado(
            Map<String, Integer> dist,
            Set<String> visitados) {

        String menor = null;
        int valor = INF;

        for (String v : dist.keySet()) {

            if (!visitados.contains(v)
                    && dist.get(v) < valor) {

                valor = dist.get(v);
                menor = v;
            }
        }

        return menor;
    }

    public static List<String> reconstruirCamino(
            Grafo g,
            String origen,
            String destino) {

        Map<String, Integer> dist =
                new HashMap<>();

        Map<String, String> pred =
                new HashMap<>();

        Set<String> visitados =
                new HashSet<>();

        for (Vertice v : g.getVertices()) {

            dist.put(
                    v.getEtiqueta(),
                    INF);
        }

        dist.put(origen, 0);

        while (visitados.size()
                < g.cantidadVertices()) {

            String actual =
                    obtenerMenorNoVisitado(
                            dist,
                            visitados);

            if (actual == null)
                break;

            visitados.add(actual);

            for (Arista a :
                    g.buscarVertice(actual)
                            .getAdyacentes()) {

                String vecino =
                        a.getDestino()
                                .getEtiqueta();

                int nuevaDist =
                        dist.get(actual)
                                + a.getCosto();

                if (nuevaDist
                        < dist.get(vecino)) {

                    dist.put(
                            vecino,
                            nuevaDist);

                    pred.put(
                            vecino,
                            actual);
                }
            }
        }

        LinkedList<String> camino =
                new LinkedList<>();

        String actual = destino;

        while (actual != null) {

            camino.addFirst(actual);
            actual = pred.get(actual);
        }

        return camino;
    }
}
