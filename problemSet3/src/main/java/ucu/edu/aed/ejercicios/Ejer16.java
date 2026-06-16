package ucu.edu.aed.ejercicios;

import ucu.edu.aed.ejer16.ArbolGenerico;
import ucu.edu.aed.ejer16.Persona;

public class Ejer16 {

    public static void ejecutar() {
        System.out.println("===== EJERCICIO 16 — Árbol Genealógico =====\n");

        /*
         * Árbol de 3 generaciones, 10 personas:
         *
         * Ana (1940)                ← generación 0
         * ├── Carlos (1965)         ← generación 1
         * │   ├── Diego  (1990)     ← generación 2
         * │   ├── Elena  (1993)
         * │   └── Fiona  (1995)
         * ├── Berta (1968)
         * │   ├── Hugo   (1992)
         * │   └── Ines   (1998)
         * └── Gonzalo (1972)
         *     ├── Julia  (2000)
         *     └── Kevin  (2003)
         */

        ArbolGenerico<Persona> arbol = new ArbolGenerico<>(new Persona("Ana", 1940));

        Persona carlos  = new Persona("Carlos",  1965);
        Persona berta   = new Persona("Berta",   1968);
        Persona gonzalo = new Persona("Gonzalo", 1972);
        Persona diego   = new Persona("Diego",   1990);
        Persona elena   = new Persona("Elena",   1993);
        Persona fiona   = new Persona("Fiona",   1995);
        Persona hugo    = new Persona("Hugo",    1992);
        Persona ines    = new Persona("Ines",    1998);
        Persona julia   = new Persona("Julia",   2000);
        Persona kevin   = new Persona("Kevin",   2003);

        arbol.agregarHijo(new Persona("Ana", 1940), carlos);
        arbol.agregarHijo(new Persona("Ana", 1940), berta);
        arbol.agregarHijo(new Persona("Ana", 1940), gonzalo);
        arbol.agregarHijo(carlos,  diego);
        arbol.agregarHijo(carlos,  elena);
        arbol.agregarHijo(carlos,  fiona);
        arbol.agregarHijo(berta,   hugo);
        arbol.agregarHijo(berta,   ines);
        arbol.agregarHijo(gonzalo, julia);
        arbol.agregarHijo(gonzalo, kevin);

        // 1. Listar todos los descendientes de Ana
        System.out.println("1. Descendientes de Ana:");
        System.out.println("   " + arbol.listarDescendientes(new Persona("Ana", 1940)));

        // 2. Altura del árbol
        System.out.println("2. Altura del árbol (desde Ana): " + arbol.altura(new Persona("Ana", 1940)));

        // 3. Contar personas
        System.out.println("3. Total de personas en el árbol: " + arbol.contarNodos());

        // 4. Personas por generación
        System.out.println("4. Generación 0 (raíz):   " + arbol.porGeneracion(0));
        System.out.println("   Generación 1 (hijos):  " + arbol.porGeneracion(1));
        System.out.println("   Generación 2 (nietos): " + arbol.porGeneracion(2));

        // 5. Ancestro común más cercano
        System.out.println("5. Ancestro común de Diego y Hugo: " +
                arbol.ancestroComun(new Persona("Diego", 1990), new Persona("Hugo", 1992)));
        System.out.println("   Ancestro común de Diego y Elena: " +
                arbol.ancestroComun(new Persona("Diego", 1990), new Persona("Elena", 1993)));

        // 6. ¿Es descendiente?
        System.out.println("6. ¿Diego es descendiente de Ana?:    " +
                arbol.esDescendiente(new Persona("Diego", 1990), new Persona("Ana", 1940)));
        System.out.println("   ¿Carlos es descendiente de Berta?: " +
                arbol.esDescendiente(new Persona("Carlos", 1965), new Persona("Berta", 1968)));
    }
}
