package com.ucu.ejercicio03;

import com.ucu.clases.*;

import java.util.*;

public class D3Floyd {


    private static final int INF = 999999;

    public static void ejecutar() {

        Grafo g = crearGrafoCentro();

        List<Vertice> vertices =
                new ArrayList<>(g.getVertices());

        int[][] dist = construirMatriz(vertices);

        floyd(dist);

        Map<String,Integer> ex =
                excentricidades(dist, vertices);

        System.out.println("Excentricidades: " + ex);

        String centro = centro(ex);

        System.out.println(
                "Centro = "
                        + centro
                        + " (excentricidad "
                        + ex.get(centro)
                        + ")"
        );
    }

    private static Grafo crearGrafoCentro() {

        Grafo g = new Grafo();

        g.agregarVertice("A");
        g.agregarVertice("B");
        g.agregarVertice("C");
        g.agregarVertice("D");
        g.agregarVertice("E");

        g.agregarArista("A","B",1);
        g.agregarArista("A","E",6);

        g.agregarArista("B","C",1);
        g.agregarArista("B","E",5);

        g.agregarArista("C","D",1);
        g.agregarArista("C","E",4);

        g.agregarArista("D","E",3);

        g.agregarArista("E","A",7);

        return g;
    }

    private static int[][] construirMatriz(
            List<Vertice> vertices) {

        int n = vertices.size();

        int[][] dist = new int[n][n];

        for(int i=0;i<n;i++) {

            for(int j=0;j<n;j++) {

                if(i == j) {
                    dist[i][j] = 0;
                }
                else {
                    dist[i][j] = INF;
                }
            }
        }

        for(int i=0;i<n;i++) {

            Vertice v = vertices.get(i);

            for(Arista a : v.getAdyacentes()) {

                int j = vertices.indexOf(
                        a.getDestino());

                dist[i][j] = a.getCosto();
            }
        }

        return dist;
    }

    public static void floyd(int[][] d) {

        int n = d.length;

        for(int k=0;k<n;k++) {

            for(int i=0;i<n;i++) {

                for(int j=0;j<n;j++) {

                    if(d[i][k] + d[k][j]
                            < d[i][j]) {

                        d[i][j] =
                                d[i][k]
                                        + d[k][j];
                    }
                }
            }
        }
    }

    public static Map<String,Integer>
    excentricidades(
            int[][] d,
            List<Vertice> vertices) {

        Map<String,Integer> resultado =
                new LinkedHashMap<>();

        int n = d.length;

        for(int col=0; col<n; col++) {

            int max = 0;

            for(int fila=0; fila<n; fila++) {

                max = Math.max(
                        max,
                        d[fila][col]);
            }

            resultado.put(
                    vertices.get(col)
                            .getEtiqueta(),
                    max
            );
        }

        return resultado;
    }

    public static String centro(
            Map<String,Integer> ex) {

        String mejor = null;
        int menor = Integer.MAX_VALUE;

        for(String v : ex.keySet()) {

            if(ex.get(v) < menor) {

                menor = ex.get(v);
                mejor = v;
            }
        }

        return mejor;
    }

}

