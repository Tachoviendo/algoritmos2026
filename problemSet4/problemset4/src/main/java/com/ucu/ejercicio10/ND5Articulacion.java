package com.ucu.ejercicio10;

import com.ucu.clases.*;

import java.util.*;

public class ND5Articulacion {

    private static int tiempo;

    public static void ejecutar() {

        Grafo g = crearGrafoPrueba();

        Set<String> articulaciones = new LinkedHashSet<>();

        Map<String, Integer> numBp = new HashMap<>();
        Map<String, Integer> bajo = new HashMap<>();
        Map<String, String> padre = new HashMap<>();
        Set<String> visitado = new HashSet<>();

        tiempo = 0;

        for (Vertice v : g.getVertices()) {
            if (!visitado.contains(v.getEtiqueta())) {
                dfs(v, visitado, numBp, bajo, padre,
                        articulaciones, g);
            }
        }

        System.out.println(
                "Puntos de articulacion = " + articulaciones);
    }

    private static void dfs(
            Vertice v,
            Set<String> visitado,
            Map<String, Integer> numBp,
            Map<String, Integer> bajo,
            Map<String, String> padre,
            Set<String> articulaciones,
            Grafo g) {

        String id = v.getEtiqueta();
        visitado.add(id);
        numBp.put(id, tiempo);
        bajo.put(id, tiempo);
        tiempo++;

        int hijos = 0;

        for (Arista a : v.getAdyacentes()) {

            String vecino = a.getDestino().getEtiqueta();

            if (!visitado.contains(vecino)) {

                hijos++;
                padre.put(vecino, id);

                dfs(a.getDestino(), visitado, numBp, bajo,
                        padre, articulaciones, g);

                bajo.put(id,
                        Math.min(bajo.get(id), bajo.get(vecino)));

                // raiz con 2+ hijos
                if (!padre.containsKey(id) && hijos > 1) {
                    articulaciones.add(id);
                }

                // no-raiz: si ningun descendiente llega
                // mas arriba que v
                if (padre.containsKey(id)
                        && bajo.get(vecino) >= numBp.get(id)) {
                    articulaciones.add(id);
                }

            } else if (!vecino.equals(padre.get(id))) {

                bajo.put(id,
                        Math.min(bajo.get(id), numBp.get(vecino)));
            }
        }
    }

    private static Grafo crearGrafoPrueba() {

        Grafo g = new Grafo();

        for (String v : new String[]{
                "A", "B", "C", "D", "E", "F", "G"}) {
            g.agregarVertice(v);
        }

        agregarNoDirigida(g, "A", "B");
        agregarNoDirigida(g, "A", "C");
        agregarNoDirigida(g, "C", "D");
        agregarNoDirigida(g, "C", "E");
        agregarNoDirigida(g, "D", "E");
        agregarNoDirigida(g, "E", "F");
        agregarNoDirigida(g, "F", "G");
        agregarNoDirigida(g, "G", "D");

        return g;
    }

    private static void agregarNoDirigida(
            Grafo g, String a, String b) {

        g.agregarArista(a, b, 1);
        g.agregarArista(b, a, 1);
    }
}
