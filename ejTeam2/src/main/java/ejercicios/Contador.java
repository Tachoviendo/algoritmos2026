package ejercicios;
import java.util.Scanner;

public class Contador {

    //Atributos
    public final int MAX_CONT = 15;
    public int incremento = 1;
    public int contador = 0;

    // Atributo de instancia
    public int contadorInstancia = 0;

    // Atributo static (compartido)
    public static int contadorStatic = 0;

    public void incrementoWhile(){
        System.out.println("\n---- Incremento con While ----");
        this.contador = 0;
        while (this.contador < this.MAX_CONT){
            this.contador+=this.incremento;
            System.out.println("Contador: "+this.contador);
        }
    }

    public void incrementoDoWhile(){
        System.out.println("\n---- Incremento con Do_While ----");
        this.contador=0;
        do{
            this.contador+=this.incremento;
            System.out.println("Contador: "+this.contador);
        } while (this.contador < this.MAX_CONT);
    }

    public void incrementoFor(){
        System.out.println("\n---- Incremento con For ----");
        for (this.contador=this.incremento; this.contador<=MAX_CONT; this.contador+= this.incremento){
            System.out.println("Contador: "+this.contador);
        }
    }

    public void menu(Scanner sc){
        boolean exit = false;
        do{
            System.out.println("\n Bienvenido al ejercicio 3. \n Seleccione una opción:");
            System.out.println("\n 1 - Incremento con While");
            System.out.println("\n 2 - Incremento con Do_While");
            System.out.println("\n 3 - Incremento con For");
            System.out.println("\n 0 - Salir");
            int opcion = sc.nextInt();
            switch (opcion){
                case 0:
                    exit = true;
                    break;
                case 1:
                    incrementoWhile();
                    break;
                case 2:
                    incrementoDoWhile();
                    break;
                case 3:
                    incrementoFor();
                    break;
                case 4:
                    demoStatic();
                    break;
                default:
                    System.out.println("Error: Seleccionaste una opción invalida.");
            }
        } while (!exit);
    }

    public void demoStatic(){
        System.out.println("\n---- Demo Static vs Instancia ----");

        Contador obj1 = new Contador();
        Contador obj2 = new Contador();

        obj1.contadorInstancia++;
        obj1.contadorInstancia++;

        obj2.contadorInstancia++;

        contadorStatic++;
        contadorStatic++;
        contadorStatic++;

        System.out.println("Obj1 instancia: " + obj1.contadorInstancia);
        System.out.println("Obj2 instancia: " + obj2.contadorInstancia);
        System.out.println("Static compartido: " + contadorStatic);
    }

    /*
    Explicación:

    - while: se utiliza cuando no se conoce la cantidad exacta de iteraciones y se desea evaluar la condición antes de ejecutar el bloque.
    - do-while: se usa cuando el bloque debe ejecutarse al menos una vez, ya que la condición se evalúa al final.
    - for: se emplea cuando se conoce la cantidad de repeticiones o se trabaja con contadores definidos.

    - while es útil en validaciones o cuando se espera una condición.
    - do-while es común en menús o entrada de datos obligatoria.
    - for es ideal para recorrer estructuras o secuencias numéricas.
    */
}
