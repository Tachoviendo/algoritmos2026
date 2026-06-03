package com.ucu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolGenerico<T> {
    private NodoAG<T> raiz;

    public ArbolGenerico(NodoAG<T> raiz) { this.raiz = raiz; }

    public String preorden() {
        StringBuilder sb = new StringBuilder();
        if (raiz != null)
            raiz.preorden(sb);
        return sb.toString().trim();
    }

    public int contarNodos() {
        if (raiz == null) return 0;
        return raiz.contarNodos();
    }

    public int contarHojas() {
        if (raiz == null) return 0;
        return raiz.contarHojas();
    }

    public int altura() {
        if (raiz == null) return -1;
        return raiz.altura();
    }

    public String porNiveles() {
        StringBuilder sb = new StringBuilder();
        Queue<NodoAG<T>> cola = new LinkedList<>();
        if (raiz != null)
            cola.offer(raiz);
        while (!cola.isEmpty()) {
            NodoAG<T> actual = cola.poll();
            sb.append(actual.getDato()).append(" ");
            NodoAG<T> hijo = actual.getPrimerHijo();
            while (hijo != null) {
                cola.offer(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return sb.toString().trim();
    }
}
