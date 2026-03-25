package com.ucu.algoritmos;

public class Avion implements Volador {

    @Override
    public void volar() {
        System.out.println("El avión está volando a gran altitud");
    }

    @Override
    public void aterrizar() {
        System.out.println("El avión está aterrizando en la pista");
    }
}
