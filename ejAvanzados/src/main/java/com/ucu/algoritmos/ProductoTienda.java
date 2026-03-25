package com.ucu.algoritmos;

public class ProductoTienda {
    private String nombre;
    private double precio;
    private int stock;

    public ProductoTienda(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void reducirStock(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
        } else {
            throw new IllegalArgumentException("Stock insuficiente");
        }
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio + " (Stock: " + stock + ")";
    }
}
