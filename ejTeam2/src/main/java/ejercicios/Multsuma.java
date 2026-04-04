package ejercicios;

import java.util.Scanner;

public class Multsuma {
    public int calcular(int a, int b, int c){
        return a*b+c;
    }

    public double calcular(double a, double b, double c){
        return a*b+c;
    }

    /*
    Para validar se verifica que ambos arreglos tengan el mismo largo, pues la idea es que para cada vecotor se realice el producto escalar, es decir
    sean dos vectores a, b talque a = (x,y,z), b = (w,n,u) el producto escalar = x.w + y.n + z.u

    Por ende necesitamos el mismo largo.
    El calculo es simplemente ir recorriendo por cada posición de ambos arreglos y sumar la multiplicación de ambos escalares al resultado.
    */
    public int multiplicar(int[] v1, int[] v2){
        if (v1.length == v2.length){
            int resultado = 0;
            for (int i=0; i<v1.length; i++){
                resultado+= v1[i]*v2[i];
            }
            return resultado;
        }
        System.out.println("Error: vectores con largos diferentes.");
        return 0;
        //throw new IllegalArgumentException("Vectores de distinto tamaño");
    }

    public int[] leerVector(Scanner sc){
        System.out.println("Ingrese el tamaño del vector");
        int tamaño = sc.nextInt();

        int[] vector = new int[tamaño];

        for (int i = 0; i<tamaño; i++){
            System.out.println("Ingrese el elemento " + i +":");
            vector[i] = sc.nextInt();
        }

        return vector;
    }

}
