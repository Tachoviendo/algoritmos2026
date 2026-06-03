package com.ucu;

import com.ucu.tree.ArbolGenerico;
import com.ucu.tree.NodoAG;

public class App {
    public static void main(String[] args) {
        NodoAG<String> a = new NodoAG<>("A");
        NodoAG<String> b = new NodoAG<>("B");
        NodoAG<String> c = new NodoAG<>("C");
        NodoAG<String> d = new NodoAG<>("D");
        NodoAG<String> e = new NodoAG<>("E");
        NodoAG<String> f = new NodoAG<>("F");
        NodoAG<String> g = new NodoAG<>("G");

        b.agregarHijo(e);
        d.agregarHijo(f);
        d.agregarHijo(g);
        a.agregarHijo(b);
        a.agregarHijo(c);
        a.agregarHijo(d);

        ArbolGenerico<String> arbol = new ArbolGenerico<>(a);

        System.out.println("Nodos:  " + arbol.contarNodos()); // 7
        System.out.println("Hojas:  " + arbol.contarHojas()); // 4
        System.out.println("Altura: " + arbol.altura());      // 2
    }
}
