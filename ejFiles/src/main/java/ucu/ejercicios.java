package ucu;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class ejercicios {
    //ejercicio1
    
    public static FileWriter crearArchivo(String nombre) {
        try {
            FileWriter fw = new FileWriter(nombre+".txt");
           

            System.out.println("Archivo creado Exitosamente!");

            return fw;
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
        

    }

    public static ArrayList<String> leerArchivo(String file) {
        ArrayList<String> lineas = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linea = br.readLine();
            while (linea != null){
                lineas.add(linea);
                linea = br.readLine();
            }
            
            return lineas;
        } catch (IOException e) {
            e.printStackTrace();
   
        }
        return lineas;

    }

    public static void ejercicio1(){
        BufferedWriter bw = new BufferedWriter(ejercicios.crearArchivo("saludo.txt"));
        try {
            bw.write("Hola");
            bw.newLine();
            bw.write("Bienvenidos a Java");
            bw.newLine();
            bw.write("Manejo de Archivos clásico");

   
        } catch (Exception e) {
            e.printStackTrace();
        }

            
        

    }

    public static void ejercicio2() {

        for (String linea : ejercicios.leerArchivo("saludo.txt")) {
            System.out.println(linea);
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
                e.printStackTrace();
            }
        }

        try {
            bw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }

    public static void ejercicio4() {
        System.out.println("La cantidad de lineas son: " + ejercicios.leerArchivo("frutas.txt").size());
    }
    
}
