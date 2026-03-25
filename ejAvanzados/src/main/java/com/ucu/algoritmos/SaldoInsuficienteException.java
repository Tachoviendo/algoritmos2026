package com.ucu.algoritmos;

public class SaldoInsuficienteException extends RuntimeException {
    private double montoSolicitado;
    private double saldoDisponible;

    public SaldoInsuficienteException(double solicitado, double disponible) {
        super("Saldo insuficiente. Intentó retirar $" + solicitado +
              " pero solo tiene $" + disponible + " disponibles");
        this.montoSolicitado = solicitado;
        this.saldoDisponible = disponible;
    }

    public double getMontoSolicitado() {
        return montoSolicitado;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public double getFaltante() {
        return montoSolicitado - saldoDisponible;
    }
}
