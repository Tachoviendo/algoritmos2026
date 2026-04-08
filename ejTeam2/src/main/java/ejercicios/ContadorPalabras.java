package ejercicios;

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

    @Override
    public String toString() {
        return "ContadorPalabras{nombre='" + nombre + "'}";
    }
}
