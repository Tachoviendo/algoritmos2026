package com.ucu.algoritmos;

import java.util.Iterator;

public class Rango implements Iterable<Integer> {
    private int inicio;
    private int fin;

    public Rango(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int actual = inicio;

            @Override
            public boolean hasNext() {
                return actual <= fin;
            }

            @Override
            public Integer next() {
                return actual++;
            }
        };
    }
}
