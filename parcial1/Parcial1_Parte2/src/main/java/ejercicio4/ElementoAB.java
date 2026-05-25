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

    private int alturaDeHijo(ElementoAB hijo) {
      if (hijo == null) {
          return -1;
      }
      return hijo.altura();
    }

    // ====== A IMPLEMENTAR ======
    public int altura() {

        int hIzq = alturaDeHijo(hijoIzq);
        int hDer = alturaDeHijo(hijoDer);

      
        // veo cual es mayor y sumo 1 por ser la raiz
        if (hIzq > hDer) {
            return 1 + hIzq;
        } else {
            return 1 + hDer;
        }
    }

    public boolean esAVL() {
           

        // caso base
        if (hijoIzq == null && hijoDer == null) {
            return true; // nodo hoja = siempre va a ser avl
        }

      
        int hIzq = alturaDeHijo(hijoIzq);
        int hDer = alturaDeHijo(hijoDer);
        
        // calculo la diferencia de alturas pq si estan fuera del conjunto = [-1;0;1] no es avl
        int diferencia = hIzq - hDer;
        if (diferencia < 0) {
            //"valor absoluto" para simplificar al condicion del siguiente if.
            diferencia = diferencia * -1;
        }

        // si este nodo no esta balanceado, no es AVL
        if (diferencia > 1) {
            return false;
        }

        // ambos subarboles tambien tienen que ser AVL (caso recursivo)
        //
        // si el hijo existe y no es avl tengo que retornas false. tanto para izq como para der. 
        if (hijoIzq != null && !hijoIzq.esAVL()){
            return false;
        }
        if (hijoDer != null && !hijoDer.esAVL()){
            return false;
        }
        return true;
    }
}
