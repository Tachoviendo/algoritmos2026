package com.ucu.clases;

import java.util.ArrayList;
import java.util.List;

public class Vertice {

    private String etiqueta;
    private List<Arista> adyacentes;

    public Vertice(String etiqueta) {
        this.etiqueta = etiqueta;
        this.adyacentes = new ArrayList<>();
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public List<Arista> getAdyacentes() {
        return adyacentes;
    }

    public void agregarAdyacente(Vertice destino, int costo) {
        adyacentes.add(new Arista(destino, costo));
    }

    @Override
    public String toString() {
        return etiqueta;
    }
}
