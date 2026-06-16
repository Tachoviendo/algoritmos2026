package ucu.edu.aed.clases;

import java.util.HashMap;
import java.util.Map;

/* Nodo del trie comprimido Patricia.
   Las aristas guardan cadenas enteras en lugar de un solo carácter. */
public class NodoPatricia {
    Map<String, NodoPatricia> aristas = new HashMap<>();
    boolean esPalabra = false;
}
