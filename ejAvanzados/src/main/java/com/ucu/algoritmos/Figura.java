package com.ucu.algoritmos;

public abstract class Figura {

    public abstract double area();

    public void describir() {
        System.out.println("Soy una figura con area: " + area());
    }
}
