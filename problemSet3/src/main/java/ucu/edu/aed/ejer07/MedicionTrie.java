package ucu.edu.aed.ejer07;

import java.util.List;

import ucu.edu.aed.clases.Trie;

/**
 * Medición sobre el Trie desarrollado en la unidad.
 *
 * Qué esperar: buscar es O(L), con L = largo de la palabra. No importa
 * si el trie tiene 80 mil o 8 millones de palabras: el costo depende
 * solo del largo de lo que se busca. A cambio, paga en memoria: cada
 * nodo carga un vector de 26 referencias, casi todas en null.
 */
public class MedicionTrie extends Medicion {

	private Trie estructura = new Trie();

	@Override
	public String nombre() {
		return "TTrie";
	}

	@Override
	protected void cargar(List<String> palabras) {
		// Insertar un duplicado recorre el camino ya existente y no
		// agrega nodos: el trie guarda 79.355 palabras distintas.
		for (String palabra : palabras) {
			estructura.insertar(palabra);
		}
	}

	@Override
	protected boolean buscar(String clave) {
		// O(L): desciende letra por letra desde la raíz.
		return estructura.buscar(clave);
	}

}
