package com.ucu.ejercicio09;

import com.ucu.clases.*;

import java.util.*;

public class ND4BFS {

    public static void ejecutar() {

        Grafo g = UtilGrafoNoDirigido.crearGrafoTrabajo();

        Map<String, Integer> distancias = bfs(g, "1");

        System.out.println("Distancias en aristas desde 1:");

        for (Map.Entry<String, Integer> e : distancias.entrySet()) {

            if (!e.getKey().equals("1")) {
                System.out.println(
                        " dist(" + e.getKey() + ") = " + e.getValue());
            }
        }
    }

    public static Map<String, Integer> bfs(
            Grafo g, String origen) {

        Map<String, Integer> dist = new LinkedHashMap<>();
        Queue<String> cola = new LinkedList<>();

        dist.put(origen, 0);
        cola.add(origen);

        while (!cola.isEmpty()) {

            String actual = cola.poll();
            Vertice v = g.buscarVertice(actual);

            for (Arista a : v.getAdyacentes()) {

                String vecino = a.getDestino().getEtiqueta();

                if (!dist.containsKey(vecino)) {
                    dist.put(vecino, dist.get(actual) + 1);
                    cola.add(vecino);
                }
            }
        }

        return dist;
    }
}
