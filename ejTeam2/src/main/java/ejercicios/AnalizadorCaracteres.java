package ejercicios;

/*
Acá usamos el enum TipoCaracter para clasificar cada carácter de un texto.

Sin enum, esto se haría con ints o Strings hardcodeados, y el código quedaría lleno de
comparaciones como if (tipo == 0) o if (tipo.equals("vocal")), lo cual es fácil de romper
y difícil de leer. Con el enum queda claro qué significa cada valor y el compilador te avisa
si usás un valor que no existe.
*/
public class AnalizadorCaracteres {

    // Clasifica un carácter y devuelve su TipoCaracter
    public static TipoCaracter clasificar(char c) {
        char lower = Character.toLowerCase(c);
        if ("aeiouáéíóúü".indexOf(lower) >= 0) return TipoCaracter.VOCAL;
        if (Character.isLetter(c))              return TipoCaracter.CONSONANTE;
        if (Character.isDigit(c))               return TipoCaracter.DIGITO;
        return TipoCaracter.OTRO;
    }

    public void analizar(String texto) {
        if (texto == null || texto.isEmpty()) {
            System.out.println("Texto vacío.");
            return;
        }

        int vocales = 0, consonantes = 0, digitos = 0, otros = 0;

        for (char c : texto.toCharArray()) {
            // Al usar el enum en el switch, si mañana agregamos un nuevo TipoCaracter
            // el compilador nos avisa que falta manejarlo. Con ints eso no pasa.
            switch (clasificar(c)) {
                case VOCAL:      vocales++;      break;
                case CONSONANTE: consonantes++;  break;
                case DIGITO:     digitos++;      break;
                case OTRO:       otros++;        break;
            }
        }

        System.out.println("Texto: \"" + texto + "\"");
        System.out.println("Vocales: "      + vocales);
        System.out.println("Consonantes: "  + consonantes);
        System.out.println("Dígitos: "      + digitos);
        System.out.println("Otros: "        + otros);
    }

    // Recorre todos los valores del enum con values(), útil para mostrarlos o iterar sobre ellos
    public void mostrarValoresEnum() {
        System.out.println("Valores del enum TipoCaracter:");
        for (TipoCaracter tipo : TipoCaracter.values()) {
            System.out.println("  " + tipo);
        }
    }
}
