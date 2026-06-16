package ucu.edu.aed.ejer16;

import ucu.edu.aed.tda.generic_trie.TArbolGenerico;
import ucu.edu.aed.tda.generic_trie.TNodoGenerico;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ArbolGenerico<T extends Comparable<T>> implements TArbolGenerico<T> {

    private NodoArbolGenerico<T> raiz;

    public ArbolGenerico(T raiz) {
        this.raiz = new NodoArbolGenerico<>(raiz);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean agregarHijo(Comparable<T> padre, T hijo) {
        if (raiz == null) return false;
        return raiz.agregarHijo((T) padre, hijo);
    }

    @Override
    public void eliminar(Comparable<T> criterio) {
        if (raiz == null) return;
        if (criterio.compareTo(raiz.dato) == 0) {
            raiz = null;
            return;
        }
        raiz.eliminar(criterio);
    }

    @Override
    public T obtenerPadre(Comparable<T> criterio) {
        if (raiz == null) return null;
        if (criterio.compareTo(raiz.dato) == 0) return null; // la raíz no tiene padre
        TNodoGenerico<T> nodo = raiz.obtenerPadre(criterio);
        return nodo != null ? nodo.getDato() : null;
    }

    @Override
    public T buscar(Comparable<T> criterio) {
        if (raiz == null) return null;
        TNodoGenerico<T> nodo = raiz.buscar(criterio);
        return nodo != null ? nodo.getDato() : null;
    }

    @Override
    public void preOrden(Consumer<T> consumidor) {
        if (raiz != null) raiz.preOrden(nodo -> consumidor.accept(nodo.getDato()));
    }

    @Override
    public void inOrden(Consumer<T> consumidor) {
        if (raiz != null) raiz.inOrden(nodo -> consumidor.accept(nodo.getDato()));
    }

    @Override
    public void postOrden(Consumer<T> consumidor) {
        if (raiz != null) raiz.postOrden(nodo -> consumidor.accept(nodo.getDato()));
    }

    @Override
    public void vaciar() {
        raiz = null;
    }

    @Override
    public int grado(Comparable<T> criterio) {
        if (raiz == null) return 0;
        TNodoGenerico<T> nodo = raiz.buscar(criterio);
        return nodo != null ? nodo.grado() : 0;
    }

    @Override
    public int altura(Comparable<T> criterio) {
        if (raiz == null) return -1;
        TNodoGenerico<T> nodo = raiz.buscar(criterio);
        return nodo != null ? nodo.altura() : -1;
    }

    // ---- Métodos extra para Ej 16 ----

    /* Todos los descendientes (hijos, nietos, etc.) de la persona con ese nombre. */
    public List<T> listarDescendientes(Comparable<T> criterio) {
        List<T> resultado = new ArrayList<>();
        NodoArbolGenerico<T> nodo = (NodoArbolGenerico<T>) raiz.buscar(criterio);
        if (nodo != null) {
            recolectarDescendientes(nodo, resultado);
        }
        return resultado;
    }

    private void recolectarDescendientes(NodoArbolGenerico<T> nodo, List<T> resultado) {
        for (NodoArbolGenerico<T> hijo : nodo.hijos) {
            resultado.add(hijo.dato);
            recolectarDescendientes(hijo, resultado);
        }
    }

    /* Cantidad total de nodos en el árbol. */
    public int contarNodos() {
        return raiz == null ? 0 : contarEn(raiz);
    }

    private int contarEn(NodoArbolGenerico<T> nodo) {
        int total = 1;
        for (NodoArbolGenerico<T> hijo : nodo.hijos) {
            total += contarEn(hijo);
        }
        return total;
    }

    /* Nodos en la generación indicada (raíz = generación 0). */
    public List<T> porGeneracion(int generacion) {
        List<T> resultado = new ArrayList<>();
        if (raiz != null) recolectarGeneracion(raiz, 0, generacion, resultado);
        return resultado;
    }

    private void recolectarGeneracion(NodoArbolGenerico<T> nodo, int nivel, int target, List<T> resultado) {
        if (nivel == target) {
            resultado.add(nodo.dato);
            return;
        }
        for (NodoArbolGenerico<T> hijo : nodo.hijos) {
            recolectarGeneracion(hijo, nivel + 1, target, resultado);
        }
    }

    /* true si posibleDescendiente está en el subárbol de ancestro (sin ser él mismo). */
    public boolean esDescendiente(Comparable<T> posibleDescendiente, Comparable<T> ancestro) {
        NodoArbolGenerico<T> nodoAncestro = (NodoArbolGenerico<T>) raiz.buscar(ancestro);
        if (nodoAncestro == null) return false;
        for (NodoArbolGenerico<T> hijo : nodoAncestro.hijos) {
            if (hijo.buscar(posibleDescendiente) != null) return true;
        }
        return false;
    }

    /* Ancestro común más cercano de dos nodos: último nodo compartido en los caminos desde la raíz. */
    public T ancestroComun(Comparable<T> persona1, Comparable<T> persona2) {
        List<T> camino1 = caminoDesdeRaiz(persona1);
        List<T> camino2 = caminoDesdeRaiz(persona2);
        T ancestro = null;
        int min = Math.min(camino1.size(), camino2.size());
        for (int i = 0; i < min; i++) {
            if (camino1.get(i).compareTo(camino2.get(i)) == 0) {
                ancestro = camino1.get(i);
            } else {
                break;
            }
        }
        return ancestro;
    }

    private List<T> caminoDesdeRaiz(Comparable<T> criterio) {
        List<T> camino = new ArrayList<>();
        if (raiz != null) caminoHacia(raiz, criterio, camino);
        return camino;
    }

    private boolean caminoHacia(NodoArbolGenerico<T> nodo, Comparable<T> criterio, List<T> camino) {
        camino.add(nodo.dato);
        if (criterio.compareTo(nodo.dato) == 0) return true;
        for (NodoArbolGenerico<T> hijo : nodo.hijos) {
            if (caminoHacia(hijo, criterio, camino)) return true;
        }
        camino.remove(camino.size() - 1);
        return false;
    }
}
