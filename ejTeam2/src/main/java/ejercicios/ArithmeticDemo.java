package ejercicios;
import java.util.Scanner;

public class ArithmeticDemo {
    public void ejercicio(Scanner sc) {
        System.out.println("\n=== REEMPLAZO DE ASIGNACIONES ===");
        System.out.println("result = 1 + 2 -> No se reemplaza pues es una asginación que no depende de result");
        int result = 1 + 2;
        System.out.println("result = result - 1 -> Se reemplaza por result-=1 ");
        result -= 1;
        System.out.println("result = result * 2  -> Se reemplaza por result*=2 ");
        result *= 2;
        System.out.println("result = result / 2 -> Se reemplaza por result/=2 ");
        result /= 2;
        System.out.println("result = result + 8 -> Se reemplaza por result+=8 ");
        result += 8;
        System.out.println("result = result % 7 -> Se reemplaza por result%=7 ");
        result %= 7;

        //Explicacion int a = 5; int i=3; a+=++i;
        System.out.println("\n=== EXPLICACIÓN: a += ++i ===");
        int a = 5;
        int i = 3;
        System.out.println("Valores iniciales: a = 5, i = 3");
        a += ++i;
        System.out.println("Paso 1: ++i incrementa i antes de usarlo -> i = 4");
        System.out.println("Paso 2: a += i equivale a a = a + i");
        System.out.println("Paso 3: a = 5 + 4 = 9");
        System.out.println("Resultado final: a = " + a + ", i = " + i);

        //Explicacion orden de tres expresiones
        System.out.println("\n=== ORDEN DE EVALUACIÓN ===");
        int x = 2 + 3 * 4;
        System.out.println("Ejemplo 1: 2 + 3 * 4");
        System.out.println("Primero multiplicación: 3 * 4 = 12");
        System.out.println("Luego suma: 2 + 12 = " + x);

        int y = (2 + 3) * 4;
        System.out.println("\nEjemplo 2: (2 + 3) * 4");
        System.out.println("Primero paréntesis: 2 + 3 = 5");
        System.out.println("Luego multiplicación: 5 * 4 = " + y);

        int z = 10 / 2 + 3;
        System.out.println("\nEjemplo 3: 10 / 2 + 3");
        System.out.println("Primero división: 10 / 2 = 5");
        System.out.println("Luego suma: 5 + 3 = " + z);

        //Agregar una variante que reciba dos valores por línea de comandos, los convierta a números y realice operaciones básicas.
        double num1;
        double num2;

        System.out.println("\nIngrese el primer número:");
        num1 = Double.parseDouble(sc.nextLine());
        System.out.println("Ingrese el segundo número:");
        num2 = Double.parseDouble(sc.nextLine());

        System.out.println("\n=== OPERACIONES BÁSICAS CON LOS DOS VALORES ===");
        System.out.println("Suma: " + (num1 + num2));
        System.out.println("Resta: " + (num1 - num2));
        System.out.println("Multiplicación: " + (num1 * num2));
        if (num2 != 0) {
            System.out.println("División: " + (num1 / num2));
            System.out.println("Módulo: " + (num1 % num2));
        } else {
            System.out.println("División: no se puede dividir por cero");
            System.out.println("Módulo: no se puede calcular módulo por cero");
        }
    }

}
