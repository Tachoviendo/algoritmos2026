package com.ucu.algoritmos;

public class Cliente {
    private String nombre;
    private Carrito carrito;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.carrito = new Carrito();
    }

    public String getNombre() {
        return nombre;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void procesarCompra() {
        System.out.println("\n=== Procesando compra de " + nombre + " ===");
        carrito.mostrarCarrito();
        System.out.println("\n¡Compra procesada exitosamente!");
    }

    public void procesarCompraConDescuento(double porcentaje) {
        System.out.println("\n=== Procesando compra de " + nombre + " ===");
        carrito.mostrarCarrito();
        double totalConDescuento = carrito.aplicarDescuento(porcentaje);
        System.out.println("Descuento aplicado: " + porcentaje + "%");
        System.out.println("Total con descuento: $" + totalConDescuento);
        System.out.println("\n¡Compra procesada exitosamente!");
    }
}
