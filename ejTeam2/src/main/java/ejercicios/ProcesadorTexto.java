package ejercicios;

// Esta es la interfaz base. Define el contrato que cualquier procesador de texto tiene que cumplir.
// Si una clase dice que implementa ProcesadorTexto, está obligada a tener estos métodos.
public interface ProcesadorTexto {
    int contarPalabras(String texto);
    int contarPalabras(String[] lineas); // sobrecarga para trabajar con varias líneas a la vez
}
