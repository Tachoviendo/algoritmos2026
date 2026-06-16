package ucu.edu.aed.tda.generic_trie;

import ucu.edu.aed.ejer16.ArbolGenerico;

public class ArbolGenericoTest extends AbstractTArbolGenericoTest {
    @Override
    protected <T extends Comparable<T>> TArbolGenerico<T> crearArbol(T raiz) {
        return new ArbolGenerico<>(raiz);
    }
}
