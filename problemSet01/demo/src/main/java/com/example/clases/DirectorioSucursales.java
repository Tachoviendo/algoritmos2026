package com.example.clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DirectorioSucursales {
    private Lista<Sucursal> sucursales;

    public DirectorioSucursales() {
        sucursales = new Lista<>();
    }

    public void cargarDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    agregar(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregar(String ciudad) {
        sucursales.insertar(new Sucursal(ciudad));
    }

    public Sucursal buscar(String ciudad) {
        Nodo<Sucursal> aux = sucursales.getPrimero();
        while (aux != null) {
            if (aux.dato.getCiudad().equalsIgnoreCase(ciudad)) {
                return aux.dato;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    public void quitar(String ciudad) {
        sucursales.eliminar(new Sucursal(ciudad));
    }

    public void listar(String separador) {
        Nodo<Sucursal> aux = sucursales.getPrimero();
        while (aux != null) {
            System.out.print(aux.dato.getCiudad() + separador);
            aux = aux.siguiente;
        }
        System.out.println();
    }

    public void listar() {
        Nodo<Sucursal> aux = sucursales.getPrimero();
        while (aux != null) {
            System.out.println(aux.dato.getCiudad());
            aux = aux.siguiente;
        }
    }

    public int cantidad() {
        int count = 0;
        Nodo<Sucursal> aux = sucursales.getPrimero();
        while (aux != null) {
            count++;
            aux = aux.siguiente;
        }
        return count;
    }

    public boolean estaVacio() {
        return sucursales.getPrimero() == null;
    }

    public Sucursal siguienteDe(String ciudad) {
        Nodo<Sucursal> aux = sucursales.getPrimero();
        while (aux != null) {
            if (aux.dato.getCiudad().equalsIgnoreCase(ciudad)) {
                return aux.siguiente != null ? aux.siguiente.dato : null;
            }
            aux = aux.siguiente;
        }
        return null;
    }
}
