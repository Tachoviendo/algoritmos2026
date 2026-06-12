package ucu.edu.aed.ejercicios;

import java.util.List;
import java.util.Scanner;

import ucu.edu.aed.clases.Soporte;
import ucu.edu.aed.ejer07.*;

/*
    Esto es una implementación de lo comentado en clase en la esturctura base.
 */

public class Ejer07 {
/**
	 * Cantidad de veces que se repite cada prueba.
	 *
	 * Se usa para reducir el margen de error en las mediciones de tiempo. En este caso, cada
	 * conjunto de búsquedas o predicciones se ejecuta 20 veces.
	 */
	private static final int RONDAS = 20;

	/**
	 * Prefijo utilizado en la Parte 5 del ejercicio.
	 *
	 * Las estructuras deben buscar o predecir todas las palabras que comienzan con este
	 * texto.
	 */
	private static final String PREFIJO = "cas";

	/**
	 * Ejecuta todo el ejercicio 7.
	 *
	 * Este método realiza las siguientes tareas:
	 * 1. Carga el listado general de palabras.
	 * 2. Carga el listado de claves que se deben buscar.
	 * 3. Mide carga, memoria y tiempo de búsqueda exacta en cinco estructuras.
	 * 4. Imprime una tabla comparativa con los resultados de búsqueda exacta.
	 * 5. Mide la predicción por prefijo en Trie, LinkedList y HashMap. 
	 * 6. Imprime una tabla comparativa con los resultados de predicción.
	 */
	public static void ejecutar() {
		// ---- Datos de entrada ----
		// Carga desde archivo el listado completo de palabras desordenadas.
		// Este listado será usado para llenar cada una de las estructuras.
		List<String> palabras = Soporte.cargarArchivo("ut03/listado-general-desordenado.txt");

		// Carga desde archivo las palabras que se deberán buscar en cada estructura.
		// Estas claves permiten medir el tiempo de búsqueda exacta.
		List<String> claves = Soporte.cargarArchivo("ut03/listado-general-palabrasBuscar.txt");

		// Muestra la cantidad total de palabras cargadas desde el archivo principal.
		System.out.println("Palabras cargadas: " + palabras.size());

		// Muestra cuántas claves se buscarán y cuántas búsquedas totales se harán,
		// considerando que cada clave se buscará durante varias rondas.
		System.out.println("Claves a buscar:   " + claves.size() + "  (x" + RONDAS + " rondas = " + (claves.size() * RONDAS) + " búsquedas)");

		// ---- Partes 2 a 4: búsqueda exacta en las 5 estructuras ----
		// Se crea un arreglo con las distintas mediciones que se van a ejecutar.
		// Cada clase representa la prueba sobre una estructura concreta.
		Medicion[] mediciones = { new MedicionLinkedList(), new MedicionArrayList(), new MedicionTrie(), new MedicionHashMap(), new MedicionTreeMap() };

		// Recorre cada estructura de medición.
		// Para cada una:
		// - informa por consola qué estructura está midiendo;
		// - carga las palabras en esa estructura;
		// - ejecuta las búsquedas exactas durante la cantidad de rondas indicada.
		for (Medicion m : mediciones) {
			System.out.println("\nMidiendo " + m.nombre() + "...");
			m.medirCarga(palabras);
			m.medirBusquedas(claves, RONDAS);
		}

		// ---- Tabla consolidada de la Parte 4 ----
		// Imprime el título de la tabla de resultados para las búsquedas exactas.
		System.out.println("\n================= PARTE 4: BÚSQUEDA EXACTA =================");

		// Imprime el encabezado de la tabla con formato de columnas alineadas.
		// %-12s alinea el texto a la izquierda en 12 espacios.
		// %14s reserva 14 espacios para alinear valores a la derecha.
		System.out.printf("%-12s %14s %14s %14s%n", "Estructura", "Memoria (MB)", "Tiempo (ms)", "Encontradas");
		System.out.println("-------------------------------------------------------------");

		// Recorre las mediciones ya realizadas e imprime los resultados obtenidos:
		// nombre de la estructura, memoria usada, tiempo total y cantidad encontrada.
		for (Medicion m : mediciones) {
			System.out.printf("%-12s %14.2f %14.2f %14d%n", m.nombre(), m.getMemoriaMB(), m.getTiempoMs(), m.getEncontradas());
		}

		// ---- Parte 5: predecir palabras con prefijo "cas" ----
		// Se crea un arreglo con las estructuras que implementan predicción por prefijo.
		// En este ejercicio se comparan Trie, LinkedList y HashMap.
		MedicionPredecir[] predicciones = { new PredecirTrie(), new PredecirLinkedList(), new PredecirHashMap() };

		// Recorre cada estructura de predicción.
		// Para cada una:
		// - carga las palabras;
		// - ejecuta la predicción usando el prefijo definido en PREFIJO;
		// - repite la operación durante la cantidad de rondas indicada.
		for (MedicionPredecir p : predicciones) {
			System.out.println("\nMidiendo predecir con " + p.nombre() + "...");
			p.medirCarga(palabras);
			p.medirPredicciones(PREFIJO, RONDAS);
		}

		// Imprime el título de la tabla de resultados para la predicción por prefijo.
		System.out.println("\n========== PARTE 5: PREDECIR \"" + PREFIJO + "\" (x" + RONDAS + ") ==========");

		// Imprime el encabezado de la tabla de predicciones.
		System.out.printf("%-12s %14s %14s %14s%n", "Estructura", "Memoria (MB)", "Tiempo (ms)", "Resultados");
		System.out.println("-------------------------------------------------------------");

		// Recorre las predicciones ya ejecutadas e imprime:
		// nombre de la estructura, memoria usada, tiempo total y cantidad de resultados.
		for (MedicionPredecir p : predicciones) {
			System.out.printf("%-12s %14.2f %14.2f %14d%n", p.nombre(), p.getMemoriaMB(), p.getTiempoMs(), p.getCantidadResultados());
		}
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("\nPresione ENTER para finalizar...");
			scanner.nextLine();
		}
	}

}
