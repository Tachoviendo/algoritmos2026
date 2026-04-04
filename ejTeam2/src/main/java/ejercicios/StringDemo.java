package ejercicios;

public class StringDemo {

    public void ejercicio7() {

        System.out.println("===== PRUEBA DE PALÍNDROMOS =====");

        String frase1 = "Anita lava la tina";
        String frase2 = "Dot saw I was Tod";
        String frase3 = "¿Acaso hubo búhos acá?";

        probarPalindromo(frase1);
        probarPalindromo(frase2);
        probarPalindromo(frase3);

        System.out.println("\n===== MÉTODOS DE STRING =====");

        String texto = "  Hola Mundo Hola  ";

        System.out.println("Original: [" + texto + "]");

        System.out.println("trim(): [" + texto.trim() + "]");
        System.out.println("toLowerCase(): " + texto.toLowerCase());
        System.out.println("toUpperCase(): " + texto.toUpperCase());

        System.out.println("substring(2, 6): " + texto.substring(2, 6));
        System.out.println("subSequence(2, 6): " + texto.subSequence(2, 6));

        String[] partes = texto.trim().split(" ");
        System.out.println("split(): ");
        for (String p : partes) {
            System.out.println(" - " + p);
        }

        System.out.println("indexOf('Hola'): " + texto.indexOf("Hola"));
        System.out.println("lastIndexOf('Hola'): " + texto.lastIndexOf("Hola"));
        System.out.println("contains('Mundo'): " + texto.contains("Mundo"));

        System.out.println("replace('Hola', 'Chau'): " + texto.replace("Hola", "Chau"));
        System.out.println("replaceAll('o', '0'): " + texto.replaceAll("o", "0"));
        System.out.println("replaceFirst('Hola', 'Hey'): " + texto.replaceFirst("Hola", "Hey"));

        System.out.println("\n===== MICROCONSULTAS =====");

        String hannah = "Did Hannah see bees? Hannah did.";

        System.out.println("Frase: " + hannah);

        System.out.println("Longitud: " + hannah.length());
        System.out.println("Carácter en índice 12: " + hannah.charAt(12));
        System.out.println("Subcadena (0, 10): " + hannah.substring(0, 10));

    }

    public static void probarPalindromo(String frase) {

        String original = frase;

        // Normalizamos quitando espacios, signos y pasando a minúscula
        String limpio = frase
                .toLowerCase()
                .replaceAll("[^a-záéíóúüñ]", "");

        String invertido = new StringBuilder(limpio).reverse().toString();

        System.out.println("\nFrase: " + original);
        System.out.println("Normalizada: " + limpio);
        System.out.println("Invertida: " + invertido);

        if (limpio.equals(invertido)) {
            System.out.println("Resultado: Es palíndromo");
        } else {
            System.out.println("Resultado: NO es palíndromo");
        }
    }
}