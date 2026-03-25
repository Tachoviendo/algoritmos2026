package com.ucu.algoritmos;
import java.util.Scanner;


public class ejercicios {

    Scanner e = new Scanner(System.in);

    //ej1
    public void ej1(){
        
        System.out.println("Hello World!");
    }
    //ej2
    public void ej2(){
        int edad = 20;
        boolean estaLloviendo = false;
        double e = 2.71;
        char inicial = 'I';

        System.out.println("Mi edad es: " + edad);
        System.out.println("Tachoviendo? "+ estaLloviendo);
        System.out.println("Creo que así empieza el número e: "+ e);
        System.out.println("Mi inicial es: "+ inicial);
    }

    //ej3
    public void ej3(){
        String nombre;
        int edad;
       
        System.out.print("Ingrese su nombre: ");
        nombre = e.nextLine();

        System.out.print("Ingrese su edad: ");
        edad = e.nextInt();

        System.out.println("Hola, " + nombre + " Tenés " + edad + " años.");


    }

    //ej4
    public void ej4() {
        System.out.print("Ingrese el primer número: ");
        int a = e.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int b = e.nextInt();

        System.out.println("\nResultados:");
        System.out.println("Suma: " + (a + b));
        System.out.println("Resta: " + (a - b));
        System.out.println("Multiplicación: " + (a * b));
        System.out.println("División entera: " + (a / b));
        System.out.println("Resto de la división: " + (a % b));
    }

    //ej5
    public void ej5() {
        System.out.print("Ingrese un número entero: ");
        int numero = e.nextInt();

        if (numero % 2 == 0) {
            System.out.println("El número " + numero + " es par");
        } else {
            System.out.println("El número " + numero + " es impar");
        }
    }

    //ej6
    public void ej6() {
        System.out.print("Ingrese un número del 1 al 7: ");
        int dia = e.nextInt();

        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Día inválido");
        }
    }

    //ej7
    public void ej7() {
        int i = 10;
        while (i >= 1) {
            System.out.println(i);
            i--;
        }
        System.out.println("¡Despegue!");
    }

    //ej8
    public void ej8() {
        System.out.print("Ingrese un número para ver su tabla de multiplicar: ");
        int n = e.nextInt();

        System.out.println("\nTabla del " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

    //ej9
    public void ej9() {
        int[] notas = {7, 9, 5, 8, 6};

        int suma = 0;
        int max = notas[0];
        int min = notas[0];

        for (int nota : notas) {
            suma += nota;
            if (nota > max) max = nota;
            if (nota < min) min = nota;
        }

        double promedio = (double) suma / notas.length;

        System.out.println("Promedio: " + promedio);
        System.out.println("Nota más alta: " + max);
        System.out.println("Nota más baja: " + min);
    }

    //ej10
    public void ej10() {
        System.out.print("Ingrese una palabra: ");
        e.nextLine(); // Limpiar buffer
        String palabra = e.nextLine();

        System.out.println("\nAnálisis de la palabra '" + palabra + "':");
        System.out.println("Longitud: " + palabra.length());
        System.out.println("¿Contiene la letra 'a'? " + palabra.contains("a"));
        System.out.println("En mayúsculas: " + palabra.toUpperCase());

        // Palabra al revés
        String alReves = "";
        for (int i = palabra.length() - 1; i >= 0; i--) {
            alReves += palabra.charAt(i);
        }
        System.out.println("Al revés: " + alReves);
    }
}
