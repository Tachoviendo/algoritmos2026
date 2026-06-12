package ucu.edu.aed.ejer07;

import java.util.List;

/**
 * Clase base para medir las alternativas de "predecir" (autocompletar):
 * dado un prefijo, obtener todas las palabras que comienzan con él.
 *
 * Misma idea que Medicion, pero la operación medida no es buscar una
 * clave exacta sino recuperar la LISTA de palabras con un prefijo.
 */
public abstract class MedicionPredecir {

	private double memoriaMB;
	private double tiempoMs;

	/** Cantidad de palabras devueltas en la última predicción (sanidad). */
	private int cantidadResultados;

	/** @return nombre de la implementación, para la tabla */
	public abstract String nombre();

	/** Inserta todas las palabras en la estructura concreta. */
	protected abstract void cargar(List<String> palabras);

	/** Devuelve todas las palabras que comienzan con el prefijo. */
	protected abstract List<String> predecir(String prefijo);

	/** Idéntico a Medicion.medirCarga: misma técnica, mismas advertencias. */
	public void medirCarga(List<String> palabras) {
		Runtime rt = Runtime.getRuntime();

		System.gc();
		double antes = rt.totalMemory() - rt.freeMemory();

		cargar(palabras);

		System.gc();
		double despues = rt.totalMemory() - rt.freeMemory();

		this.memoriaMB = (despues - antes) / (1024.0 * 1024.0);
	}

	/**
	 * Ejecuta la predicción del prefijo la cantidad de rondas indicada
	 * y cronometra el total.
	 */
	public void medirPredicciones(String prefijo, int rondas) {
		long inicio = System.nanoTime();
		for (int r = 0; r < rondas; r++) {
			List<String> resultado = predecir(prefijo);
			// Guardamos el tamaño para verificar que todas las
			// implementaciones devuelven la misma cantidad.
			this.cantidadResultados = resultado.size();
		}
		long fin = System.nanoTime();

		this.tiempoMs = (fin - inicio) / 1_000_000.0;
	}

	public double getMemoriaMB() {
		return memoriaMB;
	}

	public double getTiempoMs() {
		return tiempoMs;
	}

	public int getCantidadResultados() {
		return cantidadResultados;
	}

}
