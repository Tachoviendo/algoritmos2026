package com.ucu.algoritmos;

public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
        }
    }

    public void retirar(double monto) {
        if (monto > saldo) {
            throw new SaldoInsuficienteException(monto, saldo);
        } else if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        } else {
            saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
        }
    }

    public void mostrarSaldo() {
        System.out.println("Titular: " + titular + " - Saldo actual: $" + saldo);
    }

    // Getters
    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
