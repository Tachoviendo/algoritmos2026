package ucu.edu.aed.clases;

import java.util.ArrayList;
import java.util.List;

/* Árbol Trie para palabras en minúsculas a..z.
   El árbol maneja la raíz y delega el trabajo recursivo en TrieNodo. */
public class Trie {

    private TrieNodo raiz;

    public Trie() {
        this.raiz = new TrieNodo();
    }

    public void insertar(String palabra) {
        if (palabra != null && !palabra.isEmpty()) {
            this.raiz.insertar(palabra, 0);
        }
    }

    public boolean buscar(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return false;
        }
        return this.raiz.buscar(palabra, 0);
    }

    /* Ej 2: true si alguna palabra del trie empieza con ese prefijo. */
    public boolean empiezaCon(String prefijo) {
        if (prefijo == null) {
            return false;
        }
        return this.raiz.descender(prefijo, 0) != null;
    }

    /* Ej 2: todas las palabras del trie en orden alfabético. */
    public List<String> listar() {
        List<String> resultado = new ArrayList<>();
        this.raiz.recolectar("", resultado);
        return resultado;
    }

    /* Ej 3: palabras que empiezan con el prefijo dado (autocompletar).
       Baja hasta el nodo del prefijo y recolecta solo ese subárbol. */
    public List<String> predecir(String prefijo) {
        List<String> resultado = new ArrayList<>();
        if (prefijo == null) {
            return resultado;
        }
        TrieNodo nodo = this.raiz.descender(prefijo, 0);
        if (nodo != null) {
            nodo.recolectar(prefijo, resultado);
        }
        return resultado;
    }

}
