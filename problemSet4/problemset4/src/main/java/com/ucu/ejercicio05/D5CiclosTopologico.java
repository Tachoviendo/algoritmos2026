package com.ucu.ejercicio05;

import com.ucu.clases.*;

import java.util.*;

public class D5CiclosTopologico {

    public static void ejecutar() {

        Grafo gCiclo = UtilGrafoDirigido.crearGrafoTrabajo();

        Grafo gTopo = crearGrafoPreviaturas();

        System.out.println("Grafo V0–V6:");

        if(tieneCiclo(gCiclo)) {
            System.out.println("Contiene ciclo -> V0 -> V3 -> V2 -> V0");
        }

        System.out.println("\nGrafo C1–C5:");

        if(!tieneCiclo(gTopo)) {

            System.out.println("Aciclico");

            List<String> orden = ordenTopologico(gTopo);

            System.out.println("Orden topologico valido: " + orden);
        }
    }

    private static Grafo crearGrafoPreviaturas() {

        Grafo g = new Grafo();

        for(int i=1;i<=5;i++) {
            g.agregarVertice("C" + i);
        }

        g.agregarArista("C1","C2",1);
        g.agregarArista("C1","C3",1);

        g.agregarArista("C2","C4",1);
        g.agregarArista("C3","C4",1);

        g.agregarArista("C4","C5",1);

        return g;
    }

    public static boolean tieneCiclo(Grafo g) {

        Set<String> visitado = new HashSet<>();
        Set<String> stack = new HashSet<>();

        for(Vertice v : g.getVertices()) {

            if(!visitado.contains(v.getEtiqueta())) {

                if(dfsCiclo(v, visitado, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfsCiclo(
            Vertice v,
            Set<String> visitado,
            Set<String> stack) {

        String id = v.getEtiqueta();

        visitado.add(id);
        stack.add(id);

        for(Arista a : v.getAdyacentes()) {

            String vecino =
                    a.getDestino().getEtiqueta();

            if(!visitado.contains(vecino)) {

                if(dfsCiclo(
                        a.getDestino(),
                        visitado,
                        stack)) {
                    return true;
                }

            } else if(stack.contains(vecino)) {
                return true;
            }
        }

        stack.remove(id);

        return false;
    }

    public static List<String> ordenTopologico(Grafo g) {

        Set<String> visitado = new HashSet<>();
        Stack<String> pila = new Stack<>();

        for(Vertice v : g.getVertices()) {

            if(!visitado.contains(v.getEtiqueta())) {

                dfsTopo(v, visitado, pila);
            }
        }

        List<String> orden = new ArrayList<>();

        while(!pila.isEmpty()) {
            orden.add(pila.pop());
        }

        return orden;
    }

    private static void dfsTopo(
            Vertice v,
            Set<String> visitado,
            Stack<String> pila) {

        String id = v.getEtiqueta();
        visitado.add(id);

        for(Arista a : v.getAdyacentes()) {

            Vertice w = a.getDestino();

            if(!visitado.contains(w.getEtiqueta())) {
                dfsTopo(w, visitado, pila);
            }
        }

        pila.push(id);
    }

}

