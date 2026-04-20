package com.example.clases;

public class Alumno {
    private String cedula;
    private String nombre;
    private String apellido;

    public Alumno(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Alumno)) return false;
        return this.cedula.equals(((Alumno) obj).cedula);
    }

    @Override
    public String toString() {
        return cedula + " - " + nombre + " " + apellido;
    }
}
