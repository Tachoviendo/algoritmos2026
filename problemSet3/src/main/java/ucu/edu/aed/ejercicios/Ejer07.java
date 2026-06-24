package ucu.edu.aed.ejercicios;

import java.util.List;
import java.util.Scanner;

import ucu.edu.aed.clases.Soporte;
import ucu.edu.aed.ejer07.*;

public class Ejer07 {

	private static final int RONDAS = 20;
	private static final String PREFIJO = "cas";

	public static void ejecutar() {
		List<String> palabras = Soporte.cargarArchivo("ut03/listado-general-desordenado.txt");
		List<String> claves = Soporte.cargarArchivo("ut03/listado-general-palabrasBuscar.txt");

		System.out.println("Palabras cargadas: " + palabras.size());
		System.out.println("Claves a buscar:   " + claves.size() + "  (x" + RONDAS + " rondas = " + (claves.size() * RONDAS) + " búsquedas)");

		Medicion[] mediciones = { new MedicionLinkedList(), new MedicionArrayList(), new MedicionTrie(), new MedicionHashMap(), new MedicionTreeMap() };

		for (Medicion m : mediciones) {
			System.out.println("\nMidiendo " + m.nombre() + "...");
			m.medirCarga(palabras);
			m.medirBusquedas(claves, RONDAS);
		}

		System.out.println("\n================= PARTE 4: BÚSQUEDA EXACTA =================");
		System.out.printf("%-12s %14s %14s %14s%n", "Estructura", "Memoria (MB)", "Tiempo (ms)", "Encontradas");
		System.out.println("-------------------------------------------------------------");
		for (Medicion m : mediciones) {
			System.out.printf("%-12s %14.2f %14.2f %14d%n", m.nombre(), m.getMemoriaMB(), m.getTiempoMs(), m.getEncontradas());
		}

		MedicionPredecir[] predicciones = { new PredecirTrie(), new PredecirLinkedList(), new PredecirHashMap() };

		for (MedicionPredecir p : predicciones) {
			System.out.println("\nMidiendo predecir con " + p.nombre() + "...");
			p.medirCarga(palabras);
			p.medirPredicciones(PREFIJO, RONDAS);
		}

		System.out.println("\n========== PARTE 5: PREDECIR \"" + PREFIJO + "\" (x" + RONDAS + ") ==========");
		System.out.printf("%-12s %14s %14s %14s%n", "Estructura", "Memoria (MB)", "Tiempo (ms)", "Resultados");
		System.out.println("-------------------------------------------------------------");
		for (MedicionPredecir p : predicciones) {
			System.out.printf("%-12s %14.2f %14.2f %14d%n", p.nombre(), p.getMemoriaMB(), p.getTiempoMs(), p.getCantidadResultados());
		}

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("\nPresione ENTER para finalizar...");
			scanner.nextLine();
		}
	}

}
