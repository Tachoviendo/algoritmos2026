package ucu.edu.aed.clases;

import java.util.ArrayList;
import java.util.List;

/**
 * TDA Trie para palabras en minúsculas del alfabeto a..z.
 *
 * Sigue el patrón de la unidad: el ÁRBOL expone las operaciones públicas
 * y delega el trabajo recursivo en los métodos del NODO. El árbol solo
 * conoce la raíz y resuelve los casos borde (palabra vacía, prefijo
 * inexistente); el nodo hace la recursión letra por letra.
 *
 * La raíz es un nodo "vacío" que no representa ninguna letra: representa
 * el prefijo "" (cadena vacía), del que descienden todas las palabras.
 */
public class Trie {

	/** Raíz del trie. Nunca es null, aunque el trie esté vacío. */
	private TrieNodo raiz;

	/** Crea un trie vacío: solo la raíz, sin palabras. */
	public Trie() {
		this.raiz = new TrieNodo();
	}

	/**
	 * MÉTODO DEL ÁRBOL: inserta una palabra en el trie.
	 * Si la palabra ya estaba, no pasa nada (el trie no guarda duplicados:
	 * insertar dos veces "casa" deja el mismo único camino marcado).
	 *
	 * Orden: O(L), con L = largo de la palabra. No depende de cuántas
	 * palabras haya en el trie: esa es la gracia de la estructura.
	 *
	 * @param palabra palabra en minúsculas a..z, no nula
	 */
	public void insertar(String palabra) {
		if (palabra != null && !palabra.isEmpty()) {
			// El árbol delega: la raíz procesa desde la letra 0.
			this.raiz.insertar(palabra, 0);
		}
	}

	/**
	 * MÉTODO DEL ÁRBOL: indica si la palabra completa está en el trie.
	 *
	 * Orden: O(L), con L = largo de la palabra buscada.
	 *
	 * @return true si la palabra fue insertada; false en otro caso
	 */
	public boolean buscar(String palabra) {
		if (palabra == null || palabra.isEmpty()) {
			return false;
		}
		return this.raiz.buscar(palabra, 0);
	}

	/**
	 * MÉTODO DEL ÁRBOL: devuelve todas las palabras que comienzan con
	 * el prefijo dado (la operación de "autocompletar" o "predecir").
	 *
	 * Se resuelve en dos pasos:
	 *   1. descender: ubicar el nodo donde termina el prefijo — O(P)
	 *   2. recolectar: DFS del subárbol juntando las palabras — O(K)
	 * con P = largo del prefijo y K = tamaño del subárbol resultante.
	 * Lo importante: NO se recorre el resto del trie.
	 *
	 * @param prefijo prefijo a completar; si es vacío devuelve todas las palabras
	 * @return lista (posiblemente vacía) de palabras con ese prefijo
	 */
	public List<String> predecir(String prefijo) {
		List<String> resultado = new ArrayList<>();
		if (prefijo == null) {
			return resultado;
		}
		// Paso 1: bajar hasta el final del prefijo.
		TrieNodo nodo = this.raiz.descender(prefijo, 0);
		if (nodo != null) {
			// Paso 2: juntar todas las palabras que cuelgan de ahí.
			nodo.recolectar(prefijo, resultado);
		}
		return resultado;
	}

}
