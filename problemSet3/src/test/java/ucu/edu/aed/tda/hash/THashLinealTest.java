package ucu.edu.aed.tda.hash;

public class THashLinealTest extends AbstractTHashTest {
    @Override
    protected <K, V> THash<K, V> crearHash(int elementosEsperados) {
        return new THashLineal<>(elementosEsperados);
    }
}
