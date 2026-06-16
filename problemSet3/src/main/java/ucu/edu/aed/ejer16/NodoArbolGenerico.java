package ucu.edu.aed.ejer16;

import ucu.edu.aed.tda.generic_trie.TNodoGenerico;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class NodoArbolGenerico<T extends Comparable<T>> implements TNodoGenerico<T> {

    T dato;
    List<NodoArbolGenerico<T>> hijos = new ArrayList<>();

    NodoArbolGenerico(T dato) {
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public boolean agregarHijo(T padre, T hijo) {
        if (this.dato.compareTo(padre) == 0) {
            for (NodoArbolGenerico<T> h : hijos) {
                if (h.dato.compareTo(hijo) == 0) return false; // duplicado
            }
            hijos.add(new NodoArbolGenerico<>(hijo));
            return true;
        }
        for (NodoArbolGenerico<T> h : hijos) {
            if (h.agregarHijo(padre, hijo)) return true;
        }
        return false;
    }

    @Override
    public TNodoGenerico<T> eliminar(Comparable<T> criterio) {
        for (int i = 0; i < hijos.size(); i++) {
            if (criterio.compareTo(hijos.get(i).dato) == 0) {
                return hijos.remove(i); // elimina el nodo y todo su subárbol
            }
            TNodoGenerico<T> resultado = hijos.get(i).eliminar(criterio);
            if (resultado != null) return resultado;
        }
        return null;
    }

    @Override
    public TNodoGenerico<T> buscar(Comparable<T> criterio) {
        if (criterio.compareTo(this.dato) == 0) return this;
        for (NodoArbolGenerico<T> hijo : hijos) {
            TNodoGenerico<T> resultado = hijo.buscar(criterio);
            if (resultado != null) return resultado;
        }
        return null;
    }

    @Override
    public TNodoGenerico<T> obtenerPadre(Comparable<T> criterio) {
        for (NodoArbolGenerico<T> hijo : hijos) {
            if (criterio.compareTo(hijo.dato) == 0) return this;
            TNodoGenerico<T> resultado = hijo.obtenerPadre(criterio);
            if (resultado != null) return resultado;
        }
        return null;
    }

    @Override
    public void preOrden(Consumer<TNodoGenerico<T>> consumidor) {
        consumidor.accept(this);
        for (NodoArbolGenerico<T> hijo : hijos) {
            hijo.preOrden(consumidor);
        }
    }

    /* InOrden para árbol genérico: primer hijo, raíz, resto de hijos. */
    @Override
    public void inOrden(Consumer<TNodoGenerico<T>> consumidor) {
        if (!hijos.isEmpty()) {
            hijos.get(0).inOrden(consumidor);
            consumidor.accept(this);
            for (int i = 1; i < hijos.size(); i++) {
                hijos.get(i).inOrden(consumidor);
            }
        } else {
            consumidor.accept(this);
        }
    }

    @Override
    public void postOrden(Consumer<TNodoGenerico<T>> consumidor) {
        for (NodoArbolGenerico<T> hijo : hijos) {
            hijo.postOrden(consumidor);
        }
        consumidor.accept(this);
    }

    @Override
    public int altura() {
        if (hijos.isEmpty()) return 0;
        int max = 0;
        for (NodoArbolGenerico<T> hijo : hijos) {
            max = Math.max(max, hijo.altura());
        }
        return max + 1;
    }

    @Override
    public int grado() {
        return hijos.size();
    }

    @Override
    public void vaciar() {
        hijos.clear();
    }

    @Override
    public List<T> obtenerHijos() {
        List<T> resultado = new ArrayList<>();
        for (NodoArbolGenerico<T> hijo : hijos) {
            resultado.add(hijo.dato);
        }
        return resultado;
    }
}
