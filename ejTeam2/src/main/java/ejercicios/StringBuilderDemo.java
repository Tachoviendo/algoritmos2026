package ejercicios;

/*
StringBuilder es básicamente un String pero que sí se puede modificar.
Cuando usás String normal y concatenás cosas, Java crea un objeto nuevo cada vez, lo cual es ineficiente.
StringBuilder modifica el mismo objeto, así que es mucho más rápido cuando tenés muchas operaciones sobre una cadena.

Cuándo conviene usarlo:
- Cuando construís una cadena dentro de un bucle.
- Cuando hacés muchas modificaciones seguidas.
- Cuando no necesitás sincronización entre hilos (para eso existe StringBuffer, que es más lento pero thread-safe).
*/

public class StringBuilderDemo {

    public void ejercicio8() {

        // ===== CAPACIDAD INICIAL =====
        // La capacidad de un StringBuilder creado desde un String es: longitud + 16
        // "afuera está lloviendo" tiene 21 caracteres, entonces capacidad = 21 + 16 = 37
        StringBuilder sb = new StringBuilder("afuera está lloviendo");
        System.out.println("===== CAPACIDAD INICIAL =====");
        System.out.println("Contenido: " + sb);
        System.out.println("Longitud: " + sb.length());
        System.out.println("Capacidad: " + sb.capacity()); // debería dar 37

        // ===== MÉTODOS PRINCIPALES =====
        System.out.println("\n===== MÉTODOS DE StringBuilder =====");

        // append: agrega al final, el más usado
        sb.append(" y hace frío.");
        System.out.println("append: " + sb);

        // insert: mete texto en una posición específica
        sb.insert(0, "Hoy ");
        System.out.println("insert(0): " + sb);

        // delete: borra un rango [inicio, fin), el fin no se incluye
        sb.delete(0, 4); // saca el "Hoy " que pusimos antes
        System.out.println("delete(0,4): " + sb);

        // deleteCharAt: borra un solo carácter por índice
        sb.deleteCharAt(0); // borra la 'a' de "afuera"
        System.out.println("deleteCharAt(0): " + sb);

        // reverse: da vuelta todo el contenido
        StringBuilder sbRev = new StringBuilder("afuera está lloviendo");
        sbRev.reverse();
        System.out.println("reverse('afuera está lloviendo'): " + sbRev);

        // setLength: trunca la cadena a ese largo, o la extiende con '\0'
        StringBuilder sbLen = new StringBuilder("afuera está lloviendo");
        sbLen.setLength(6);
        System.out.println("setLength(6) sobre 'afuera está lloviendo': " + sbLen); // queda "afuera"

        // ensureCapacity: le dice que se prepare para al menos N caracteres
        // útil si sabés de antemano cuánto va a crecer, para evitar que se redimensione solo
        StringBuilder sbCap = new StringBuilder();
        System.out.println("Capacidad por defecto (vacío): " + sbCap.capacity()); // 16
        sbCap.ensureCapacity(100);
        System.out.println("Capacidad después de ensureCapacity(100): " + sbCap.capacity());

        // ===== OPERACIONES ENCADENADAS =====
        // Como cada método devuelve el mismo StringBuilder, se pueden encadenar todos juntos
        System.out.println("\n===== OPERACIONES ENCADENADAS =====");
        StringBuilder sbChain = new StringBuilder("afuera");
        System.out.println("Inicial: " + sbChain);
        sbChain.append(" está lloviendo")   // "afuera está lloviendo"
               .insert(6, ",")              // "afuera, está lloviendo"
               .replace(8, 12, "no")        // "afuera, no lloviendo"
               .reverse();                  // "odneivollon ,arefua"
        System.out.println("Después de append + insert + replace + reverse: " + sbChain);

        // ===== == vs equals EN STRING =====
        System.out.println("\n===== == vs equals =====");

        // == compara si los dos apuntan al mismo objeto en memoria
        // equals compara si el contenido es igual, que es lo que casi siempre querés

        String a = new String("lluvia");
        String b = new String("lluvia");

        System.out.println("a == b: " + (a == b));         // false, son objetos distintos aunque digan lo mismo
        System.out.println("a.equals(b): " + a.equals(b)); // true, el contenido es igual

        // Con literales es distinto porque Java los mete en el string pool y reutiliza la referencia
        String c = "lluvia";
        String d = "lluvia";
        System.out.println("c == d (literales): " + (c == d));         // true, misma referencia del pool
        System.out.println("c.equals(d) (literales): " + c.equals(d)); // true también

        // intern() fuerza que un String creado con new use la referencia del pool
        String e = new String("lluvia").intern();
        System.out.println("new String(\"lluvia\").intern() == c: " + (e == c)); // true, ahora sí apuntan al mismo

        // ===== BUCLE INFINITO CORREGIDO =====
        System.out.println("\n===== BUCLE INFINITO CORREGIDO =====");

        /*
        El problema original era este:
            String s = "1";
            while (s != "1000") {   // acá está el error
                s = s + "1";
            }

        Cada vez que hacés s = s + "1", Java crea un objeto String nuevo en memoria.
        Ese objeto nunca va a ser la misma referencia que el literal "1000" del pool,
        así que s != "1000" siempre da true y el bucle nunca para.

        La solución es usar equals, que compara el contenido y no la referencia.
        */

        String s = "1";
        int iteraciones = 0;
        while (!s.equals("1000")) {
            s += "1";
            iteraciones++;
            if (iteraciones > 1005) { // por si algo sale mal
                System.out.println("Se alcanzó el límite de seguridad.");
                break;
            }
        }
        System.out.println("Bucle terminó correctamente. Longitud de s: " + s.length());
    }
}
