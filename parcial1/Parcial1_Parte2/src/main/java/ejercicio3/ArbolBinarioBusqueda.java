package ejercicio3;

public class ArbolBinarioBusqueda {

    private ElementoBST raiz;

    public void insertar(int dato) {
        if (raiz == null) raiz = new ElementoBST(dato);
        else raiz.insertar(dato);
    }

    // ====== A IMPLEMENTAR ======
    public int contarEnRango(int min, int max) {
        return contarEnRango(raiz, min, max);
    }


    // Para no tener que cambiar el main, hacemos negocios en el bajo mundo. 
    // Agrego un parametro para entrar al arbol a partir de uno de sus nodos.
    private int contarEnRango(ElementoBST nodo, int min, int max) {
        // Para conseguir podar los nodos que no me sirven voy a usar recursion!

        //Caso Base
        if (nodo == null){
            // no hay nada en ese rango
            return 0;
        }

        //Si el nodo actual que recibo es menor que el min. significa que a la izq no me sirve buscar. Entonces los aceptados por el rango estan a la derecha.
        if (nodo.dato < min){
            return contarEnRango(nodo.hijoDer, min, max);
        }

        //ahora el otro extremo, si es mayor que max significa que estoy bandiado y tengo que explorar a la izquierda
        if (nodo.dato > max){
            return contarEnRango(nodo.hijoIzq, min, max);
        }

        // y el ultimo caso, si el valor del nodo esta dentro del rango tengo que mirar a ambos lados.
        return 1 + contarEnRango(nodo.hijoIzq, min, max) + contarEnRango(nodo.hijoDer, min, max);
    }

}
