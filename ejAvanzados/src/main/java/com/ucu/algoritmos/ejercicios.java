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

    // Ejercicio 13: Herencia múltiple vía interfaces
    public void ej13() {
        System.out.println("\n=== Ejercicio 13: Herencia múltiple vía interfaces ===\n");

        Pato pato = new Pato();
        Avion avion = new Avion();
        Pez pez = new Pez();

        System.out.println("El Pato (implementa Volador Y Nadador):");
        pato.volar();
        pato.aterrizar();
        pato.nadar();
        pato.salirDelAgua();

        System.out.println("\n" + "-".repeat(50));

        System.out.println("\nEl Avión (solo Volador):");
        avion.volar();
        avion.aterrizar();

        System.out.println("\n" + "-".repeat(50));

        System.out.println("\nEl Pez (solo Nadador):");
        pez.nadar();
        pez.salirDelAgua();

        System.out.println("\n" + "-".repeat(50));

        // Demostrar polimorfismo con tipos de interface
        System.out.println("\nPolimorfismo con interfaces:");

        Volador v = new Pato();
        System.out.println("Variable tipo Volador con Pato:");
        v.volar();

        Nadador n = new Pato();
        System.out.println("\nVariable tipo Nadador con Pato:");
        n.nadar();

        System.out.println("\nEl Pato puede verse como Volador O como Nadador,");
        System.out.println("¡pero sigue siendo el mismo objeto con ambas capacidades!");
    }

    // Ejercicio 14: Clase inmutable - Punto
    public void ej14() {
        System.out.println("\n=== Ejercicio 14: Clase inmutable - Punto ===\n");

        Punto p1 = new Punto(3, 4);
        System.out.println("Punto original: " + p1);

        // Trasladar el punto (retorna un NUEVO punto)
        Punto p2 = p1.trasladar(2, 1);
        System.out.println("Después de trasladar(2, 1): " + p2);
        System.out.println("Punto original sin cambios: " + p1);

        System.out.println("\n" + "-".repeat(50));

        // Rotar el punto (retorna un NUEVO punto)
        Punto p3 = new Punto(1, 0);
        System.out.println("\nPunto inicial: " + p3);
        Punto p4 = p3.rotar(90);
        System.out.println("Después de rotar 90°: " + p4);
        System.out.println("Punto original sin cambios: " + p3);

        System.out.println("\n" + "-".repeat(50));

        // Demostrar inmutabilidad
        System.out.println("\nDemostración de inmutabilidad:");
        Punto origen = new Punto(0, 0);
        System.out.println("Origen: " + origen);

        Punto trasladado1 = origen.trasladar(5, 5);
        Punto trasladado2 = origen.trasladar(3, 3);
        Punto trasladado3 = origen.trasladar(-2, -2);

        System.out.println("Traslación 1: " + trasladado1);
        System.out.println("Traslación 2: " + trasladado2);
        System.out.println("Traslación 3: " + trasladado3);
        System.out.println("Origen NUNCA cambió: " + origen);

        System.out.println("\n¡La inmutabilidad hace que el código sea más seguro!");
    }

    // Ejercicio 15: Excepciones personalizadas
    public void ej15() {
        System.out.println("\n=== Ejercicio 15: Excepciones personalizadas ===\n");

        CuentaBancaria cuenta = new CuentaBancaria("Juan Pérez", 1000.0);
        cuenta.mostrarSaldo();

        try {
            System.out.println("\nIntentando retirar $500...");
            cuenta.retirar(500);
        } catch (SaldoInsuficienteException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        System.out.println("\n" + "-".repeat(50));

        try {
            System.out.println("\nIntentando retirar $800 (debería fallar)...");
            cuenta.retirar(800);
        } catch (SaldoInsuficienteException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            System.out.println("Detalles:");
            System.out.println("  - Monto solicitado: $" + ex.getMontoSolicitado());
            System.out.println("  - Saldo disponible: $" + ex.getSaldoDisponible());
            System.out.println("  - Faltante: $" + ex.getFaltante());
        }

        System.out.println("\n" + "-".repeat(50));

        try {
            System.out.println("\nIntentando retirar -100 (monto negativo)...");
            cuenta.retirar(-100);
        } catch (IllegalArgumentException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        System.out.println("\n" + "-".repeat(50));
        cuenta.mostrarSaldo();
    }

    // Ejercicio 16: Patrón Singleton
    public void ej16() {
        System.out.println("\n=== Ejercicio 16: Patrón Singleton ===\n");

        // Obtener la instancia (primera vez, se crea)
        Configuracion config1 = Configuracion.getInstance();
        System.out.println("Primera instancia obtenida");

        // Configurar algunos valores
        config1.set("servidor", "localhost");
        config1.set("puerto", "8080");
        config1.set("usuario", "admin");

        System.out.println("\nConfiguraciones en config1:");
        config1.mostrarTodas();

        System.out.println("\n" + "-".repeat(50));

        // Obtener "otra" instancia (pero es la misma)
        Configuracion config2 = Configuracion.getInstance();
        System.out.println("\nSegunda instancia obtenida");

        System.out.println("\nConfiguraciones en config2:");
        config2.mostrarTodas();

        System.out.println("\n" + "-".repeat(50));

        // Modificar desde config2
        config2.set("base_datos", "mysql");
        config2.set("timeout", "30");

        System.out.println("\nDespués de agregar valores desde config2:");
        System.out.println("\nconfig1 tiene " + config1.cantidadPropiedades() + " propiedades:");
        config1.mostrarTodas();

        System.out.println("\nconfig2 tiene " + config2.cantidadPropiedades() + " propiedades:");
        config2.mostrarTodas();

        System.out.println("\n" + "-".repeat(50));

        // Demostrar que son la misma instancia
        System.out.println("\n¿config1 y config2 son el MISMO objeto?");
        System.out.println("config1 == config2: " + (config1 == config2));
        System.out.println("\n¡Solo existe UNA instancia de Configuracion en toda la aplicación!");
    }

    // Ejercicio 17: Clase genérica Pila<T>
    public void ej17() {
        System.out.println("\n=== Ejercicio 17: Clase genérica Pila<T> ===\n");

        // Pila de Integer
        Pila<Integer> pilaEnteros = new Pila<>();
        System.out.println("Pila de Integer:");
        pilaEnteros.push(10);
        pilaEnteros.push(20);
        pilaEnteros.push(30);
        System.out.println("Estado: " + pilaEnteros);
        System.out.println("Peek: " + pilaEnteros.peek());
        System.out.println("Pop: " + pilaEnteros.pop());
        System.out.println("Estado después de pop: " + pilaEnteros);

        System.out.println("\n" + "-".repeat(50));

        // Pila de String
        Pila<String> pilaStrings = new Pila<>();
        System.out.println("\nPila de String:");
        pilaStrings.push("Hola");
        pilaStrings.push("Mundo");
        pilaStrings.push("Java");
        System.out.println("Estado: " + pilaStrings);
        System.out.println("Size: " + pilaStrings.size());

        System.out.println("\nVaciando la pila:");
        while (!pilaStrings.isEmpty()) {
            System.out.println("  Pop: " + pilaStrings.pop());
        }
        System.out.println("¿Está vacía? " + pilaStrings.isEmpty());

        System.out.println("\n" + "-".repeat(50));

        // Demostrar excepción
        System.out.println("\nIntentando pop en pila vacía:");
        try {
            pilaStrings.pop();
        } catch (java.util.EmptyStackException ex) {
            System.out.println("ERROR: " + ex.getClass().getSimpleName());
        }
    }

    // Ejercicio 18: Iterator personalizado
    public void ej18() {
        System.out.println("\n=== Ejercicio 18: Iterator personalizado - Rango ===\n");

        System.out.println("Recorriendo rango de 1 a 10 con for-each:");
        for (int n : new Rango(1, 10)) {
            System.out.print(n + " ");
        }

        System.out.println("\n\n" + "-".repeat(50));

        System.out.println("\nRecorriendo rango de 5 a 15:");
        for (int n : new Rango(5, 15)) {
            System.out.print(n + " ");
        }

        System.out.println("\n\n" + "-".repeat(50));

        System.out.println("\nSumando números del 1 al 100:");
        int suma = 0;
        for (int n : new Rango(1, 100)) {
            suma += n;
        }
        System.out.println("Suma total: " + suma);

        System.out.println("\n" + "-".repeat(50));
        System.out.println("\n¡El for-each llama internamente hasNext() y next()!");
    }

    // Ejercicio 19: Patrón Observer
    public void ej19() {
        System.out.println("\n=== Ejercicio 19: Patrón Observer ===\n");

        SensorTemperatura sensor = new SensorTemperatura(30.0);

        // Crear observadores
        Alarma alarma = new Alarma();
        Logger logger = new Logger();

        // Registrar observadores
        System.out.println("Registrando observadores:");
        sensor.registrar(alarma);
        sensor.registrar(logger);

        System.out.println("\n" + "-".repeat(50));

        // Cambiar temperatura (sin superar umbral)
        System.out.println("\nCambiando temperatura a 25°C:");
        sensor.setTemperatura(25.0);

        System.out.println("\n" + "-".repeat(50));

        // Cambiar temperatura (superando umbral)
        System.out.println("\nCambiando temperatura a 35°C:");
        sensor.setTemperatura(35.0);

        System.out.println("\n" + "-".repeat(50));

        // Otro cambio superando umbral
        System.out.println("\nCambiando temperatura a 40°C:");
        sensor.setTemperatura(40.0);

        System.out.println("\n" + "-".repeat(50));
        System.out.println("\nEl patrón Observer desacopla el sensor de los observadores.");
        System.out.println("El sensor no sabe qué hacen los observadores, solo les notifica.");
    }

    // Ejercicio 20: Mini sistema integrador
    public void ej20() {
        System.out.println("\n=== Ejercicio 20: Mini Sistema de Tienda ===\n");

        // Crear productos
        ProductoTienda p1 = new ProductoTienda("Laptop", 1200.00, 5);
        ProductoTienda p2 = new ProductoTienda("Mouse", 25.00, 20);
        ProductoTienda p3 = new ProductoTienda("Teclado", 75.00, 15);
        ProductoTienda p4 = new ProductoTienda("Monitor", 350.00, 8);
        ProductoTienda p5 = new ProductoTienda("Auriculares", 50.00, 30);

        // Crear clientes
        Cliente cliente1 = new Cliente("Ana García");
        Cliente cliente2 = new Cliente("Carlos López");

        System.out.println("=== Cliente 1: " + cliente1.getNombre() + " ===");
        cliente1.getCarrito().agregar(p1);
        cliente1.getCarrito().agregar(p2);
        cliente1.getCarrito().agregar(p3);

        System.out.println("\n=== Cliente 2: " + cliente2.getNombre() + " ===");
        cliente2.getCarrito().agregar(p4);
        cliente2.getCarrito().agregar(p5);
        cliente2.getCarrito().agregar(p2);

        System.out.println("\n" + "=".repeat(50));

        // Procesar compras
        cliente1.procesarCompra();

        System.out.println("\n" + "=".repeat(50));

        cliente2.procesarCompraConDescuento(10);

        System.out.println("\n" + "=".repeat(50));

        // Probar eliminar producto
        System.out.println("\n=== Modificando carrito de Cliente 1 ===");
        cliente1.getCarrito().quitar(p2);
        cliente1.getCarrito().mostrarCarrito();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("\n¡Sistema integrador completo!");
        System.out.println("Conceptos aplicados:");
        System.out.println("  - Clases y objetos");
        System.out.println("  - Encapsulamiento");
        System.out.println("  - Composición (Cliente tiene Carrito)");
        System.out.println("  - Interfaces (Descuentable)");
        System.out.println("  - Polimorfismo");
    }
}
