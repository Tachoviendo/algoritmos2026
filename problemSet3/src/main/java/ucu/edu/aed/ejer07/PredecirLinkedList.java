package ucu.edu.aed.ejer07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Predecir con LinkedList: no hay atajo posible.
 *
 * La lista no sabe nada de prefijos, así que la única opción es
 * recorrer TODAS las palabras y preguntarle a cada una si empieza
 * con el prefijo -> O(n · P) por predicción, siempre, sin importar
 * cuántos resultados haya.
 */
public class PredecirLinkedList extends MedicionPredecir {

	private LinkedList<String> estructura = new LinkedList<>();

	@Override
	public String nombre() {
		return "LinkedList";
	}

	@Override
	protected void cargar(List<String> palabras) {
		estructura.addAll(palabras);
	}

	@Override
	protected List<String> predecir(String prefijo) {
		List<String> resultado = new ArrayList<>();
		// Recorrido completo: las 80.382 entradas, encuentre lo que encuentre.
		for (String palabra : estructura) {
			if (palabra.startsWith(prefijo)) {
				resultado.add(palabra);
			}
		}
		return resultado;
	}

}
