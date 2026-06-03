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
    public static ColaEnlazada<Integer> intercalar( ColaEnlazada<Integer> c1, ColaEnlazada<Integer> c2) {
        
        ColaEnlazada<Integer> res = new ColaEnlazada<>();
        
        // el primer caso es que ambas colas tengan elementos. entonces voy pickeando uno y uno y me voy formando el resultado. 
        while (!c1.estaVacia() && !c2.estaVacia()){
            res.encolar(c1.desencolar());
            res.encolar(c2.desencolar());

        }
        // Si c1 tenia mas elementos que c2. los paso de una para el resultado. 
        while (!c1.estaVacia()){
            res.encolar(c1.desencolar());
        }
        
        // Y viceversa, si pasa lo contrario hago lo analogo
        while (!c2.estaVacia()){
            res.encolar(c2.desencolar());
        }

    





        return res;
    }
}
