package com.ucu.algoritmos;

public class Factura implements Imprimible {
    private int numero;
    private double monto;

    public Factura(int numero, double monto) {
        this.numero = numero;
        this.monto = monto;
    }

    @Override
    public void imprimir() {
        System.out.println("=================================");
        System.out.println("         FACTURA");
        System.out.println("=================================");
        System.out.println("Número: " + numero);
        System.out.println("Monto: $" + monto);
        System.out.println("=================================");
    }

    public int getNumero() {
        return numero;
    }

    public double getMonto() {
        return monto;
    }
}
