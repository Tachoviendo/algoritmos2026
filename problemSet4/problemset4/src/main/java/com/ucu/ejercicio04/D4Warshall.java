package com.ucu.ejercicio04;

import com.ucu.clases.*;

import java.util.ArrayList;
import java.util.List;

public class D4Warshall {

    public static void ejecutar() {

        Grafo g = UtilGrafoDirigido.crearGrafoTrabajo();

        List<Vertice> vertices =
                new ArrayList<>(g.getVertices());

        boolean[][] alcanzabilidad =
                construirMatriz(vertices);

        warshall(alcanzabilidad);

        int v2 = indice(vertices, "V2");
        int v6 = indice(vertices, "V6");

        int v4 = indice(vertices, "V4");
        int v0 = indice(vertices, "V0");

        int v5 = indice(vertices, "V5");

        System.out.println(
                "existeCamino(V2, V6) = "
                        + alcanzabilidad[v2][v6]
        );

        System.out.println(
                "existeCamino(V4, V0) = "
                        + alcanzabilidad[v4][v0]
        );

        boolean alcanzaAlguien = false;

        for(int j=0;
            j<alcanzabilidad.length;
            j++) {

            if(alcanzabilidad[v5][j]) {

                alcanzaAlguien = true;
                break;
            }
        }

        System.out.println(
                "existeCamino(V5, *) = "
                        + alcanzaAlguien
        );
    }

    private static boolean[][] construirMatriz(
            List<Vertice> vertices) {

        int n = vertices.size();

        boolean[][] matriz =
                new boolean[n][n];

        for(int i=0;i<n;i++) {

            Vertice v = vertices.get(i);

            for(Arista a :
                    v.getAdyacentes()) {

                int j =
                        vertices.indexOf(
                                a.getDestino());

                matriz[i][j] = true;
            }
        }

        return matriz;
    }

    public static void warshall(
            boolean[][] m) {

        int n = m.length;

        for(int k=0;k<n;k++) {

            for(int i=0;i<n;i++) {

                for(int j=0;j<n;j++) {

                    m[i][j] =
                            m[i][j]
                                    ||
                                    (
                                            m[i][k]
                                                    &&
                                                    m[k][j]
                                    );
                }
            }
        }
    }

    private static int indice(
            List<Vertice> vertices,
            String etiqueta) {

        for(int i=0;i<vertices.size();i++) {

            if(vertices.get(i)
                    .getEtiqueta()
                    .equals(etiqueta)) {

                return i;
            }
        }

        return -1;
    }


}
