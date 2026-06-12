package ucu.edu.aed.ejercicios;
import ucu.edu.aed.clases.Soporte;
import ucu.edu.aed.ejer11.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/*
    Objetivo: Se desea implementar un programa que, en forma eficiente, permita obtener las frecuencias de
    ocurrencias de las palabras de un libro.

    Defensa: Se seleccionó HashMap, para cada palabra su clave es la palabra y el valor la cantidad de ocurrencias en el texto, además la estructura
    es extremadamente rapido para relación palabra-ocurrencias.
*/
public class Ejer11 {
    public static void ejecutar(){
        System.out.println("--- ANALISIS ---");
        System.out.println("Se cargó el archivo: libro-generico.txt\n");
        List<String> lineas = Soporte.cargarArchivo("ut03/libro-generico.txt");
        Map<String,Integer> ocurrencias = new HashMap<>();
        ocurrencias = ContadorPalabras.listarOcurrencias(lineas);
        ContadorPalabras.imprimirMayorOcurrencia(ocurrencias);

        System.out.println("--- GRAFICO ---");
        GraficadorOcurrencias.graficarTop10(ocurrencias);
    }
}
