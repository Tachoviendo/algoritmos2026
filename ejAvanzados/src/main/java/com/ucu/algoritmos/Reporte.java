package com.ucu.algoritmos;

public class Reporte implements Imprimible {
    private String titulo;
    private String fecha;

    public Reporte(String titulo, String fecha) {
        this.titulo = titulo;
        this.fecha = fecha;
    }

    @Override
    public void imprimir() {
        System.out.println("---------------------------------");
        System.out.println("         REPORTE");
        System.out.println("---------------------------------");
        System.out.println("Título: " + titulo);
        System.out.println("Fecha: " + fecha);
        System.out.println("---------------------------------");
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFecha() {
        return fecha;
    }
}
