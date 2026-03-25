package com.ucu.algoritmos;

public class Rectangulo {
    private double ancho;
    private double alto;

    // Constructor con dos parámetros (rectángulo)
    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    // Constructor con un parámetro (cuadrado)
    public Rectangulo(double lado) {
        this(lado, lado); // llama al constructor de dos parámetros
    }

    public double area() {
        return ancho * alto;
    }

    public double perimetro() {
        return 2 * (ancho + alto);
    }

    // Getters
    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    // Setters
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    @Override
    public String toString() {
        return "Rectangulo[ancho=" + ancho + ", alto=" + alto + "]";
    }
}
