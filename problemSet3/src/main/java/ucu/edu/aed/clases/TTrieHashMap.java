package ucu.edu.aed.clases;

import java.util.ArrayList;
import java.util.List;

/* Ej 12: Trie cuyo nodo usa HashMap en lugar del array fijo.
   La lógica es idéntica a Trie/TrieNodo; solo cambia la estructura interna del nodo. */
public class TTrieHashMap {

    private TNodoTrieHashMap raiz = new TNodoTrieHashMap();

    public void insertar(String palabra) {
        TNodoTrieHashMap nodo = raiz;
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (!nodo.hijos.containsKey(c)) {
                nodo.hijos.put(c, new TNodoTrieHashMap());
            }
            nodo = nodo.hijos.get(c);
        }
        nodo.esPalabra = true;
    }

    public boolean buscar(String palabra) {
        TNodoTrieHashMap nodo = descender(palabra);
        return nodo != null && nodo.esPalabra;
    }

    public boolean empiezaCon(String prefijo) {
        return descender(prefijo) != null;
    }

    /* Autocompletar: devuelve todas las palabras que comienzan con el prefijo. */
    public List<String> predecir(String prefijo) {
        List<String> resultado = new ArrayList<>();
        TNodoTrieHashMap nodo = descender(prefijo);
        if (nodo != null) {
            recolectar(nodo, prefijo, resultado);
        }
        return resultado;
    }

    /* Devuelve las posiciones (índices) dentro del array 'texto' donde aparece 'patron'. */
    public List<Integer> buscarPatron(String[] texto, String patron) {
        List<Integer> posiciones = new ArrayList<>();
        for (int i = 0; i < texto.length; i++) {
            if (texto[i].equalsIgnoreCase(patron)) {
                posiciones.add(i);
            }
        }
        return posiciones;
    }

    /* Baja por el trie siguiendo los caracteres de 'texto'; devuelve null si el camino no existe. */
    private TNodoTrieHashMap descender(String texto) {
        TNodoTrieHashMap nodo = raiz;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (!nodo.hijos.containsKey(c)) {
                return null;
            }
            nodo = nodo.hijos.get(c);
        }
        return nodo;
    }

    private void recolectar(TNodoTrieHashMap nodo, String prefijo, List<String> resultado) {
        if (nodo.esPalabra) {
            resultado.add(prefijo);
        }
        for (char c : nodo.hijos.keySet()) {
            recolectar(nodo.hijos.get(c), prefijo + c, resultado);
        }
    }
}
