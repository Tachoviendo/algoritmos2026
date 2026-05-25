package ejercicio1;

public class ListaEnlazada {

    private Nodo cabeza;

    public void agregarFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo a = cabeza;
        while (a != null) {
            sb.append(a.dato);
            if (a.siguiente != null) sb.append(", ");
            a = a.siguiente;
        }
        return sb.append("]").toString();
    }

    // ====== A IMPLEMENTAR ======
    public void eliminarDuplicadosConsecutivos() {
    // Como un nodo x tiene info del nodo siguiente, voy a aprovechar eso para chequear los posibles duplicados.    
        Nodo actual = cabeza;
        
        while(actual != null && actual.siguiente != null){
            if (actual.dato == actual.siguiente.dato){
            // Con esta linea me aseguro que el actual (n) deje de estar enlazado con el siguiente (n+1)ya que son lo mismo(n = n+1) y pase a enlazarse con el siguiente del siguiente (n + 2).
                actual.siguiente = actual.siguiente.siguiente;
            }
            else{
                //si no eran iguales. avanzo al siguiente para volver a comprobar la condicion de arriba.
                actual = actual.siguiente;
            }


        }
    }
}
