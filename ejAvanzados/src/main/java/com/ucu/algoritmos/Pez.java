package com.ucu.algoritmos;

public class Pez implements Nadador {

    @Override
    public void nadar() {
        System.out.println("El pez está nadando bajo el agua");
    }

    @Override
    public void salirDelAgua() {
        System.out.println("El pez saltó fuera del agua");
    }
}
