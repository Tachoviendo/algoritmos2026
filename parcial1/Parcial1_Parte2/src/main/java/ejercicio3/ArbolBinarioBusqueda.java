package ejercicio3;

public class ArbolBinarioBusqueda {

    private ElementoBST raiz;

    public void insertar(int dato) {
        if (raiz == null) raiz = new ElementoBST(dato);
        else raiz.insertar(dato);
    }

    // ====== A IMPLEMENTAR ======
    public int contarEnRango(int min, int max) {
        // TODO
        return 0;
    }
}
