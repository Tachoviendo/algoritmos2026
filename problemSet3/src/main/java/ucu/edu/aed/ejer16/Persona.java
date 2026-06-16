package ucu.edu.aed.ejer16;

public class Persona implements Comparable<Persona> {

    private String nombre;
    private int anioNacimiento;

    public Persona(String nombre, int anioNacimiento) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombre() { return nombre; }
    public int getAnioNacimiento() { return anioNacimiento; }

    /* Dos personas son iguales si tienen el mismo nombre (para el criterio del árbol). */
    @Override
    public int compareTo(Persona other) {
        return this.nombre.compareTo(other.nombre);
    }

    @Override
    public String toString() {
        return nombre + " (" + anioNacimiento + ")";
    }
}
