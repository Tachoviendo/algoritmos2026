package ucu.edu.aed.ejer15;

import java.util.Objects;

public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private int anio;

    public Libro(String isbn, String titulo, String autor, int anio) {
    this.isbn = isbn;
    this.titulo = titulo;
    this.autor = autor;
    this.anio = anio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Libro other = (Libro) obj;

        return Objects.equals(isbn, other.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
