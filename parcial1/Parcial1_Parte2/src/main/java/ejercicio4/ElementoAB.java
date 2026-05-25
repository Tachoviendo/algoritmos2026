package ejercicio4;

public class ElementoAB {

    int dato;
    ElementoAB hijoIzq;
    ElementoAB hijoDer;

    public ElementoAB(int dato) {
        this.dato = dato;
    }

    public ElementoAB(int dato, ElementoAB izq, ElementoAB der) {
        this.dato = dato;
        this.hijoIzq = izq;
        this.hijoDer = der;
    }

    // ====== A IMPLEMENTAR ======
    public int altura() {
        // TODO
        return -1;
    }

    public boolean esAVL() {
        // TODO
        return false;
    }
}
