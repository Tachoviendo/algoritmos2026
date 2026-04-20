package com.example.clases;

public class Cola<T> {
    private Object[] vector;
    private int frente;
    private int fin;
    private int max;

    public Cola(int max) {
        this.max = max;
        this.vector = new Object[max];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean estaVacia() {
        return frente == fin;
    }

    public boolean estaLlena() {
        return (fin + 1) % max == frente;
    }

    public void poneEnCola(T elemento) {
        if (estaLlena()) {
            System.out.println("Error: cola llena");
            return;
        }
        vector[fin] = elemento;
        fin = (fin + 1) % max;
    }

    @SuppressWarnings("unchecked")
    public T quitaDeCola() {
        if (estaVacia()) {
            System.out.println("Error: cola vacía");
            return null;
        }
        T elemento = (T) vector[frente];
        frente = (frente + 1) % max;
        return elemento;
    }
}
