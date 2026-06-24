package com.ucu.ejercicio07;

import com.ucu.clases.*;

import java.util.*;

public class ND2Prim {

    public static void ejecutar() {

        Grafo g = UtilGrafoNoDirigido.crearGrafoTrabajo();

        Set<String> enArbol = new HashSet<>();
        List<String> aristas = new ArrayList<>();
        int costoTotal = 0;

        enArbol.add("1");

        while (enArbol.size() < g.cantidadVertices()) {

            Arista mejorArista = null;
            String mejorOrigen = null;
            int mejorCosto = Integer.MAX_VALUE;

            for (String etiqueta : enArbol) {

                Vertice v = g.buscarVertice(etiqueta);

                for (Arista a : v.getAdyacentes()) {

                    String destino = a.getDestino().getEtiqueta();

                    if (!enArbol.contains(destino)
                            && a.getCosto() < mejorCosto) {

                        mejorCosto = a.getCosto();
                        mejorArista = a;
                        mejorOrigen = etiqueta;
                    }
                }
            }

            String nuevo = mejorArista.getDestino().getEtiqueta();
            enArbol.add(nuevo);
            aristas.add(mejorOrigen + "-" + nuevo);
            costoTotal += mejorCosto;
        }

        System.out.println("Arbol abarcador minimo (Prim):");
        System.out.println(" " + String.join(", ", aristas));
        System.out.println("Costo total = " + costoTotal);
    }
}
