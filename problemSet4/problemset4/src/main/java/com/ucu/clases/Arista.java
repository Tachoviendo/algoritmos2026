package com.ucu.clases;

public class Arista {

    private Vertice destino;
    private int costo;

    public Arista(Vertice destino, int costo) {
        this.destino = destino;
        this.costo = costo;
    }

    public Vertice getDestino() {
        return destino;
    }

    public int getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return destino.getEtiqueta() + "(" + costo + ")";
    }
}