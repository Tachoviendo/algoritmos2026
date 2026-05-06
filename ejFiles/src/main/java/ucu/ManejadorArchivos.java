package ucu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManejadorArchivos {

    public void escribirArchivo(String nombreArchivo, String[] lineas) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo + ".txt"));
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
            bw.close();
            System.out.println("Archivo " + nombreArchivo + ".txt escrito exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerArchivo(String nombreArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
