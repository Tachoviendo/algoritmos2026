package ucu.edu.aed.ejer07;

import java.util.HashMap;
import java.util.List;

/**
 * Medición sobre java.util.HashMap.
 *
 * La palabra es la CLAVE; como valor se guarda un entero sin significado
 * (acá solo nos interesa la pertenencia, no asociar datos).
 *
 * Qué esperar: containsKey calcula el hashCode de la clave, va directo
 * al bucket y compara con las (pocas) claves que cayeron ahí ->
 * O(1) promedio. Debería ser, por lejos, la búsqueda más rápida.
 */
public class MedicionHashMap extends Medicion {

	private HashMap<String, Integer> estructura = new HashMap<>();

	@Override
	public String nombre() {
		return "HashMap";
	}

	@Override
	protected void cargar(List<String> palabras) {
		// put sobre una clave repetida REEMPLAZA la entrada: los 1.027
		// duplicados del archivo colapsan y quedan 79.355 claves.
		for (String palabra : palabras) {
			estructura.put(palabra, 1);
		}
	}

	@Override
	protected boolean buscar(String clave) {
		// O(1) promedio: hash -> bucket -> comparación puntual.
		return estructura.containsKey(clave);
	}

}
