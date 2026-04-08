package ejercicios;

/*
Esta es la segunda implementación, hereda de ContadorPalabras.
La diferencia es que además de contar, imprime cada palabra que encuentra.
Sirve para demostrar herencia y sobreescritura: misma interfaz, distinto comportamiento.

Diferencia entre sobrecarga y sobreescritura:
- Sobrecarga (overload): mismo nombre de método, distinta firma (parámetros diferentes). Pasa en la misma clase.
  Ejemplo: contarPalabras(String texto) y contarPalabras(String[] lineas) en ContadorPalabras.
- Sobreescritura (override): misma firma, distinta clase. La subclase reemplaza el comportamiento del padre.
  Ejemplo: este contarPalabras(String texto) reemplaza al de ContadorPalabras.
*/
public class ContadorPalabrasVerboso extends ContadorPalabras {

    public ContadorPalabrasVerboso() {
        super("ContadorPalabrasVerboso");
    }

    // Sobreescritura: hace lo mismo que el padre pero además imprime cada palabra
    @Override
    public int contarPalabras(String texto) {
        if (texto == null || texto.trim().isEmpty()) return 0;

        String[] palabras = texto.trim().split("\\s+");
        System.out.println("Palabras encontradas:");
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("  [" + i + "] " + palabras[i]);
        }
        return palabras.length;
    }
}
