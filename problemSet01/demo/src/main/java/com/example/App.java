package com.example;

import java.util.Scanner;

import com.example.clases.Biblioteca;
import com.example.clases.Core;
import com.example.clases.DirectorioSucursales;
import com.example.clases.Sucursal;
import com.example.clases.ProcesadorAdquisiciones;
import com.example.clases.ProcesadorPrestamos;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        do { 
            System.out.println("=================================================================================");
            System.out.println("Digitá un numero 17,18,23,19,26,27,24 para ejecutar el ejercicio correspondiente o 0 para salir.");
            System.out.println("=================================================================================");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 17:
                    ejercicio17();
                    break;
                case 18:
                    ejercicio18();
                    break;
                case 19:
                    ejercicio19();
                    break;
                case 23:
                    ejercicio23();
                    break;
                case 4:
                    //Ejercicio04.ejecutar(sc);
                    break;
                case 5:
                    //ejercicio
                case 6:
                    //ejercicio
                case 7:
                    //ejercicio
                case 8:
                    //ejercicio
                case 9:
                    //ejercicio
                case 10:
                    //ejercicio
                case 0:
                    sc.close();
                    System.out.println("==========");
                    System.out.println("  ADIÓS  ");
                    System.out.println("==========");
                    return;
            }
        } while (true);
    }

    public static void ejercicio17(){
        Core.headerMessage(17);
        Biblioteca biblioteca = new Biblioteca();

        ProcesadorAdquisiciones.procesar("demo/src/main/resources/adquisiciones.txt", biblioteca);
        ProcesadorPrestamos.procesar("demo/src/main/resources/prestamos.txt", biblioteca);

        System.out.println("\nCatálogo final:");
        biblioteca.listarLibros();
        Core.footerMessage(17);
    }

    public static void ejercicio18(){
        Core.headerMessage(18);
        System.out.println("Para este ejercicio se decidió simplemente que para eliminar un elemento de una listra enlazada basta con dejar dicho elemento sin referencias, esto es porque Java elimina un objeto de memoria si este queda sin referencias, a diferencia de otros lenguajes como C/C++ que se debe eliminar manualmente. Si se quisiera reutilizar el elemento basta con dejar una referencia a este antes de eliminarlo.");
        Core.footerMessage(18);
    }

    public static void ejercicio19(){
        Core.headerMessage(19);
        System.out.println("Revise el readme.md ");
        Core.footerMessage(19);
    }

    public static void ejercicio23() {
        Core.headerMessage(23);
        String base = "src/main/resources/";

        // Tarea 1: cargar suc1.txt
        DirectorioSucursales dir = new DirectorioSucursales();
        dir.cargarDesdeArchivo(base + "suc1.txt");
        System.out.println("Ciudades cargadas:");
        dir.listar();
        System.out.println("Total de elementos: " + dir.cantidad());

        // Tarea 2: eliminar Chicago, listar, ver qué sigue a Hong Kong
        dir.quitar("Chicago");
        System.out.println("\nTras eliminar Chicago:");
        dir.listar();
        Sucursal siguienteAHK = dir.siguienteDe("Hong Kong");
        System.out.println("\nCiudad siguiente a Hong Kong: " + (siguienteAHK != null ? siguienteAHK.getCiudad() : "ninguna"));

        // Tarea 3: cargar suc2.txt, eliminar Shenzen y Tokio
        DirectorioSucursales dir2 = new DirectorioSucursales();
        dir2.cargarDesdeArchivo(base + "suc2.txt");
        System.out.println("\nsuc2.txt cargado. Ciudades: " + dir2.cantidad());
        dir2.quitar("Shenzen");
        dir2.quitar("Tokio");
        System.out.println("Tras eliminar Shenzen y Tokio. Ciudades restantes: " + dir2.cantidad());
        System.out.println("¿Está vacío? " + dir2.estaVacio());

        // Tarea 4: cargar suc3.txt, invocar listar(";")
        DirectorioSucursales dir3 = new DirectorioSucursales();
        dir3.cargarDesdeArchivo(base + "suc3.txt");
        System.out.println("\nsuc3.txt - Imprimir(\";\"):");
        dir3.listar(";");

        Core.footerMessage(23);
    }
}
