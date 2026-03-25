package com.ucu.algoritmos;

import java.util.ArrayList;
import java.util.List;

public class SensorTemperatura {
    private List<Observador> observadores = new ArrayList<>();
    private double temperatura;
    private double umbral;

    public SensorTemperatura(double umbral) {
        this.umbral = umbral;
        this.temperatura = 20.0; // temperatura inicial
    }

    public void registrar(Observador o) {
        observadores.add(o);
        System.out.println("Observador registrado. Total: " + observadores.size());
    }

    public void setTemperatura(double nuevaTemperatura) {
        this.temperatura = nuevaTemperatura;
        System.out.println("Temperatura actualizada a: " + temperatura + "°C");

        if (temperatura > umbral) {
            notificar("ALERTA: Temperatura superó el umbral de " + umbral + "°C. Actual: " + temperatura + "°C");
        }
    }

    private void notificar(String evento) {
        for (Observador o : observadores) {
            o.actualizar(evento);
        }
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getUmbral() {
        return umbral;
    }
}
