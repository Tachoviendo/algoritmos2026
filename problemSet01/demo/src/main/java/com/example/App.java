package com.example;

import java.util.Scanner;

import com.example.clases.Biblioteca;
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
                case 2:
                    //Ejercicio02.ejecutar(sc);
                    break;
                case 3:
                    //Ejercicio03.ejecutar();
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
        Biblioteca biblioteca = new Biblioteca();

        ProcesadorAdquisiciones.procesar("demo/src/main/resources/adquisiciones.txt", biblioteca);
        ProcesadorPrestamos.procesar("demo/src/main/resources/prestamos.txt", biblioteca);

        System.out.println("\nCatálogo final:");
        biblioteca.listarLibros();
    }
}
