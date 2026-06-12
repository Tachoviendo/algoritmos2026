package ucu.edu.aed.ejer07;

import java.util.List;
import java.util.TreeMap;

/**
 * Medición sobre java.util.TreeMap (árbol rojo-negro: un árbol binario
 * de búsqueda balanceado, primo del AVL que vimos en la unidad).
 *
 * Qué esperar: containsKey baja por el árbol comparando claves ->
 * O(log n). Con n = 79.355, son ~17 comparaciones de String por
 * búsqueda: más lento que HashMap, muchísimo más rápido que las
 * listas. Su ventaja (que acá no usamos) es mantener las claves
 * ordenadas.
 */
public class MedicionTreeMap extends Medicion {

	private TreeMap<String, Integer> estructura = new TreeMap<>();

	@Override
	public String nombre() {
		return "TreeMap";
	}

	@Override
	protected void cargar(List<String> palabras) {
		// Igual que HashMap: clave repetida reemplaza, no duplica.
		for (String palabra : palabras) {
			estructura.put(palabra, 1);
		}
	}

	@Override
	protected boolean buscar(String clave) {
		// O(log n): desciende por el árbol balanceado comparando.
		return estructura.containsKey(clave);
	}

}
