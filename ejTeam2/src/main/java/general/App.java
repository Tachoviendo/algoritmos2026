package general;
import java.util.Scanner;

import ejercicios.ArithmeticDemo;
import ejercicios.Contador;
import ejercicios.Marcapasos;
import ejercicios.Multsuma;
import ejercicios.PruebaAtributos;
import ejercicios.ContadorPalabras;
import ejercicios.ContadorPalabrasVerboso;
import ejercicios.ProcesadorTexto;
import ejercicios.ResultadoAnalisis;
import ejercicios.StringBuilderDemo;
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
                    case 8:
                        ejercicio8();
                        break;
                    case 9:
                        ejercicio9();
                        break;
                    case 10:
                        ejercicio10();
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

    public static void ejercicio10(){
        System.out.println("\n==== EJERCICIO 10 ====");
        ContadorPalabras cp = new ContadorPalabras();

        // Leer líneas desde archivo
        String archivo = "recursos/texto_prueba.txt";
        String[] lineas = cp.obtenerLineas(archivo);
        System.out.println("Líneas leídas del archivo:");
        for (String l : lineas) System.out.println("  " + l);

        // Contar palabras del archivo
        System.out.println("Total de palabras en el archivo: " + cp.contarPalabrasArchivo(archivo));

        // Intersección con arreglos
        String[] arregloA = {"frío", "sol", "lluvia", "viento", "nublado"};
        String[] arregloB = {"sol", "frío", "calor", "nublado", "tormenta"};

        String[] comunesArreglo = cp.palabrasComunesArreglo(arregloA, arregloB);
        System.out.println("\nIntersección con arreglos:");
        for (String p : comunesArreglo) System.out.println("  " + p);

        // Intersección con colecciones
        String[] comunesColeccion = cp.palabrasComunesColeccion(arregloA, arregloB);
        System.out.println("Intersección con colecciones:");
        for (String p : comunesColeccion) System.out.println("  " + p);

        System.out.println("\n==== FIN EJERCICIO 10 ====");
    }

    public static void ejercicio9(){
        System.out.println("\n==== EJERCICIO 9 ====");

        String texto = "afuera está lloviendo y hace mucho frío hoy";
        String[] lineas = {
            "primera línea con varias palabras",
            "segunda línea",
            "tercera"
        };

        // Uso polimórfico: la variable es de tipo ProcesadorTexto pero el objeto es ContadorPalabras
        // Esto demuestra polimorfismo: mismo tipo de referencia, distinto objeto
        ProcesadorTexto contador = new ContadorPalabras();
        System.out.println("Contando con ContadorPalabras:");
        System.out.println("  Palabras en texto: " + contador.contarPalabras(texto));
        System.out.println("  Palabras en arreglo de líneas: " + contador.contarPalabras(lineas));

        // Mismo polimorfismo pero con la subclase verbosa, que sobreescribe el comportamiento
        System.out.println("\nContando con ContadorPalabrasVerboso:");
        ProcesadorTexto verboso = new ContadorPalabrasVerboso();
        verboso.contarPalabras(texto);

        // ResultadoAnalisis para obtener más info de una sola vez
        System.out.println("\nAnálisis completo:");
        ContadorPalabras cp = new ContadorPalabras("analizador-principal");
        ResultadoAnalisis resultado = cp.analizar("primera línea\nsegunda línea\ntercera línea");
        System.out.println(resultado.toString());

        System.out.println("\n==== FIN EJERCICIO 9 ====");
    }

    public static void ejercicio8(){
        System.out.println("\n==== EJERCICIO 8 ====");
        StringBuilderDemo sbd = new StringBuilderDemo();
        sbd.ejercicio8();
        System.out.println("\n==== FIN EJERCICIO 8 ====");
    }

}


