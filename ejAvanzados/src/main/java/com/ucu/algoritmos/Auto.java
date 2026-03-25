package com.ucu.algoritmos;

public class Auto extends Vehiculo {
    private int cantidadPuertas;

    public Auto(String marca, String modelo, int velocidadMaxima, int cantidadPuertas) {
        super(marca, modelo, velocidadMaxima);
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public void describir() {
        super.describir();
        System.out.println("Cantidad de puertas: " + cantidadPuertas);
    }
}
