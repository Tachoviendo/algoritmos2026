package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.example.clases.Alumno;
import com.example.clases.Conjunto;

public class ConjuntoTest {

    private Alumno a1, a2, a3, a4, a5;
    private Conjunto<Alumno> aed1;
    private Conjunto<Alumno> pf;

    @Before
    public void setUp() {
        a1 = new Alumno("1001", "Ana", "Garcia");
        a2 = new Alumno("1002", "Bruno", "Lopez");
        a3 = new Alumno("1003", "Carla", "Perez");
        a4 = new Alumno("1004", "Diego", "Sosa");
        a5 = new Alumno("1005", "Elena", "Rios");

        aed1 = new Conjunto<>();
        aed1.insertar(a1);
        aed1.insertar(a2);
        aed1.insertar(a3);
        aed1.insertar(a4);

        pf = new Conjunto<>();
        pf.insertar(a3);
        pf.insertar(a4);
        pf.insertar(a5);
    }

    @Test
    public void insertar_noDuplica() {
        aed1.insertar(a1); // ya existe
        // sigue conteniendo a1, no duplicado
        assertTrue(aed1.contiene(a1));
    }

    @Test
    public void contiene_existente() {
        assertTrue(aed1.contiene(a3));
    }

    @Test
    public void contiene_noExistente() {
        assertFalse(pf.contiene(a1));
    }

    @Test
    public void union_contieneAmbos() {
        Conjunto<Alumno> u = aed1.union(pf);
        assertTrue(u.contiene(a1));
        assertTrue(u.contiene(a2));
        assertTrue(u.contiene(a3));
        assertTrue(u.contiene(a4));
        assertTrue(u.contiene(a5));
    }

    @Test
    public void union_sinDuplicados() {
        Conjunto<Alumno> u = aed1.union(pf);
        // a3 y a4 están en ambos — no deben aparecer dos veces
        // verificamos que al insertar de nuevo no cambia el conjunto
        int antes = contarElementos(u);
        u.insertar(a3);
        int despues = contarElementos(u);
        assertEquals(antes, despues);
    }

    @Test
    public void interseccion_soloComunes() {
        Conjunto<Alumno> inter = aed1.interseccion(pf);
        assertTrue(inter.contiene(a3));
        assertTrue(inter.contiene(a4));
        assertFalse(inter.contiene(a1));
        assertFalse(inter.contiene(a2));
        assertFalse(inter.contiene(a5));
    }

    @Test
    public void interseccion_conjuntosDisjuntos() {
        Conjunto<Alumno> c1 = new Conjunto<>();
        c1.insertar(a1);
        Conjunto<Alumno> c2 = new Conjunto<>();
        c2.insertar(a5);
        assertTrue(c1.interseccion(c2).estaVacio());
    }

    @Test
    public void union_conVacio() {
        Conjunto<Alumno> vacio = new Conjunto<>();
        Conjunto<Alumno> u = aed1.union(vacio);
        assertTrue(u.contiene(a1));
        assertTrue(u.contiene(a2));
    }

    @Test
    public void interseccion_conVacio() {
        Conjunto<Alumno> vacio = new Conjunto<>();
        assertTrue(aed1.interseccion(vacio).estaVacio());
    }

    private int contarElementos(Conjunto<Alumno> c) {
        int count = 0;
        com.example.clases.Nodo<Alumno> aux = c.getPrimero();
        while (aux != null) {
            count++;
            aux = aux.siguiente;
        }
        return count;
    }
}
