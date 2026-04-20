package com.example.clases;

public class Biblioteca {
    private Lista<Libro> catalogo;

    public Biblioteca() {
        catalogo = new Lista<>();
    }

    public Libro buscarLibro(String codigo) {
        Nodo<Libro> aux = catalogo.getPrimero();
        while (aux!=null){
            if (aux.dato.getCodigo().equals(codigo)){
                return aux.dato;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    public double incorporarLibro(String codigo, String titulo, double precio, int cantidad) {
        Libro libro = buscarLibro(codigo);

        if (libro == null) {
            libro = new Libro(codigo, titulo, precio, cantidad);
            catalogo.insertar(libro);
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
        Nodo<Libro> aux = catalogo.getPrimero();

        while (aux != null){
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }
}
