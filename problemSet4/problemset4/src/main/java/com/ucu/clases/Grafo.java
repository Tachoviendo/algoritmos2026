package com.ucu.clases;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Grafo {

    private Map<String, Vertice> vertices;

    public Grafo() {
        vertices = new HashMap<>();
    }

    public void agregarVertice(String etiqueta) {

        if (!vertices.containsKey(etiqueta)) {
            vertices.put(etiqueta, new Vertice(etiqueta));
        }
    }

    public void agregarArista(String origen,
                              String destino,
                              int costo) {

        Vertice vOrigen = vertices.get(origen);
        Vertice vDestino = vertices.get(destino);

        if (vOrigen != null && vDestino != null) {
            vOrigen.agregarAdyacente(vDestino, costo);
        }
    }

    public Vertice buscarVertice(String etiqueta) {
        return vertices.get(etiqueta);
    }

    public Collection<Vertice> getVertices() {
        return vertices.values();
    }

    public int cantidadVertices() {
        return vertices.size();
    }

    public boolean existeVertice(String etiqueta) {
        return vertices.containsKey(etiqueta);
    }
}
