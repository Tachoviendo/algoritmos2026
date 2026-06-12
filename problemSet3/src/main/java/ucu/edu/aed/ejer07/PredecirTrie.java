package ucu.edu.aed.ejer07;

import java.util.List;

import ucu.edu.aed.clases.Trie;

/**
 * Predecir con Trie: la estructura está LITERALMENTE diseñada para esto.
 *
 * Desciende hasta el final del prefijo (O(P)) y recolecta solo el
 * subárbol que cuelga de ahí (O(K), con K proporcional al tamaño del
 * resultado). El resto de las ~79.000 palabras ni se mira.
 */
public class PredecirTrie extends MedicionPredecir {

	private Trie estructura = new Trie();

	@Override
	public String nombre() {
		return "Trie";
	}

	@Override
	protected void cargar(List<String> palabras) {
		for (String palabra : palabras) {
			estructura.insertar(palabra);
		}
	}

	@Override
	protected List<String> predecir(String prefijo) {
		// O(P + K): baja por el prefijo y junta el subárbol. Nada más.
		return estructura.predecir(prefijo);
	}

}
