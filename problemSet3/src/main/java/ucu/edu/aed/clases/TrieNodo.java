package ucu.edu.aed.clases;

import java.util.List;

/* Nodo del trie. Cada posición del array hijos[] corresponde a una letra:
   hijos[0]='a', hijos[1]='b', ..., hijos[25]='z'.
   La letra no se guarda en el nodo; queda implícita en la posición del padre. */
public class TrieNodo {

    public static final int CANTIDAD_LETRAS = 26;

    private TrieNodo[] hijos;
    private boolean esPalabra;

    public TrieNodo() {
        this.hijos = new TrieNodo[CANTIDAD_LETRAS];
        this.esPalabra = false;
    }

    /* 'a'-'a'=0, 'b'-'a'=1, ..., 'z'-'a'=25 */
    private int indice(char letra) {
        return letra - 'a';
    }

    public void insertar(String palabra, int pos) {
        if (pos == palabra.length()) {
            this.esPalabra = true;
        } else {
            int i = indice(palabra.charAt(pos));
            if (this.hijos[i] == null) {
                this.hijos[i] = new TrieNodo();
            }
            this.hijos[i].insertar(palabra, pos + 1);
        }
    }

    public boolean buscar(String palabra, int pos) {
        if (pos == palabra.length()) {
            return this.esPalabra;
        }
        int i = indice(palabra.charAt(pos));
        if (this.hijos[i] == null) {
            return false;
        }
        return this.hijos[i].buscar(palabra, pos + 1);
    }

    /* Baja por el prefijo sin exigir esPalabra; devuelve null si el camino no existe. */
    public TrieNodo descender(String prefijo, int pos) {
        if (pos == prefijo.length()) {
            return this;
        }
        int i = indice(prefijo.charAt(pos));
        if (this.hijos[i] == null) {
            return null;
        }
        return this.hijos[i].descender(prefijo, pos + 1);
    }

    /* DFS que acumula letras en 'prefijo' y agrega a 'resultado' cada vez que encuentra esPalabra.
       Como hijos[] está ordenado a..z, la lista sale en orden alfabético. */
    public void recolectar(String prefijo, List<String> resultado) {
        if (this.esPalabra) {
            resultado.add(prefijo);
        }
        for (int i = 0; i < CANTIDAD_LETRAS; i++) {
            if (this.hijos[i] != null) {
                char letra = (char) ('a' + i);
                this.hijos[i].recolectar(prefijo + letra, resultado);
            }
        }
    }

}
