package ejercicio3;

public class ElementoBST {

    int dato;
    ElementoBST hijoIzq;
    ElementoBST hijoDer;

    public ElementoBST(int dato) {
        this.dato = dato;
    }

    public void insertar(int nuevo) {
        if (nuevo > this.dato) {
            if (hijoDer == null) hijoDer = new ElementoBST(nuevo);
            else hijoDer.insertar(nuevo);
        } else if (nuevo < this.dato) {
            if (hijoIzq == null) hijoIzq = new ElementoBST(nuevo);
            else hijoIzq.insertar(nuevo);
        }
    }
}
