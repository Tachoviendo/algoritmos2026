package ucu.edu.aed.clases;

/* Ej 4: Trie comprimido "Patricia".
   Los tramos sin bifurcación se colapsan en una sola arista con cadena,
   en lugar de un nodo por letra. */
public class TriePatricia {

    private NodoPatricia raiz = new NodoPatricia();

    public void insertar(String palabra) {
        insertarEn(raiz, palabra);
    }

    private void insertarEn(NodoPatricia nodo, String resto) {
        if (resto.isEmpty()) {
            nodo.esPalabra = true;
            return;
        }

        String aristaEncontrada = null;
        int longitudComun = 0;
        for (String arista : nodo.aristas.keySet()) {
            int comun = prefijoComunLargo(arista, resto);
            if (comun > 0) {
                aristaEncontrada = arista;
                longitudComun = comun;
                break;
            }
        }

        if (aristaEncontrada == null) {
            NodoPatricia nuevo = new NodoPatricia();
            nuevo.esPalabra = true;
            nodo.aristas.put(resto, nuevo);

        } else if (longitudComun == aristaEncontrada.length()) {
            insertarEn(nodo.aristas.get(aristaEncontrada), resto.substring(longitudComun));

        } else {
            /* Partir la arista en el punto donde divergen.
               Ej: arista="bear", resto="bell" → común="be"
               Antes:  nodo --"bear"--> hijoOriginal
               Después: nodo --"be"--> medio --"ar"--> hijoOriginal
                                             --"ll"--> nuevo        */
            NodoPatricia hijoOriginal = nodo.aristas.remove(aristaEncontrada);
            NodoPatricia nodoMedio = new NodoPatricia();
            nodo.aristas.put(aristaEncontrada.substring(0, longitudComun), nodoMedio);
            nodoMedio.aristas.put(aristaEncontrada.substring(longitudComun), hijoOriginal);
            insertarEn(nodoMedio, resto.substring(longitudComun));
        }
    }

    private int prefijoComunLargo(String a, String b) {
        int i = 0;
        while (i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return i;
    }

    public boolean buscar(String palabra) {
        return buscarEn(raiz, palabra);
    }

    private boolean buscarEn(NodoPatricia nodo, String resto) {
        if (resto.isEmpty()) {
            return nodo.esPalabra;
        }
        for (String arista : nodo.aristas.keySet()) {
            if (resto.startsWith(arista)) {
                return buscarEn(nodo.aristas.get(arista), resto.substring(arista.length()));
            }
        }
        return false;
    }

    public int contarNodos() {
        return contarEn(raiz);
    }

    private int contarEn(NodoPatricia nodo) {
        int total = 1;
        for (NodoPatricia hijo : nodo.aristas.values()) {
            total += contarEn(hijo);
        }
        return total;
    }

}
