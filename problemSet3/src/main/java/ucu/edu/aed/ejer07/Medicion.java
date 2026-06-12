package ucu.edu.aed.ejer07;

import java.util.List;

/**
 * Clase base para medir el rendimiento de una estructura de datos
 * en dos dimensiones: memoria consumida al cargar las palabras y
 * tiempo de ejecución de las búsquedas.
 *
 * Cada estructura concreta (LinkedList, ArrayList, Trie, HashMap,
 * TreeMap) extiende esta clase e implementa solo dos cosas:
 *   - cargar(palabras): cómo se insertan las palabras en SU estructura
 *   - buscar(clave):    cómo se busca una clave en SU estructura
 *
 * La mecánica de medición (memoria y cronómetro) vive acá, una sola
 * vez, para que TODAS las estructuras se midan exactamente igual.
 * Si cada clase midiera a su manera, la comparación no valdría nada.
 */
public abstract class Medicion {

	/** Memoria medida en la carga, en megabytes. */
	private double memoriaMB;

	/** Tiempo total de las búsquedas, en milisegundos. */
	private double tiempoMs;

	/** Cantidad de búsquedas que encontraron la clave (control de sanidad). */
	private int encontradas;

	/** @return nombre de la estructura, para mostrar en la tabla */
	public abstract String nombre();

	/** Inserta todas las palabras en la estructura concreta. */
	protected abstract void cargar(List<String> palabras);

	/** Busca una clave en la estructura concreta. */
	protected abstract boolean buscar(String clave);

	/**
	 * Mide cuánta memoria queda ocupada después de cargar las palabras.
	 *
	 * Técnica: memoria usada = totalMemory() - freeMemory(). Se mide
	 * antes y después de cargar, y la diferencia es lo que ocupa la
	 * estructura. Se invoca System.gc() antes de cada medición para
	 * pedirle a la JVM que limpie basura previa y la foto sea más justa.
	 *
	 * ADVERTENCIA HONESTA: System.gc() es una sugerencia, no una orden.
	 * La medición es aproximada y puede variar entre corridas. Para
	 * comparar órdenes de magnitud entre estructuras alcanza y sobra,
	 * que es lo que pide el ejercicio.
	 */
	public void medirCarga(List<String> palabras) {
		Runtime rt = Runtime.getRuntime();

		System.gc();
		double antes = rt.totalMemory() - rt.freeMemory();

		cargar(palabras); // <- el trabajo real lo hace la subclase

		System.gc();
		double despues = rt.totalMemory() - rt.freeMemory();

		this.memoriaMB = (despues - antes) / (1024.0 * 1024.0);
	}

	/**
	 * Ejecuta todas las búsquedas la cantidad de rondas indicada y
	 * cronometra el tiempo total con System.nanoTime().
	 *
	 * Se usa nanoTime() y no currentTimeMillis() porque nanoTime está
	 * pensado para medir intervalos (es un cronómetro), mientras que
	 * currentTimeMillis es un reloj de pared con menos resolución.
	 *
	 * Se cuentan las claves encontradas por dos motivos: verificar que
	 * las estructuras devuelven lo mismo (si una encuentra distinto,
	 * algo está mal cargado) y evitar que la JVM "optimice" y elimine
	 * búsquedas cuyo resultado nadie usa.
	 *
	 * @param claves palabras a buscar
	 * @param rondas cantidad de veces que se repite el lote completo
	 */
	public void medirBusquedas(List<String> claves, int rondas) {
		this.encontradas = 0;

		long inicio = System.nanoTime();
		for (int r = 0; r < rondas; r++) {
			for (String clave : claves) {
				if (buscar(clave)) { // <- el trabajo real lo hace la subclase
					this.encontradas++;
				}
			}
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

	public int getEncontradas() {
		return encontradas;
	}

}
