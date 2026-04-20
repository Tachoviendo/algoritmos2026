package com.example;

import java.util.Scanner;

import com.example.clases.Biblioteca;
import com.example.clases.Core;
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
                case 3:
                    ejercicio19();
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
}
