package ucu;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;


public class ejercicios {
    //ejercicio1
    
    public static void crearArchivo() {
        try {
            FileWriter fw = new FileWriter("saludo.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Hola");
            bw.newLine();
            bw.write("Bienvenidos a Java");
            bw.newLine();
            bw.write("Manejo de archivos Básico");
            bw.close();

            System.out.println("Archivo creado Exitosamente!");

        } catch (IOException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }

    public static void leerArchivo(String file) {

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linea = br.readLine();
            while (linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: "+ e.getMessage());
        }
        
    }
    
}
