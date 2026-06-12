package ucu.edu.aed.ejer07;

import java.util.ArrayList;
import java.util.List;

/**
 * Medición sobre java.util.ArrayList (vector dinámico).
 *
 * Qué esperar: contains() también es O(n), pero recorrer un vector
 * contiguo en memoria suele ser más rápido que saltar entre nodos
 * enlazados (mejor localidad de caché). Sigue siendo lineal: el
 * orden no cambia, cambia la constante.
 */
public class MedicionArrayList extends Medicion {

	private ArrayList<String> estructura = new ArrayList<>();

	@Override
	public String nombre() {
		return "ArrayList";
	}

	@Override
	protected void cargar(List<String> palabras) {
		// Igual que LinkedList: guarda las 80.383 líneas, con duplicados.
		estructura.addAll(palabras);
	}

	@Override
	protected boolean buscar(String clave) {
		// O(n): recorre el vector posición por posición.
		return estructura.contains(clave);
	}

}
