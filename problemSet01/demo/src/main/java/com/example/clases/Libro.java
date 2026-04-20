package com.example.clases;

public class Libro {
    private String codigo;
    private String titulo;
    private double precioReposicion;
    private int cantidadDisponible;

    public Libro(String codigo, String titulo, double precioReposicion, int cantidadDisponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.precioReposicion = precioReposicion;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioReposicion() {
        return precioReposicion;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void agregarEjemplares(int cantidad) {
        this.cantidadDisponible += cantidad;
    }

    public int prestarEjemplares(int cantidad) {
        int prestados = Math.min(cantidad, cantidadDisponible);
        cantidadDisponible -= prestados;
        return prestados;
    }

    public void devolverEjemplares(int cantidad) {
        this.cantidadDisponible += cantidad;
    }

    @Override
    public String toString() {
        return titulo + " (" + codigo + ") - Stock: " + cantidadDisponible;
    }
}
