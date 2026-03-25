package com.ucu.algoritmos;
import java.util.Scanner;


public class ejercicios {

    Scanner e = new Scanner(System.in);

    // Ejercicio 1: Primera clase: Persona
    public void ej1(){
        System.out.println("=== Ejercicio 1: Clase Persona ===\n");

        // Crear dos personas
        Persona persona1 = new Persona("Nicolas", 20);
        Persona persona2 = new Persona("María", 25);

        // Usar método presentarse()
        persona1.presentarse();
        persona2.presentarse();

        // Usar getters
        System.out.println("\nUsando getters:");
        System.out.println("Nombre de persona1: " + persona1.getNombre());
        System.out.println("Edad de persona2: " + persona2.getEdad());

        // Usar setters
        persona1.setEdad(21);
        System.out.println("\nDespués de cambiar edad:");
        persona1.presentarse();
    }

    // Ejercicio 2: Clase con comportamiento: CuentaBancaria
    public void ej2(){
        System.out.println("=== Ejercicio 2: Cuenta Bancaria ===\n");

        CuentaBancaria cuenta = new CuentaBancaria("Nicolas", 1000.0);

        cuenta.mostrarSaldo();

        System.out.println("\nDepositando $500:");
        cuenta.depositar(500);

        System.out.println("\nRetirando $300:");
        cuenta.retirar(300);

        System.out.println("\nIntentando retirar $2000 (saldo insuficiente):");
        cuenta.retirar(2000);

        System.out.println("\nSaldo final:");
        cuenta.mostrarSaldo();
    }

    // Ejercicio 3: Sobrecarga de constructores
    public void ej3(){
        System.out.println("=== Ejercicio 3: Rectángulo con sobrecarga ===\n");

        // Usando constructor con dos parámetros (rectángulo)
        Rectangulo rectangulo = new Rectangulo(5, 3);
        System.out.println("Rectángulo de 5x3:");
        System.out.println("Área: " + rectangulo.area());
        System.out.println("Perímetro: " + rectangulo.perimetro());

        // Usando constructor con un parámetro (cuadrado)
        Rectangulo cuadrado = new Rectangulo(4);
        System.out.println("\nCuadrado de 4x4:");
        System.out.println("Área: " + cuadrado.area());
        System.out.println("Perímetro: " + cuadrado.perimetro());
        System.out.println("toString(): " + cuadrado.toString());
    }

    // Ejercicio 4: toString() y equals()
    public void ej4() {
        System.out.println("=== Ejercicio 4: toString() y equals() ===\n");

        Persona p1 = new Persona("Nicolas", 20);
        Persona p2 = new Persona("Nicolas", 20);
        Persona p3 = new Persona("María", 25);

        // Probar toString()
        System.out.println("toString() de p1: " + p1.toString());
        System.out.println("toString() de p3: " + p3.toString());

        // Probar equals()
        System.out.println("\n¿p1 es igual a p2? " + p1.equals(p2)); // true
        System.out.println("¿p1 es igual a p3? " + p1.equals(p3)); // false

        // Demostrar que son objetos diferentes en memoria
        System.out.println("\n¿p1 == p2 (misma referencia)? " + (p1 == p2)); // false
        System.out.println("¿p1.equals(p2) (mismo contenido)? " + p1.equals(p2)); // true
    }
}
