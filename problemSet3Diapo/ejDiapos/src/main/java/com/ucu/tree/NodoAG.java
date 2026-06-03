package com.ucu.tree;

public class NodoAG<T> {
    private T dato;
    private NodoAG<T> primerHijo;
    private NodoAG<T> hermanoDerecho;

    public NodoAG(T dato) { this.dato = dato; }
    public T getDato() { return dato; }
    public NodoAG<T> getPrimerHijo() { return primerHijo; }
    public NodoAG<T> getHermanoDerecho() { return hermanoDerecho; }

    public void agregarHijo(NodoAG<T> hijo) {
        if (primerHijo == null) {
            primerHijo = hijo;
        } else {
            NodoAG<T> actual = primerHijo;
            while (actual.hermanoDerecho != null) {
                actual = actual.hermanoDerecho;
            }
            actual.hermanoDerecho = hijo;
        }
    }

    public void preorden(StringBuilder sb) {
        sb.append(dato).append(" ");
        NodoAG<T> hijo = primerHijo;
        while (hijo != null) {
            hijo.preorden(sb);
            hijo = hijo.hermanoDerecho;
        }
    }

    public int contarNodos() {
        int count = 1;
        NodoAG<T> hijo = primerHijo;
        while (hijo != null) {
            count += hijo.contarNodos();
            hijo = hijo.hermanoDerecho;
        }
        return count;
    }

    public int contarHojas() {
        if (primerHijo == null) return 1;

        int count = 0;
        NodoAG<T> hijo = primerHijo;
        while (hijo != null) {
            count += hijo.contarHojas();
            hijo = hijo.hermanoDerecho;
        }
        return count;
    }

    public int altura() {
        if (primerHijo == null) return 0;
        int max = -1;
        
        NodoAG<T> hijo = primerHijo;

        while (hijo != null) {
            int h = hijo.altura();
            if (h > max) max = h;
            hijo = hijo.hermanoDerecho;
        }
        return 1 + max;
    }
}
