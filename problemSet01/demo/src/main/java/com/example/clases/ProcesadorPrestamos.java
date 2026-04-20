package com.example.clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcesadorPrestamos {

    public static void procesar(String archivo, Biblioteca biblioteca) {
        int totalPrestados = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String codigo = datos[0].trim();
                String tipo = datos[1].trim();
                int cantidad = Integer.parseInt(datos[2].trim());

                int resultado = biblioteca.registrarMovimiento(codigo, tipo, cantidad);

                if (tipo.equals("PRESTAMO")) {
                    totalPrestados += resultado;
                } else if (tipo.equals("DEVOLUCION")) {
                    totalPrestados += resultado;
                }
            }

            System.out.println("Variación total de ejemplares prestados: " + totalPrestados);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
