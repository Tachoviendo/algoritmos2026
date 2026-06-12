package ucu.edu.aed.clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Soporte {
    	/**
	 * Carga todas las líneas de un archivo de texto.
	 * 
	 * @param ruta es la ruta relativa al proyecto.
	 * @return lista con una entrada por línea del archivo
	 */
	public static List<String> cargarArchivo(String ruta) {
		List<String> lineas = new ArrayList<>();
		try (BufferedReader br = abrirLectura(ruta)) {
			String linea;
			while ((linea = br.readLine()) != null) {
				lineas.add(linea);
			}
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + ruta);
			e.printStackTrace();
		}
		return lineas;
	}

	private static BufferedReader abrirLectura(String ruta) throws IOException {
		Path path = Paths.get(ruta);
		if (Files.exists(path)) {
			return Files.newBufferedReader(path, StandardCharsets.UTF_8);
		}

		String recurso = ruta.startsWith("/") ? ruta.substring(1) : ruta;
		InputStream inputStream = Soporte.class.getClassLoader().getResourceAsStream(recurso);
		if (inputStream != null) {
			return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
		}

		throw new IOException("No se encontró el archivo ni el recurso: " + ruta);
	}
}
