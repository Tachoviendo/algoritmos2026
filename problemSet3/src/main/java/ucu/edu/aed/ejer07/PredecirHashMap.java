package ucu.edu.aed.ejer07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Predecir con HashMap: acá se cae el mito de que "el hash siempre gana".
 *
 * El hashing es imbatible para clave EXACTA, pero el hashCode de "cas"
 * no tiene ninguna relación con el de "casa": claves con el mismo
 * prefijo quedan desparramadas por toda la tabla. No queda otra que
 * recorrer TODO el keySet -> O(n · P), igual que la lista.
 */
public class PredecirHashMap extends MedicionPredecir {

	private HashMap<String, Integer> estructura = new HashMap<>();

	@Override
	public String nombre() {
		return "HashMap";
	}

	@Override
	protected void cargar(List<String> palabras) {
		for (String palabra : palabras) {
			estructura.put(palabra, 1);
		}
	}

	@Override
	protected List<String> predecir(String prefijo) {
		List<String> resultado = new ArrayList<>();
		// El hash no ayuda con prefijos: barrido completo del keySet.
		for (String palabra : estructura.keySet()) {
			if (palabra.startsWith(prefijo)) {
				resultado.add(palabra);
			}
		}
		return resultado;
	}

}
