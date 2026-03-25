package com.ucu.algoritmos;

public class Contador {
    private static int totalCreados = 0;
    private int numero;

    public Contador() {
        totalCreados++;
        numero = totalCreados;
    }

    public static int getTotalCreados() {
        return totalCreados;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Contador #" + numero + " (Total creados: " + totalCreados + ")";
    }
}
