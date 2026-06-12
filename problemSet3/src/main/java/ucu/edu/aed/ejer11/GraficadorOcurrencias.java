package ucu.edu.aed.ejer11;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/* Recibe un hasmap<String, Integer> y grafica la key con mayor ocurrencia */
public class GraficadorOcurrencias {
    public static void graficarTop10(Map<String, Integer> palabras) {
        List<Entry<String, Integer>> lista = new ArrayList<>(palabras.entrySet());

        // Ordenar de mayor a menor cantidad de ocurrencias
        lista.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("=== TOP 10 PALABRAS ===");
        int limite = Math.min(10, lista.size());
        for (int i = 0; i < limite; i++) {
            Entry<String, Integer> entrada = lista.get(i);

            String palabra = entrada.getKey();
            int ocurrencias = entrada.getValue();

            System.out.printf("%-15s | %s (%d)%n",palabra,"*".repeat(ocurrencias),ocurrencias);
        }
    }
}
