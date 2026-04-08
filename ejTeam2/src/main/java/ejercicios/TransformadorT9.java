package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/*
T9 es el sistema de escritura predictiva que usaban los teléfonos con teclado numérico.
Cada número del 2 al 9 tiene letras asignadas, igual que en un teclado de celular viejo.
Este transformador convierte texto a su representación T9.
*/
public class TransformadorT9 {

    // El mapa T9: cada letra le corresponde a un número del teclado
    private static final Map<Character, Character> T9 = Map.ofEntries(
        Map.entry('a', '2'), Map.entry('b', '2'), Map.entry('c', '2'),
        Map.entry('d', '3'), Map.entry('e', '3'), Map.entry('f', '3'),
        Map.entry('g', '4'), Map.entry('h', '4'), Map.entry('i', '4'),
        Map.entry('j', '5'), Map.entry('k', '5'), Map.entry('l', '5'),
        Map.entry('m', '6'), Map.entry('n', '6'), Map.entry('o', '6'),
        Map.entry('p', '7'), Map.entry('q', '7'), Map.entry('r', '7'), Map.entry('s', '7'),
        Map.entry('t', '8'), Map.entry('u', '8'), Map.entry('v', '8'),
        Map.entry('w', '9'), Map.entry('x', '9'), Map.entry('y', '9'), Map.entry('z', '9')
    );

    // Convierte un texto a T9. Los espacios se mantienen, los caracteres no alfabéticos se dejan igual.
    public String convertir(String texto) {
        if (texto == null) throw new IllegalArgumentException("El texto no puede ser null.");
        StringBuilder sb = new StringBuilder();
        for (char c : texto.toLowerCase().toCharArray()) {
            if (T9.containsKey(c)) {
                sb.append(T9.get(c));
            } else {
                sb.append(c); // espacios, puntuación, números, etc. pasan tal cual
            }
        }
        return sb.toString();
    }

    // Invierte el texto y luego lo convierte a T9
    public String convertirInvertido(String texto) {
        if (texto == null) throw new IllegalArgumentException("El texto no puede ser null.");
        String invertido = new StringBuilder(texto).reverse().toString();
        return convertir(invertido);
    }

    // Lee desde un archivo, convierte cada línea a T9 y escribe el resultado en otro archivo
    public void convertirArchivo(String archivoEntrada, String archivoSalida) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(convertir(linea));
                bw.newLine();
            }
        }
        // Dejamos que la IOException suba para que quien llame decida cómo manejarla
    }

    // Igual que convertirArchivo pero invierte cada línea antes de convertir
    public void convertirArchivoInvertido(String archivoEntrada, String archivoSalida) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(convertirInvertido(linea));
                bw.newLine();
            }
        }
    }
}
