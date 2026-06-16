package ucu.edu.aed.ejercicios;

import ucu.edu.aed.clases.TTrieHashMap;
import ucu.edu.aed.clases.Soporte;
import java.util.List;

public class Ejer12 {

    public static void ejecutar() {
        System.out.println("===== EJERCICIO 12 — Trie con HashMap =====\n");

        TTrieHashMap trie = new TTrieHashMap();

        // Demo autocompletar
        String[] palabras = {"programa", "progreso", "probar", "prueba", "casa"};
        for (String p : palabras) trie.insertar(p);

        System.out.println("Palabras insertadas: programa, progreso, probar, prueba, casa");
        System.out.println("predecir(\"pro\") → " + trie.predecir("pro"));
        System.out.println("buscar(\"progreso\") → " + trie.buscar("progreso"));
        System.out.println("buscar(\"pro\") → " + trie.buscar("pro"));
        System.out.println("empiezaCon(\"pro\") → " + trie.empiezaCon("pro"));
        System.out.println();

        // Demo búsqueda de patrón en texto
        String[] texto = {"el", "programa", "es", "un", "programa", "util", "para", "probar"};
        System.out.println("Texto: el programa es un programa util para probar");
        System.out.println("buscarPatron(\"programa\") → posiciones " + trie.buscarPatron(texto, "programa"));
        System.out.println("buscarPatron(\"probar\")   → posiciones " + trie.buscarPatron(texto, "probar"));
        System.out.println();

        // Demo con listado general (mismo archivo que Ej 7)
        System.out.println("Cargando listado general en TTrieHashMap...");
        TTrieHashMap trieLargo = new TTrieHashMap();
        List<String> palabrasArchivo = Soporte.cargarArchivo("ut03/listado-general-desordenado.txt");
        for (String p : palabrasArchivo) trieLargo.insertar(p);
        System.out.println("predecir(\"cas\") → " + trieLargo.predecir("cas").size() + " palabras");
    }
}
