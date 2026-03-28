package ejercicios;
/*
- Crear una clase llamada PruebaAtributos dentro de un paquete definido por el equipo.
- Agregar atributos de instancia de distintos tipos (int, boolean, double, char y String) y mostrar sus
valores por defecto
- Intentar declarar nombres válidos e inválidos para variables y registrar qué errores genera el
compilador.
- Repetir la experiencia con variables locales sin inicializar y explicar la diferencia con los atributos.
- Agregar comentarios de una línea y de varias líneas, y documentar en el README cómo compilar y
ejecutar el programa desde línea de comandos.
*/

public class PruebaAtributos {
    //Atributos
    private int entero;
    private boolean booleano;
    private double doble;
    private char caracter;
    private String cadena = new String();

    //Nota: Se omiten los getters y setters porque probablemente no se alineen con el objetivo del ejercicio.

    public void imprimirValoresAtributos(){
        System.out.println("\n==== VALORES POR DEFECTO DE VARIABLES ====");
        System.out.println("Valor int: " + this.entero+"\nValor boolean: "+ this.booleano+"\nValor double: "+this.doble+"\nValor char: "+this.caracter+"\nValor String: "+this.cadena);
    }

    public void probarNombresVariables() {
        System.out.println("\n==== NOMBRES VALIDOS ====");

        int numero;
        int numero2;
        int _valor;
        int $precio;

        numero = 10;
        numero2 = 20;
        _valor = 30;
        $precio = 40;

        System.out.println("numero = " + numero);
        System.out.println("numero2 = " + numero2);
        System.out.println("_valor = " + _valor);
        System.out.println("$precio = " + $precio);

        System.out.println("\n==== NOMBRES INVALIDOS (comentados porque no compilan) ====");

        // int 2numero;     //No puede empezar con número
        // int mi variable; //No se permiten espacios
        // int class;       //Palabra reservada
        // int int;         //Palabra reservada
        // int @dato;       //Carácter inválido

        System.out.println("Ver comentarios en el código para ejemplos de errores de compilación.");
    }

    public void probarVariablesLocales() {
        System.out.println("\n==== VARIABLES LOCALES ====");

        int numeroLocal;
        // System.out.println(numeroLocal); 
        // Si se ejecuta la instrucción comentada da error porque es una variable local no inicializada

        numeroLocal = 100; // ahora sí
        System.out.println("numeroLocal inicializada = " + numeroLocal);

        /*
        Entonces:
            Los atributos tienen valores por defecto automáticamente.
            Las variables locales NO tienen valores por defecto.
            Java obliga a inciializarlas antes de usarlas.
         */
    }

}
