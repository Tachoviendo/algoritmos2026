package general;
import java.util.Scanner;

import ejercicios.ArithmeticDemo;
import ejercicios.Contador;
import ejercicios.Marcapasos;
import ejercicios.Multsuma;
import ejercicios.PruebaAtributos;
import ejercicios.StringDemo;
import ejercicios.UtilMath;

public class App {
    public static void main(String[] args) {
        System.out.println("\n==== EJERCICIOS GRUPALES OBLIGATORIOS - ALGORITMOS 1S 2026 ====");
        Scanner sc = new Scanner(System.in);
        while (true) { 
            try {
                System.out.println("Ingrese un número para ejecutar un ejercicio (1 a 14) o ingrese 0 para salir: ");
                int opcion = sc.nextInt();
                sc.nextLine(); //Esto lo agrego si no se rompe todo el programa 
                switch (opcion) {
                    case 0:
                        sc.close();
                        return;
                    case 1:
                        ejercicio1();
                        break;
                    case 2:
                        ejercicio2(sc);
                        break;
                    case 3:
                        ejercicio3(sc);
                        break;
                    case 4:
                        ejercicio4(sc);
                        break;
                    case 5:
                        ejercicio5();
                        break;
                    case 6:
                        ejercicio6(sc);
                        break;
                    case 7:
                        ejercicio7();
                        break;
                    default:
                        System.out.println("Opción invalida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ingresó una opción invalida.");
            }
        }
    }

    public static void ejercicio1(){
        System.out.println("\n==== EJERCICIO 1 ====");
        PruebaAtributos pa = new PruebaAtributos();
        pa.imprimirValoresAtributos();
        pa.probarNombresVariables();
        pa.probarVariablesLocales();
        System.out.println("\n==== FIN EJERCICIO 1 ====");
    }

    public static void ejercicio2(Scanner sc){
        System.out.println("\n==== EJERCICIO 2 ====");
        ArithmeticDemo ad = new ArithmeticDemo();
        ad.ejercicio(sc);
        System.out.println("\n==== FIN EJERCICIO 2 ====");
    }

    public static void ejercicio3(Scanner sc){
        System.out.println("\n==== EJERCICIO 3 ====");
        Contador cont = new Contador();
        cont.menu(sc);
        System.out.println("\n==== FIN EJERCICIO 3 ====");
    }

    public static void ejercicio4(Scanner sc){
        System.out.println("\n==== EJERCICIO 4 ====");
        System.out.println("Digite un número int para realizarle factorial: ");
        UtilMath um = new UtilMath();
        System.out.println("El factorial del numero da como resultado: " + um.factorial(sc.nextInt()));
        System.out.println("Digte un numero long para saber si es primo y realizar la suma de pares o impares: ");
        um.sumaParesImpares(sc.nextLong());
        System.out.println("\n==== FIN EJERCICIO 4 ====");
    }

    public static void ejercicio5(){
        System.out.println("\n==== EJERCICIO 5 ====");
        Marcapasos mp1 = new Marcapasos(1, (short) 10);
        System.out.println(mp1.toString());
        System.out.println("\n==== FIN EJERCICIO 5 ====");
    }

    public static void ejercicio6(Scanner sc){
        System.out.println("\n==== EJERCICIO 6 ====");
        Multsuma ms = new Multsuma();
        int[] vector1 = ms.leerVector(sc);
        int[] vector2 = ms.leerVector(sc);
        int resultado = ms.multiplicar(vector1, vector2);
        System.out.println("El resultado es "+ resultado);
        System.out.println("\n==== FIN EJERCICIO 6 ====");
    }

    public static void ejercicio7(){
        System.out.println("\n==== EJERCICIO 7 ====");
        StringDemo sd = new StringDemo();
        sd.ejercicio7();
        System.out.println("\n==== FIN EJERCICIO 7 ====");
    }

    
}


