package com.example.clases;

import java.util.List;
import java.util.Stack;

public class Expresion {
    private List<Character> caracteres;

    public Expresion(List<Character> caracteres) {
        this.caracteres = caracteres;
    }

    public boolean controlCorchetes(List<Character> listaDeEntrada) {
        Stack<Character> pila = new Stack<>();

        for (Character c : listaDeEntrada) {
            if (c == '{') {
                pila.push(c);
            } else if (c == '}') {
                if (pila.isEmpty()) {
                    return false;
                }
                pila.pop();
            }
        }

        return pila.isEmpty();
    }
}
