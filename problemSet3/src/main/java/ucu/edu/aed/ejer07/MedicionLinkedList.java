package ucu.edu.aed.ejer07;

import java.util.LinkedList;
import java.util.List;

/**
 * Medición sobre java.util.LinkedList (lista doblemente enlazada).
 *
 * ESTA ES LA CLASE QUE SE PROVEE COMO EJEMPLO: las mediciones de las
 * demás estructuras deben seguir exactamente este formato.
 *
 * Qué esperar: contains() recorre la lista nodo por nodo comparando
 * con equals -> búsqueda O(n). Con ~80.000 palabras y miles de
 * búsquedas, el costo se nota.
 */
public class MedicionLinkedList extends Medicion {

	private LinkedList<String> estructura = new LinkedList<>();

	@Override
	public String nombre() {
		return "LinkedList";
	}

	@Override
	protected void cargar(List<String> palabras) {
		// addAll agrega TODAS las líneas, duplicados incluidos:
		// una lista no tiene noción de clave repetida.
		estructura.addAll(palabras);
	}

	@Override
	protected boolean buscar(String clave) {
		// O(n): recorre desde el primer nodo hasta encontrar (o no) la clave.
		return estructura.contains(clave);
	}

}
