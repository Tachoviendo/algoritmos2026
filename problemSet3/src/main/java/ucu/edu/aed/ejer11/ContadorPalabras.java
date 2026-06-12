package ucu.edu.aed.ejer11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Recibe una lista con multiples lineas de texto cargadas */
public class ContadorPalabras {
    public static Map<String,Integer> listarOcurrencias(List<String> texto){
        Map<String, Integer> ocurrencias = new HashMap<>();
        for (String linea : texto){
            String[] palabras = linea.toLowerCase().replaceAll("[^a-zñáéíóú\\s]", "").split("\\s+");
            for (String palabra: palabras){
                ocurrencias.put(palabra, ocurrencias.getOrDefault(palabra, 0)+1);
            }
        }
        return ocurrencias;
    }

    /* A partir de un hashmap imprime la palabra con mayores ocurrencias */
    public static void imprimirMayorOcurrencia(Map<String, Integer> ocurrencias){

        if (ocurrencias == null || ocurrencias.isEmpty()){
            System.out.println("Error al imprimirMayorOcurrencia: El mapa esta vacio.");
            return;
        }

        String mayorOcurrencia="";
        int cantOcurrencias=-1;

        for (Map.Entry<String, Integer> palabra : ocurrencias.entrySet()) {
            if (palabra.getValue() > cantOcurrencias){
                cantOcurrencias=palabra.getValue();
                mayorOcurrencia=palabra.getKey();
            }
        }

        System.out.println("Palabra con mas ocurrencias: '"+mayorOcurrencia+"' con "+cantOcurrencias+" ocurrencias.");
    }
}
