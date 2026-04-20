package com.example.clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcesadorAdquisiciones {

    public static void procesar(String archivo, Biblioteca biblioteca) {
        double totalValor = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String codigo = datos[0].trim();
                String titulo = datos[1].trim();
                double precio = Double.parseDouble(datos[2].trim());
                int cantidad = Integer.parseInt(datos[3].trim());

                totalValor += biblioteca.incorporarLibro(codigo, titulo, precio, cantidad);
            }

            System.out.println("Valor total agregado al stock: $" + totalValor);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
