package general;

import ejercicios.TransformadorT9;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class TransformadorT9Test {

    private TransformadorT9 t9;

    // @BeforeEach se ejecuta antes de cada test, así cada uno arranca con una instancia limpia
    @BeforeEach
    void setUp() {
        t9 = new TransformadorT9();
    }

    // ===== TEST BÁSICO =====
    // Verificamos que la conversión de un texto conocido da el resultado esperado
    @Test
    @DisplayName("Conversión básica de texto a T9")
    void testConversionBasica() {
        assertEquals("4652 6863", t9.convertir("hola mundo"));
    }

    @Test
    @DisplayName("Texto vacío devuelve cadena vacía")
    void testTextoVacio() {
        assertEquals("", t9.convertir(""));
    }

    @Test
    @DisplayName("Espacios y caracteres no alfabéticos se mantienen")
    void testCaracteresEspeciales() {
        assertEquals("4652, 6863!", t9.convertir("hola, mundo!"));
    }

    // ===== TEST DE INVERSIÓN =====
    @Test
    @DisplayName("Conversión invertida: invierte y luego convierte")
    void testConversionInvertida() {
        // "hola" invertido es "aloh" -> 2564
        assertEquals("2564 6863", t9.convertirInvertido("hola mundo"));
    }

    // ===== TEST PARAMETRIZADO =====
    // En vez de escribir un test por cada caso, los pasamos como parámetros.
    // Útil para probar muchas combinaciones sin repetir código.
    @ParameterizedTest(name = "''{0}'' -> ''{1}''")
    @DisplayName("Conversión parametrizada de letras individuales")
    @CsvSource({
        "abc, 222",
        "def, 333",
        "ghi, 444",
        "jkl, 555",
        "mno, 666",
        "pqrs, 7777",
        "tuv, 888",
        "wxyz, 9999"
    })
    void testConversionParametrizada(String entrada, String esperado) {
        assertEquals(esperado, t9.convertir(entrada));
    }

    // ===== TEST DE EXCEPCIÓN =====
    // Verificamos que convertir(null) lanza IllegalArgumentException
    @Test
    @DisplayName("Lanza excepción si el texto es null")
    void testConversionNullLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> t9.convertir(null));
    }

    @Test
    @DisplayName("convertirInvertido lanza excepción si el texto es null")
    void testInvertidoNullLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> t9.convertirInvertido(null));
    }

    // ===== TEST CON TIMEOUT =====
    // Verificamos que la conversión de un texto largo termina en tiempo razonable
    @Test
    @DisplayName("Conversión de texto largo termina en menos de 1 segundo")
    void testConversionRapida() {
        String textoLargo = "abcdefghijklmnopqrstuvwxyz ".repeat(1000);
        assertTimeout(Duration.ofSeconds(1), () -> t9.convertir(textoLargo));
    }

    // ===== TEST DE ARCHIVO =====
    // Creamos un archivo temporal, lo convertimos y verificamos la salida
    @Test
    @DisplayName("Conversión de archivo genera salida correcta")
    void testConversionArchivo() throws IOException {
        Path entrada = Files.createTempFile("t9_test_entrada", ".txt");
        Path salida  = Files.createTempFile("t9_test_salida", ".txt");

        Files.writeString(entrada, "hola\nmundo\n");
        t9.convertirArchivo(entrada.toString(), salida.toString());

        String resultado = Files.readString(salida);
        assertTrue(resultado.contains("4652"));
        assertTrue(resultado.contains("6863"));

        // limpiamos los temporales
        Files.deleteIfExists(entrada);
        Files.deleteIfExists(salida);
    }
}
