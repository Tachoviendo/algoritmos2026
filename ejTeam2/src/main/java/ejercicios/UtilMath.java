package ejercicios;

/*
Decisiones de diseño:

1. Separación en métodos reutilizables:
Se dividió la lógica en varios métodos (factorial, isPrime, sumaPares, sumaImpares y sumaParesImpares) en lugar de concentrar todo en uno solo. 
Esto mejora la legibilidad del código, ya que cada método cumple una única responsabilidad clara. 
Además, permite reutilizar métodos como isPrime en otros contextos sin necesidad de reescribir lógica, y facilita el mantenimiento, 
ya que cualquier cambio o corrección se realiza en un único lugar.

2. Control de errores por límites del tipo int:
En el método factorial se agregó una validación para evitar overflow cuando el número es mayor o igual a 13. 
Dado que el tipo int tiene un límite y 13! lo supera, se decidió prevenir el error devolviendo 0 y mostrando un mensaje. 
Esto asegura que el programa no devuelva resultados incorrectos y hace explícito el problema al usuario.

3. Uso de while en lugar de for:
En los métodos sumaPares y sumaImpares se utilizó la estructura while en lugar de for para cumplir con la consigna del ejercicio, 
que exige el uso de while o do-while. Esta decisión no afecta la lógica, pero respeta los requisitos planteados.

4. Optimización en la verificación de número primo:
En el método isPrime se recorre hasta la raíz cuadrada del número en lugar de hasta el número completo. 
Esto reduce la cantidad de iteraciones necesarias, mejorando la eficiencia del algoritmo sin afectar el resultado.
*/

public class UtilMath {

    public int factorial(int num) {
        if (num >= 13){
            System.out.println("Error: número demasiado grande para int.");
            return 0;
        }
        if (num==0){
            return 1;
        }
        if (num==1){
            return 1;
        }
        if (num<0){
            System.out.println("Numero negativo: Devolviendo 0.");
            return 0;
        }
        int resultado = 1;
        for (int i=num; i>0; i--){
            resultado *= i;
        }
        return resultado;
    }

    public void sumaParesImpares(long n) {
        if (isPrime(n)) {
            System.out.println(n + " es primo.");
            System.out.println("Suma de pares: " + sumaPares(n));
        } else {
            System.out.println(n + " no es primo.");
            System.out.println("Suma de impares: " + sumaImpares(n));
        }
    }

    public boolean isPrime(long n) {
        if (n <= 1) return false;

        long i = 2;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public long sumaPares(long n) {
        long suma = 0;
        long i = 0;

        while (i <= n) {
            if (i % 2 == 0) {
                suma += i;
            }
            i++;
        }
        return suma;
    }

    public long sumaImpares(long n) {
        long suma = 0;
        long i = 0;

        while (i <= n) {
            if (i % 2 != 0) {
                suma += i;
            }
            i++;
        }
        return suma;
    }


}
