package ucu;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;


public class ejercicios {
    //ejercicio1
    
    public static FileWriter crearArchivo(String nombre) {
        try {
            FileWriter fw = new FileWriter(nombre+".txt");
           

            System.out.println("Archivo creado Exitosamente!");

            return fw;
        } catch (IOException e){
            System.out.println("Error: "+ e.getMessage());
            
            return null;
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

    public static void ejercicio3() {
        String[] frutas = {"Manzana", "Banana", "Naranja", "Pera"};
        BufferedWriter bw = new BufferedWriter(ejercicios.crearArchivo("frutas"));

        for (String fruta : frutas) {

            try {
                bw.write(fruta);
                bw.newLine();
  
            } catch (Exception e) {
                   
                System.out.println("Error" + e.getMessage());
            }
        }

        try {
            bw.close();
            
        } catch (Exception e) {
            
                System.out.println("Error" + e.getMessage());
        }

        
    }
    
}
