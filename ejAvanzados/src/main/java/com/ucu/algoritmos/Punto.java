package com.ucu.algoritmos;

public final class Punto {
    private final double x;
    private final double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Punto trasladar(double dx, double dy) {
        return new Punto(x + dx, y + dy);
    }

    public Punto rotar(double angulo) {
        // Rotación en sentido antihorario alrededor del origen
        double radianes = Math.toRadians(angulo);
        double coseno = Math.cos(radianes);
        double seno = Math.sin(radianes);

        double nuevoX = x * coseno - y * seno;
        double nuevoY = x * seno + y * coseno;

        return new Punto(nuevoX, nuevoY);
    }

    @Override
    public String toString() {
        return "Punto(" + String.format("%.2f", x) + ", " + String.format("%.2f", y) + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Punto otro = (Punto) obj;
        return Double.compare(otro.x, x) == 0 && Double.compare(otro.y, y) == 0;
    }

    @Override
    public int hashCode() {
        long xBits = Double.doubleToLongBits(x);
        long yBits = Double.doubleToLongBits(y);
        return (int) (xBits ^ yBits);
    }
}
