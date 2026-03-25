package com.ucu.algoritmos;

public class Pato implements Volador, Nadador {

    @Override
    public void volar() {
        System.out.println("El pato está volando");
    }

    @Override
    public void aterrizar() {
        System.out.println("El pato está aterrizando");
    }

    @Override
    public void nadar() {
        System.out.println("El pato está nadando");
    }

    @Override
    public void salirDelAgua() {
        System.out.println("El pato está saliendo del agua");
    }
}
