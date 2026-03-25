package ucu;
import java.io.FileWriter;
import java.io.BufferedWriter;
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
    
}
