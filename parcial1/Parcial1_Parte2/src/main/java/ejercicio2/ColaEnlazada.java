package ejercicio2;

public class ColaEnlazada<T> {

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
        }
    }

    private Nodo<T> frente;
    private Nodo<T> posterior;

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = nuevo;
        } else {
            posterior.siguiente = nuevo;
        }
        posterior = nuevo;
    }

    public T desencolar() {
        if (estaVacia()) throw new IllegalStateException("Cola vacia");
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) posterior = null;
        return dato;
    }

    /**
     * Representa la cola como [a, b, c, ...] desde frente hasta posterior.
     * Se usa solo para los casos de prueba; no modifica la cola.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo<T> a = frente;
        while (a != null) {
            sb.append(a.dato);
            if (a.siguiente != null) sb.append(", ");
            a = a.siguiente;
        }
        return sb.append("]").toString();
    }

    // ====== A IMPLEMENTAR ======
    public static ColaEnlazada<Integer> intercalar(
            ColaEnlazada<Integer> c1, ColaEnlazada<Integer> c2) {
        // TODO
        return null;
    }
}
