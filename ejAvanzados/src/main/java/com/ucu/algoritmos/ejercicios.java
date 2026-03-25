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

    // Ejercicio 5: Atributos y métodos estáticos
    public void ej5() {
        System.out.println("=== Ejercicio 5: Contador con estáticos ===\n");

        System.out.println("Total de contadores creados: " + Contador.getTotalCreados());

        Contador c1 = new Contador();
        System.out.println(c1);

        Contador c2 = new Contador();
        System.out.println(c2);

        Contador c3 = new Contador();
        System.out.println(c3);

        System.out.println("\nTotal de contadores creados: " + Contador.getTotalCreados());
        System.out.println("Número del primer contador: " + c1.getNumero());
        System.out.println("Número del segundo contador: " + c2.getNumero());
    }

    // Ejercicio 6: Herencia simple - Vehiculo y sus subclases
    public void ej6() {
        System.out.println("=== Ejercicio 6: Herencia - Vehículos ===\n");

        Auto auto = new Auto("Toyota", "Corolla", 180, 4);
        System.out.println("Descripción del Auto:");
        auto.describir();

        System.out.println("\n" + "-".repeat(40) + "\n");

        Moto moto = new Moto("Harley-Davidson", "Street 750", 160, false);
        System.out.println("Descripción de la Moto:");
        moto.describir();

        System.out.println("\n" + "-".repeat(40) + "\n");

        Moto motoConSidecar = new Moto("Ural", "Gear-Up", 105, true);
        System.out.println("Descripción de la Moto con sidecar:");
        motoConSidecar.describir();
    }

    // Ejercicio 7: Constructor con super()
    public void ej7() {
        System.out.println("=== Ejercicio 7: Cadena de constructores con super() ===\n");

        System.out.println("Creando un Auto...");
        Auto auto1 = new Auto("Ford", "Mustang", 250, 2);
        System.out.println("Auto creado exitosamente");
        auto1.describir();

        System.out.println("\n" + "-".repeat(40) + "\n");

        System.out.println("Creando una Moto...");
        Moto moto1 = new Moto("Yamaha", "YZF-R1", 299, false);
        System.out.println("Moto creada exitosamente");
        moto1.describir();

        System.out.println("\n" + "-".repeat(40) + "\n");

        System.out.println("Probando múltiples instancias:");
        Auto auto2 = new Auto("BMW", "Serie 3", 240, 4);
        Auto auto3 = new Auto("Volkswagen", "Golf", 200, 5);
        Moto moto2 = new Moto("Honda", "CBR1000RR", 280, false);

        System.out.println("\nTodos los vehículos fueron creados correctamente");
        System.out.println("usando super() para inicializar los atributos heredados.");
    }

    // Ejercicio 8: Clase abstracta - Figura
    public void ej8() {
        System.out.println("=== Ejercicio 8: Clase abstracta Figura ===\n");

        // Crear array de figuras (polimorfismo)
        Figura[] figuras = new Figura[4];

        figuras[0] = new Circulo(5);
        figuras[1] = new Circulo(3.5);
        figuras[2] = new Triangulo(10, 8);
        figuras[3] = new Triangulo(6, 4);

        // Calcular el área de cada figura
        System.out.println("Calculando áreas de todas las figuras:\n");
        for (int i = 0; i < figuras.length; i++) {
            System.out.println("Figura " + (i + 1) + ":");
            figuras[i].describir();
            System.out.println();
        }

        // Calcular área total
        double areaTotal = 0;
        for (Figura figura : figuras) {
            areaTotal += figura.area();
        }
        System.out.println("Área total de todas las figuras: " + areaTotal);
    }

    // Ejercicio 9: Interface - Imprimible
    public void ej9() {
        System.out.println("=== Ejercicio 9: Interface Imprimible ===\n");

        // Crear ArrayList de elementos Imprimibles
        java.util.ArrayList<Imprimible> documentos = new java.util.ArrayList<>();

        // Agregar facturas
        documentos.add(new Factura(1001, 2500.50));
        documentos.add(new Factura(1002, 1800.75));
        documentos.add(new Factura(1003, 3200.00));

        // Agregar reportes
        documentos.add(new Reporte("Reporte Mensual de Ventas", "2026-03-25"));
        documentos.add(new Reporte("Análisis de Inventario", "2026-03-20"));

        // Imprimir todos los documentos (polimorfismo con interface)
        System.out.println("Imprimiendo todos los documentos:\n");
        for (Imprimible doc : documentos) {
            doc.imprimir();
            System.out.println();
        }

        System.out.println("Total de documentos: " + documentos.size());
    }

    // Ejercicio 10: Polimorfismo en acción
    public void ej10() {
        System.out.println("=== Ejercicio 10: Polimorfismo - Animales ===\n");

        // Crear array de Animal con instancias de diferentes tipos
        Animal[] animales = { new Perro(), new Gato(), new Vaca() };

        System.out.println("Haciendo que cada animal haga su sonido:\n");
        for (int i = 0; i < animales.length; i++) {
            System.out.print("Animal " + (i + 1) + ": ");
            animales[i].hacerSonido(); // ¿Qué ejecuta?
        }

        System.out.println("\n" + "-".repeat(50));
        System.out.println("Reflexión:");
        System.out.println("Aunque la variable es de tipo Animal, Java ejecuta");
        System.out.println("el método de la clase REAL del objeto (despacho dinámico).");
        System.out.println("Esto se decide en tiempo de ejecución, no en compilación.");
        System.out.println("-".repeat(50));

        // Demostración adicional con más animales
        System.out.println("\nMás animales:");
        Animal perro2 = new Perro();
        Animal gato2 = new Gato();

        System.out.print("perro2.hacerSonido(): ");
        perro2.hacerSonido();

        System.out.print("gato2.hacerSonido(): ");
        gato2.hacerSonido();
    }

    // Ejercicio 11: Composición - Biblioteca
    public void ej11() {
        System.out.println("=== Ejercicio 11: Composición - Biblioteca ===\n");

        Biblioteca biblioteca = new Biblioteca("Biblioteca Central UCU");

        // Agregar 5 libros
        biblioteca.agregar(new Libro("Cien años de soledad", "Gabriel García Márquez", "978-0307474728"));
        biblioteca.agregar(new Libro("1984", "George Orwell", "978-0451524935"));
        biblioteca.agregar(new Libro("El principito", "Antoine de Saint-Exupéry", "978-0156012195"));
        biblioteca.agregar(new Libro("Don Quijote", "Miguel de Cervantes", "978-0060934347"));
        biblioteca.agregar(new Libro("Clean Code", "Robert C. Martin", "978-0132350884"));

        // Listar todos los libros
        biblioteca.listarTodos();

        // Buscar por ISBN
        System.out.println("\n" + "-".repeat(50));
        System.out.println("Búsqueda por ISBN:");
        String isbnBuscado = "978-0451524935";
        Libro encontrado = biblioteca.buscarPorISBN(isbnBuscado);
        if (encontrado != null) {
            System.out.println("Libro encontrado: " + encontrado);
        } else {
            System.out.println("No se encontró el libro con ISBN: " + isbnBuscado);
        }

        // Búsqueda que no existe
        String isbnNoExiste = "978-9999999999";
        Libro noEncontrado = biblioteca.buscarPorISBN(isbnNoExiste);
        if (noEncontrado == null) {
            System.out.println("No se encontró el libro con ISBN: " + isbnNoExiste);
        }
    }

    // Ejercicio 12: Interface Comparable - ordenar objetos
    public void ej12() {
        System.out.println("\n=== Ejercicio 12: Comparable - Ordenar Productos ===\n");

        java.util.ArrayList<Producto> productos = new java.util.ArrayList<>();

        productos.add(new Producto("Notebook", 1200.00));
        productos.add(new Producto("Mouse", 25.50));
        productos.add(new Producto("Teclado", 75.00));
        productos.add(new Producto("Monitor", 350.00));
        productos.add(new Producto("Auriculares", 50.00));

        System.out.println("Productos antes de ordenar:");
        for (Producto p : productos) {
            System.out.println("  " + p);
        }

        // Ordenar usando Collections.sort()
        java.util.Collections.sort(productos);

        System.out.println("\nProductos después de ordenar (de menor a mayor precio):");
        for (Producto p : productos) {
            System.out.println("  " + p);
        }

        // Mostrar el más barato y el más caro
        System.out.println("\nProducto más barato: " + productos.get(0));
        System.out.println("Producto más caro: " + productos.get(productos.size() - 1));
    }
}
