package ucu.edu.aed.clases;

import java.util.List;

/**
 * Nodo de un trie para el alfabeto a..z.
 *
 * Cada nodo tiene un vector fijo de 26 hijos: la posición 0 corresponde
 * a la letra 'a', la 1 a la 'b', y así hasta la 25 ('z'). El truco está
 * en que la letra NO se guarda en el nodo: queda implícita en la
 * posición del vector del padre que apunta a este nodo.
 *
 * El nodo no sabe nada de "palabras completas": solo sabe si él mismo
 * marca el final de una palabra (esPalabra). El camino desde la raíz
 * hasta este nodo es el que "deletrea" la palabra.
 */
public class TrieNodo {

	/** Cantidad de letras del alfabeto (a..z, sin ñ ni acentos). */
	public static final int CANTIDAD_LETRAS = 26;

	/** Hijos del nodo: hijos[0] = subárbol de 'a', ..., hijos[25] = subárbol de 'z'. */
	private TrieNodo[] hijos;

	/** true si el camino desde la raíz hasta este nodo forma una palabra completa. */
	private boolean esPalabra;

	/**
	 * Crea un nodo vacío: sin hijos y sin marcar palabra.
	 * Los hijos se crean recién cuando una inserción los necesita
	 * (por eso el vector arranca lleno de null).
	 */
	public TrieNodo() {
		this.hijos = new TrieNodo[CANTIDAD_LETRAS];
		this.esPalabra = false;
	}

	/**
	 * Traduce una letra a su posición en el vector de hijos.
	 * Aprovecha que en ASCII las letras a..z son consecutivas:
	 * 'a' - 'a' = 0, 'b' - 'a' = 1, ..., 'z' - 'a' = 25.
	 */
	private int indice(char letra) {
		return letra - 'a';
	}

	/**
	 * MÉTODO DEL NODO: inserta el sufijo de la palabra que empieza
	 * en la posición pos.
	 *
	 * Caso base: si pos llegó al largo de la palabra, este nodo es el
	 * final de la palabra y se marca esPalabra.
	 * Caso recursivo: se toma la letra actual, se crea el hijo si no
	 * existe, y se delega el resto de la palabra en ese hijo.
	 *
	 * @param palabra palabra completa que se está insertando
	 * @param pos     posición de la letra que le toca procesar a este nodo
	 */
	public void insertar(String palabra, int pos) {
		if (pos == palabra.length()) {
			// Consumimos todas las letras: este nodo marca el fin de la palabra.
			this.esPalabra = true;
		} else {
			int i = indice(palabra.charAt(pos));
			if (this.hijos[i] == null) {
				// El camino no existía hasta acá: lo vamos construyendo.
				this.hijos[i] = new TrieNodo();
			}
			// Delegamos la letra siguiente en el hijo correspondiente.
			this.hijos[i].insertar(palabra, pos + 1);
		}
	}

	/**
	 * MÉTODO DEL NODO: busca el sufijo de la palabra que empieza en pos.
	 *
	 * @return true solo si el camino completo existe Y el último nodo
	 *         está marcado como palabra. Que exista el camino no alcanza:
	 *         "cas" puede ser camino hacia "casa" sin ser palabra insertada.
	 */
	public boolean buscar(String palabra, int pos) {
		if (pos == palabra.length()) {
			// Se recorrió toda la palabra: es palabra solo si este nodo lo marca.
			return this.esPalabra;
		}
		int i = indice(palabra.charAt(pos));
		if (this.hijos[i] == null) {
			// El camino se corta antes de terminar la palabra: no está.
			return false;
		}
		return this.hijos[i].buscar(palabra, pos + 1);
	}

	/**
	 * MÉTODO DEL NODO: localiza el nodo al que se llega siguiendo el
	 * prefijo desde este nodo. Es la primera mitad de "predecir".
	 *
	 * @return el nodo que corresponde al final del prefijo, o null si
	 *         el prefijo no existe en el trie.
	 */
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

	/**
	 * MÉTODO DEL NODO: recolecta todas las palabras del subárbol que
	 * cuelga de este nodo. Es la segunda mitad de "predecir".
	 *
	 * Hace un recorrido en profundidad (DFS): cada vez que baja a un
	 * hijo, agrega la letra correspondiente al prefijo acumulado.
	 *
	 * @param prefijo   las letras acumuladas desde la raíz hasta este nodo
	 * @param resultado lista donde se van agregando las palabras encontradas
	 */
	public void recolectar(String prefijo, List<String> resultado) {
		if (this.esPalabra) {
			// El camino hasta acá es una palabra completa: la sumamos.
			resultado.add(prefijo);
		}
		for (int i = 0; i < CANTIDAD_LETRAS; i++) {
			if (this.hijos[i] != null) {
				// Reconstruimos la letra a partir de la posición: 0 -> 'a', etc.
				char letra = (char) ('a' + i);
				this.hijos[i].recolectar(prefijo + letra, resultado);
			}
		}
	}

}

