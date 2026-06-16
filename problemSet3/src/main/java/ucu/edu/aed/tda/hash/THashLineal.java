package ucu.edu.aed.tda.hash;

import java.util.ArrayList;
import java.util.List;

/* Tabla hash con direccionamiento abierto y sondeo lineal.
   h(i) = (h(0) + i) mod M
   Se expande automáticamente cuando el factor de carga supera el 90%. */
public class THashLineal<K, V> extends THash<K, V> {

    private int count = 0;

    public THashLineal(int elementosEsperados) {
        super(elementosEsperados);
    }

    @Override
    protected int calcularCapacidadOptima(int elementosEsperados) {
        int candidato = Math.max(elementosEsperados, 2);
        while (!esPrimo(candidato)) {
            candidato++;
        }
        return candidato;
    }

    private boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    protected int functionHashing(K clave) {
        return Math.abs(clave.hashCode()) % hashTable.length;
    }

    @Override
    public boolean insertar(K clave, V valor, Report report) {
        if ((double) count / hashTable.length > 0.9) {
            redimensionar();
        }
        int pos = functionHashing(clave);
        int inicio = pos;
        int primerLibre = -1;
        int comparaciones = 0;
        do {
            comparaciones++;
            if (hashTable[pos] == null) {
                int destino = primerLibre != -1 ? primerLibre : pos;
                hashTable[destino] = new TNodoHash<>(clave, valor);
                count++;
                if (report != null) report.setCantidadComparaciones(comparaciones);
                return true;
            }
            if (hashTable[pos].isLoteLibre()) {
                if (primerLibre == -1) primerLibre = pos;
            } else if (hashTable[pos].getClave().equals(clave)) {
                if (report != null) report.setCantidadComparaciones(comparaciones);
                return false; // clave duplicada
            }
            pos = (pos + 1) % hashTable.length;
        } while (pos != inicio);

        /* tabla llena de loteLibre sin null: usar primer hueco de loteLibre */
        if (primerLibre != -1) {
            hashTable[primerLibre] = new TNodoHash<>(clave, valor);
            count++;
            if (report != null) report.setCantidadComparaciones(comparaciones);
            return true;
        }
        return false;
    }

    @Override
    public V buscar(K clave, Report report) {
        int pos = functionHashing(clave);
        int inicio = pos;
        int comparaciones = 0;
        do {
            comparaciones++;
            if (hashTable[pos] == null) {
                if (report != null) report.setCantidadComparaciones(comparaciones);
                return null;
            }
            if (!hashTable[pos].isLoteLibre() && hashTable[pos].getClave().equals(clave)) {
                if (report != null) report.setCantidadComparaciones(comparaciones);
                return hashTable[pos].getValor();
            }
            pos = (pos + 1) % hashTable.length;
        } while (pos != inicio);
        if (report != null) report.setCantidadComparaciones(comparaciones);
        return null;
    }

    @Override
    public boolean delete(K clave, Report report) {
        int pos = functionHashing(clave);
        int inicio = pos;
        int comparaciones = 0;
        do {
            comparaciones++;
            if (hashTable[pos] == null) {
                if (report != null) report.setCantidadComparaciones(comparaciones);
                return false;
            }
            if (!hashTable[pos].isLoteLibre() && hashTable[pos].getClave().equals(clave)) {
                hashTable[pos].setLoteLibre(true);
                count--;
                if (report != null) report.setCantidadComparaciones(comparaciones);
                return true;
            }
            pos = (pos + 1) % hashTable.length;
        } while (pos != inicio);
        if (report != null) report.setCantidadComparaciones(comparaciones);
        return false;
    }

    @Override
    public boolean esVacio() {
        return count == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void vaciar() {
        hashTable = new TNodoHash[hashTable.length];
        count = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected boolean redimensionar() {
        TNodoHash<K, V>[] vieja = hashTable;
        hashTable = new TNodoHash[calcularCapacidadOptima(vieja.length * 2)];
        count = 0;
        for (TNodoHash<K, V> nodo : vieja) {
            if (nodo != null && !nodo.isLoteLibre()) {
                insertar(nodo.getClave(), nodo.getValor());
            }
        }
        return true;
    }

    @Override
    public Iterable<Entry<K, V>> entries() {
        List<Entry<K, V>> lista = new ArrayList<>();
        for (TNodoHash<K, V> nodo : hashTable) {
            if (nodo != null && !nodo.isLoteLibre()) {
                lista.add(nodo.getEntry());
            }
        }
        return lista;
    }

    @Override
    public Iterable<K> keys() {
        List<K> lista = new ArrayList<>();
        for (TNodoHash<K, V> nodo : hashTable) {
            if (nodo != null && !nodo.isLoteLibre()) {
                lista.add(nodo.getClave());
            }
        }
        return lista;
    }

    @Override
    public Iterable<V> values() {
        List<V> lista = new ArrayList<>();
        for (TNodoHash<K, V> nodo : hashTable) {
            if (nodo != null && !nodo.isLoteLibre()) {
                lista.add(nodo.getValor());
            }
        }
        return lista;
    }
}
