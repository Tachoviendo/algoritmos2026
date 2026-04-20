package com.example.clases;

public class Sucursal {
    private String ciudad;

    public Sucursal(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Sucursal)) return false;
        Sucursal otra = (Sucursal) obj;
        return this.ciudad.equalsIgnoreCase(otra.ciudad);
    }

    @Override
    public String toString() {
        return ciudad;
    }
}
