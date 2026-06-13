package ucu.edu.aed.ejercicios;

public class Ejer13 {
    /*
    Si dos objetos son iguales según equals(), entonces deben producir exactamente el mismo hashCode().

    EJ: 
    Alumno a1 = new Alumno(1, "Juan Perez", "juan@mail.com");
    Alumno a2 = new Alumno(1, "Juan Perez", "juan@mail.com");
    a1.equals(a2); // true

    */
    public static void ejecutar(){
        System.out.println("Object calcula el hash usando la identidad del objeto, mientras que Integer y String lo calculan a partir de su contenido porque redefinen el concepto de igualdad. Esta diferencia es fundamental para el funcionamiento de estructuras como HashMap, que dependen de la relación entre equals() y hashCode() para ubicar y recuperar elementos eficientemente.");
        System.out.println();
        System.out.println("Nota: ver pdf en carpeta ejer13 para parte 1 y 2.\n");
    }
}
