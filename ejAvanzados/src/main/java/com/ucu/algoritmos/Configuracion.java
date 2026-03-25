package com.ucu.algoritmos;

import java.util.HashMap;

public class Configuracion {
    private static Configuracion instancia;
    private HashMap<String, String> propiedades;

    private Configuracion() {
        propiedades = new HashMap<>();
    }

    public static Configuracion getInstance() {
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }

    public void set(String clave, String valor) {
        propiedades.put(clave, valor);
    }

    public String get(String clave) {
        return propiedades.get(clave);
    }

    public void mostrarTodas() {
        System.out.println("Configuraciones actuales:");
        for (String clave : propiedades.keySet()) {
            System.out.println("  " + clave + " = " + propiedades.get(clave));
        }
    }

    public int cantidadPropiedades() {
        return propiedades.size();
    }
}
