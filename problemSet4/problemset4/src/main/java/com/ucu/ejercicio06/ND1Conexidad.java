package com.ucu.ejercicio06;

import com.ucu.clases.*;

import java.util.HashSet;
import java.util.Set;

public class ND1Conexidad {

    public static void ejecutar() {

        Grafo g = UtilGrafoNoDirigido.crearGrafoTrabajo();

        System.out.println("esConexo() = " + esConexo(g));

        g.buscarVertice("2").getAdyacentes()
                .removeIf(a -> a.getDestino()
                        .getEtiqueta().equals("5"));

        g.buscarVertice("5").getAdyacentes()
                .removeIf(a -> a.getDestino()
                        .getEtiqueta().equals("2"));

        System.out.println(
                "Tras quitar la arista 2-5 (aislar el vertice 5):");

        System.out.println("esConexo() = " + esConexo(g));
    }

    public static boolean esConexo(Grafo g) {

        Set<String> visitados = new HashSet<>();

        Vertice inicio = g.getVertices()
                .iterator().next();

        dfs(inicio, visitados);

        return visitados.size() == g.cantidadVertices();
    }

    private static void dfs(
            Vertice v, Set<String> visitados) {

        visitados.add(v.getEtiqueta());

        for (Arista a : v.getAdyacentes()) {

            String vecino = a.getDestino().getEtiqueta();

            if (!visitados.contains(vecino)) {
                dfs(a.getDestino(), visitados);
            }
        }
    }
}
