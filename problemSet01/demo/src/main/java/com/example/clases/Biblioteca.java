package com.example.clases;
import java.util.ArrayList;
import java.util.Comparator;

public class Biblioteca {
    private ArrayList<Libro> catalogo;

    public Biblioteca() {
        catalogo = new ArrayList<>();
    }

    public Libro buscarLibro(String codigo) {
        for (Libro libro : catalogo) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }
        return null;
    }

    public double incorporarLibro(String codigo, String titulo, double precio, int cantidad) {
        Libro libro = buscarLibro(codigo);

        if (libro == null) {
            libro = new Libro(codigo, titulo, precio, cantidad);
            catalogo.add(libro);
        } else {
            libro.agregarEjemplares(cantidad);
        }

        return precio * cantidad;
    }

    public int registrarMovimiento(String codigo, String tipo, int cantidad) {
        Libro libro = buscarLibro(codigo);
        if (libro == null) return 0;

        if (tipo.equals("PRESTAMO")) {
            return libro.prestarEjemplares(cantidad);
        } else if (tipo.equals("DEVOLUCION")) {
            libro.devolverEjemplares(cantidad);
            return -cantidad;
        }
        return 0;
    }

    public void listarLibros() {
        catalogo.sort(Comparator.comparing(Libro::getTitulo));

        for (Libro libro : catalogo) {
            System.out.println(libro);
        }
    }
}
