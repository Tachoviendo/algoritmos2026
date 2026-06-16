package ucu.edu.aed.clases;

import java.util.HashMap;
import java.util.Map;

/* Nodo del trie con HashMap en lugar del array fijo de 26.
   Ventaja: soporta cualquier alfabeto (minúsculas, mayúsculas, acentos, etc.)
   sin tocar el código. */
public class TNodoTrieHashMap {
    Map<Character, TNodoTrieHashMap> hijos = new HashMap<>();
    boolean esPalabra = false;
}
