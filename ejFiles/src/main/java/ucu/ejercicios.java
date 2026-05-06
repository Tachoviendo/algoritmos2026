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

            br.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return lineas;

    }

    public static void escribirAlFinal(String archivo, String linea){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
            bw.write(linea);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ejercicio1(){
        BufferedWriter bw = new BufferedWriter(ejercicios.crearArchivo("saludo"));
        try {
            bw.write("Hola");
            bw.newLine();
            bw.write("Bienvenidos a Java");
            bw.newLine();
            bw.write("Manejo de Archivos clásico");

            bw.close();

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

    public static void ejercicio5() {
        ejercicios.escribirAlFinal("frutas.txt", "kiwi");
        ejercicios.escribirAlFinal("frutas.txt", "Uva");
    }

    public static void ejercicio8() {
        for (String linea : ejercicios.leerArchivo("frutas.txt")) {
            if (linea.length() > 5) {
                System.out.println(linea);
            }
        }
    }

    public static void ejercicio9() {
        String[] lineas = {"Linea1", "Linea2", "Linea3"};
        ManejadorArchivos m = new ManejadorArchivos();
        m.escribirArchivo("prueba", lineas);
        m.leerArchivo("prueba.txt");
    }

    public static void ejercicio10() {
        ArrayList<String> lineas = ejercicios.leerArchivo("notas.txt");
        double suma = 0;
        for (String linea : lineas) {
            suma += Double.parseDouble(linea.trim());
        }
        int cantidad = lineas.size();
        System.out.println("Suma: " + suma);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Promedio: " + (suma / cantidad));
    }

    public static void ejercicio7() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("copia_frutas.txt"));
            for (String linea : ejercicios.leerArchivo("frutas.txt")) {
                bw.write(linea);
                bw.newLine();
            }
            bw.close();
            System.out.println("Archivo copiado exitosamente a copia_frutas.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ejercicio6() {
        boolean encontrado = false;
        for (String linea : ejercicios.leerArchivo("frutas.txt")) {
            if (linea.contains("Banana")) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("La palabra 'Banana' existe en el archivo.");
        } else {
            System.out.println("La palabra 'Banana' NO existe en el archivo.");
        }
    }

}
