package com.example.clases;

public class Lista<T> {
    private Nodo<T> primero;

    public void insertar(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        if (primero == null){
            primero = nuevo;
        } else {
            Nodo<T> aux = primero;
            while (aux.siguiente != null){
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public void eliminar(T dato){
        if (primero == null) return;

        if (primero.dato.equals(dato)){
            primero = primero.siguiente;
            return;
        }

        Nodo<T> aux = primero;
        while ((aux.siguiente != null) && (!aux.siguiente.dato.equals(dato))){
            aux = aux.siguiente;
        }

        if (aux.siguiente != null){
            aux.siguiente = aux.siguiente.siguiente;
        }
    }
}
