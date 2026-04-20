package com.example.clases;

public class Conjunto<T> {
    private Lista<T> elementos;

    public Conjunto() {
        elementos = new Lista<>();
    }

    public void insertar(T dato) {
        if (!contiene(dato)) {
            elementos.insertar(dato);
        }
    }

    public boolean contiene(T dato) {
        Nodo<T> aux = elementos.getPrimero();
        while (aux != null) {
            if (aux.dato.equals(dato)) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    public void eliminar(T dato) {
        elementos.eliminar(dato);
    }

    public boolean estaVacio() {
        return elementos.getPrimero() == null;
    }

    public Conjunto<T> union(Conjunto<T> otro) {
        Conjunto<T> resultado = new Conjunto<>();
        Nodo<T> aux = this.elementos.getPrimero();
        while (aux != null) {
            resultado.insertar(aux.dato);
            aux = aux.siguiente;
        }
        aux = otro.elementos.getPrimero();
        while (aux != null) {
            resultado.insertar(aux.dato);
            aux = aux.siguiente;
        }
        return resultado;
    }

    public Conjunto<T> interseccion(Conjunto<T> otro) {
        Conjunto<T> resultado = new Conjunto<>();
        Nodo<T> aux = this.elementos.getPrimero();
        while (aux != null) {
            if (otro.contiene(aux.dato)) {
                resultado.insertar(aux.dato);
            }
            aux = aux.siguiente;
        }
        return resultado;
    }

    public void listar() {
        Nodo<T> aux = elementos.getPrimero();
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    public Nodo<T> getPrimero() {
        return elementos.getPrimero();
    }
}
