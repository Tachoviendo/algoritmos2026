package com.ucu.algoritmos;

public class Alarma implements Observador {

    @Override
    public void actualizar(String evento) {
        System.out.println("[ALARMA] 🚨 " + evento);
        System.out.println("[ALARMA] ¡Activando sistema de refrigeración!");
    }
}
