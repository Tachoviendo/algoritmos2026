package com.ucu.algoritmos;

import java.util.ArrayList;

public class Carrito implements Descuentable {
    private ArrayList<ProductoTienda> productos = new ArrayList<>();

    public void agregar(ProductoTienda producto) {
        productos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    public void quitar(ProductoTienda producto) {
        if (productos.remove(producto)) {
            System.out.println("Producto removido: " + producto.getNombre());
        } else {
            System.out.println("Producto no encontrado en el carrito");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (ProductoTienda p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    @Override
    public double aplicarDescuento(double porcentaje) {
        double total = calcularTotal();
        double descuento = total * (porcentaje / 100);
        return total - descuento;
    }

    public void mostrarCarrito() {
        System.out.println("\n--- Carrito de Compras ---");
        if (productos.isEmpty()) {
            System.out.println("(vacío)");
        } else {
            for (int i = 0; i < productos.size(); i++) {
                System.out.println((i + 1) + ". " + productos.get(i));
            }
        }
        System.out.println("Total: $" + calcularTotal());
    }

    public int cantidadProductos() {
        return productos.size();
    }
}
