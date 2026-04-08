package ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Implementación principal de ProcesadorTexto.
Se encarga de contar palabras en un texto, separando por espacios y descartando vacíos.
*/
public class ContadorPalabras implements ProcesadorTexto {

    private String nombre;

    public ContadorPalabras() {
        this.nombre = "ContadorPalabras";
    }

    public ContadorPalabras(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Cuenta las palabras de un String separando por uno o más espacios
    @Override
    public int contarPalabras(String texto) {
        if (texto == null || texto.trim().isEmpty()) return 0;
        // split con regex "\\s+" separa por cualquier cantidad de espacios/tabs/saltos
        return texto.trim().split("\\s+").length;
    }

    // Sobrecarga: recibe un arreglo de líneas y suma las palabras de cada una
    @Override
    public int contarPalabras(String[] lineas) {
        if (lineas == null) return 0;
        int total = 0;
        for (String linea : lineas) {
            total += contarPalabras(linea);
        }
        return total;
    }

    // Devuelve un ResultadoAnalisis con más info que solo el conteo
    public ResultadoAnalisis analizar(String texto) {
        int palabras = contarPalabras(texto);
        // contamos las líneas por saltos de línea
        int lineas = texto == null || texto.isEmpty() ? 0 : texto.split("\n").length;
        return new ResultadoAnalisis(texto, palabras, lineas);
    }

    // Lee las líneas de un archivo y las devuelve como arreglo
    // Si algo sale mal (archivo no existe, permisos, etc.) avisa y devuelve arreglo vacío
    public String[] obtenerLineas(String archivo) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo '" + archivo + "': " + e.getMessage());
        }
        return lineas.toArray(new String[0]);
    }

    // Cuenta las palabras totales de un archivo leyendo sus líneas
    public int contarPalabrasArchivo(String archivo) {
        return contarPalabras(obtenerLineas(archivo));
    }

    // ===== INTERSECCIÓN CON ARREGLOS =====
    // Buscamos manualmente qué palabras están en los dos arreglos.
    // Desventaja: O(n*m), por cada palabra de a recorremos todo b. Con arreglos grandes es lento.
    public String[] palabrasComunesArreglo(String[] a, String[] b) {
        if (a == null || b == null) return new String[0];
        List<String> comunes = new ArrayList<>();
        for (String pa : a) {
            for (String pb : b) {
                if (pa.equalsIgnoreCase(pb) && !comunes.contains(pa)) {
                    comunes.add(pa);
                }
            }
        }
        return comunes.toArray(new String[0]);
    }

    // ===== INTERSECCIÓN CON COLECCIONES =====
    // Usamos HashSet para la intersección. Ventaja: buscar en un Set es O(1) en promedio,
    // así que el total es O(n+m) en vez de O(n*m). Mucho más eficiente con listas grandes.
    public String[] palabrasComunesColeccion(String[] a, String[] b) {
        if (a == null || b == null) return new String[0];
        Set<String> setA = new HashSet<>();
        for (String pa : a) setA.add(pa.toLowerCase());

        List<String> comunes = new ArrayList<>();
        for (String pb : b) {
            String pbLower = pb.toLowerCase();
            if (setA.contains(pbLower) && !comunes.contains(pbLower)) {
                comunes.add(pbLower);
            }
        }
        return comunes.toArray(new String[0]);
    }

    @Override
    public String toString() {
        return "ContadorPalabras{nombre='" + nombre + "'}";
    }
}
