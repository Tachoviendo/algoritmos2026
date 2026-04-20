package com.example;

import java.util.Scanner;

import com.example.clases.Biblioteca;
import com.example.clases.Core;
import com.example.clases.Alumno;
import com.example.clases.Cola;
import com.example.clases.Conjunto;
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
                case 24:
                    ejercicio24();
                    break;
                case 27:
                    ejercicio27();
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

    public static void ejercicio24() {
        Core.headerMessage(24);

        Conjunto<String> a = new Conjunto<>();
        a.insertar("Matemática");
        a.insertar("Física");
        a.insertar("Historia");

        Conjunto<String> b = new Conjunto<>();
        b.insertar("Física");
        b.insertar("Química");
        b.insertar("Historia");

        System.out.println("Conjunto A:");
        a.listar();

        System.out.println("\nConjunto B:");
        b.listar();

        System.out.println("\nUnión A ∪ B:");
        a.union(b).listar();

        System.out.println("\nIntersección A ∩ B:");
        a.interseccion(b).listar();

        // Parte 3: con alumnos
        System.out.println("\n--- Parte 3: Cursos AED1 y PF ---");

        Alumno a1 = new Alumno("1001", "Ana", "Garcia");
        Alumno a2 = new Alumno("1002", "Bruno", "Lopez");
        Alumno a3 = new Alumno("1003", "Carla", "Perez");
        Alumno a4 = new Alumno("1004", "Diego", "Sosa");
        Alumno a5 = new Alumno("1005", "Elena", "Rios");

        Conjunto<Alumno> aed1 = new Conjunto<>();
        aed1.insertar(a1);
        aed1.insertar(a2);
        aed1.insertar(a3);
        aed1.insertar(a4);

        Conjunto<Alumno> pf = new Conjunto<>();
        pf.insertar(a3);
        pf.insertar(a4);
        pf.insertar(a5);

        System.out.println("\nAED1:");
        aed1.listar();

        System.out.println("\nProgramación Funcional:");
        pf.listar();

        System.out.println("\n¿a3 está en AED1? " + aed1.contiene(a3));
        System.out.println("¿a3 está en PF? " + pf.contiene(a3));
        System.out.println("¿a1 está en PF? " + pf.contiene(a1));

        System.out.println("\nUnión (matriculados en cualquiera):");
        aed1.union(pf).listar();

        System.out.println("\nIntersección (matriculados en ambos):");
        aed1.interseccion(pf).listar();

        Core.footerMessage(24);
    }

    public static void ejercicio27() {
        Core.headerMessage(27);

        Cola<String> cola = new Cola<>(6);

        System.out.println("--- Encolando A, B, C, D ---");
        System.out.println("(frente y fin avanzan, el array se va llenando de izquierda a derecha)");
        cola.poneEnCola("A");
        cola.poneEnCola("B");
        cola.poneEnCola("C");
        cola.poneEnCola("D");

        System.out.println("\n--- Desencolando dos elementos ---");
        System.out.println("(sale siempre el más antiguo — FIFO)");
        System.out.println("Desencola: " + cola.quitaDeCola());
        System.out.println("Desencola: " + cola.quitaDeCola());

        System.out.println("\n--- Encolando E y F ---");
        System.out.println("(la circularidad permite reutilizar las posiciones 0 y 1 que quedaron libres)");
        cola.poneEnCola("E");
        cola.poneEnCola("F");

        System.out.println("\n--- Vaciando la cola ---");
        System.out.println("(el orden de salida demuestra que C entró antes que E y F — FIFO respetado)");
        while (!cola.estaVacia()) {
            System.out.println("  Desencola: " + cola.quitaDeCola());
        }

        System.out.println("\n--- Intento de desencolar con cola vacía ---");
        System.out.println("(el TDA detecta el error sin romper el programa)");
        cola.quitaDeCola();

        Core.footerMessage(27);
    }
}
