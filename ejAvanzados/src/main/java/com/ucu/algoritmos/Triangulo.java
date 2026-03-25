package com.ucu.algoritmos;

public class Triangulo extends Figura {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return (base * altura) / 2;
    }

    @Override
    public void describir() {
        System.out.println("Triángulo con base: " + base + " y altura: " + altura);
        super.describir();
    }
}
