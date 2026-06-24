package com.ucu;

import com.ucu.ejercicio01.D1ConsultasBasicas;
import com.ucu.ejercicio02.D2Dijkstra;
import com.ucu.ejercicio03.D3Floyd;
import com.ucu.ejercicio04.D4Warshall;
import com.ucu.ejercicio05.D5CiclosTopologico;
import com.ucu.ejercicio06.ND1Conexidad;
import com.ucu.ejercicio07.ND2Prim;
import com.ucu.ejercicio08.ND3Kruskal;
import com.ucu.ejercicio09.ND4BFS;
import com.ucu.ejercicio10.ND5Articulacion;

public class AppProblemSet {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("         D1 - BASICO");
        System.out.println("=================================");
        D1ConsultasBasicas.ejecutar();

        System.out.println("\n=================================");
        System.out.println("         D2 - DIJKSTRA");
        System.out.println("=================================");
        D2Dijkstra.ejecutar();

        System.out.println("\n=================================");
        System.out.println("         D3 - FLOYD");
        System.out.println("=================================");
        D3Floyd.ejecutar();

        System.out.println("\n=================================");
        System.out.println("         D4 - WARSHALL");
        System.out.println("=================================");
        D4Warshall.ejecutar();

        System.out.println("\n=================================");
        System.out.println("         D5 - CICLOS / TOPOLOGICO");
        System.out.println("=================================");
        D5CiclosTopologico.ejecutar();

        System.out.println("\nND1 - CONEXIDAD");
        ND1Conexidad.ejecutar();

        System.out.println("\nND2 - PRIM");
        ND2Prim.ejecutar();

        System.out.println("\nND3 - KRUSKAL");
        ND3Kruskal.ejecutar();

        System.out.println("\nND4 - BFS");
        ND4BFS.ejecutar();

        System.out.println("\nND5 - PUNTOS DE ARTICULACION");
        ND5Articulacion.ejecutar();

        System.out.println("\nFIN");
    }

}
