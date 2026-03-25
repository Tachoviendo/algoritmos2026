package com.ucu.algoritmos;

public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI * radio * radio;
    }

    @Override
    public void describir() {
        System.out.println("Círculo con radio: " + radio);
        super.describir();
    }
}
