# Prueba Parcial - Parte 2: Implementación en Java

**Algoritmos y Estructuras de Datos** · UCU Campus Salto · 1er semestre 2026

---

## Cómo abrir el proyecto

1. Descomprimir el archivo `PruebaParcial_Parte2.zip` en una carpeta de trabajo.
2. Abrir con su editor de código y elegir **Archivo → Abrir carpeta...** seleccionando la carpeta `PruebaParcial_Parte2`.
3. Se debería detectar el `pom.xml` automáticamente y cargar el proyecto como proyecto Maven (esperar unos segundos a que termine la indexación).

> Requisitos: JDK 17 instalado y la extensión **Extension Pack for Java** de Microsoft.

---

## Estructura

```
PruebaParcial_Parte2/
├── pom.xml
├── README.md
└── src/main/java/
    ├── ejercicio1/
    │   ├── Nodo.java
    │   ├── ListaEnlazada.java       ← método a implementar
    │   └── Main.java                ← runner con casos de prueba
    ├── ejercicio2/
    │   ├── ColaEnlazada.java        ← método a implementar
    │   └── Main.java
    ├── ejercicio3/
    │   ├── ElementoBST.java
    │   ├── ArbolBinarioBusqueda.java ← método a implementar
    │   └── Main.java
    └── ejercicio4/
        ├── ElementoAB.java          ← métodos a implementar
        └── Main.java
```

Cada ejercicio tiene su propio `Main` que ejecuta los casos de prueba indicados en la consigna y muestra **PASS** o **FAIL** por cada caso.

---

## Cómo ejecutar cada ejercicio

### Desde VSCode

1. Abrir el archivo `Main.java` del ejercicio que se quiere ejecutar.
2. Hacer click en el botón **Run** que aparece arriba del método `main`, o usar el atajo `Ctrl + F5`.
3. La salida aparece en la pestaña **Terminal** o **Debug Console**.

### Desde la línea de comandos (alternativa)

```bash
mvn compile
mvn exec:java -Dexec.mainClass="ejercicio1.Main"
mvn exec:java -Dexec.mainClass="ejercicio2.Main"
mvn exec:java -Dexec.mainClass="ejercicio3.Main"
mvn exec:java -Dexec.mainClass="ejercicio4.Main"
```

---

## Qué hay que hacer

En cada uno de los cuatro ejercicios, completar **únicamente** el método o métodos marcados con el comentario `// ====== A IMPLEMENTAR ======`. **No modificar** el resto de las clases, no cambiar las firmas de los métodos, ni renombrar paquetes o archivos.

| # | Archivo | Método(s) a implementar |
|---|---|---|
| 1 | `ejercicio1/ListaEnlazada.java` | `eliminarDuplicadosConsecutivos()` |
| 2 | `ejercicio2/ColaEnlazada.java` | `intercalar(c1, c2)` |
| 3 | `ejercicio3/ArbolBinarioBusqueda.java` | `contarEnRango(min, max)` |
| 4 | `ejercicio4/ElementoAB.java` | `altura()` y `esAVL()` |

Los enunciados completos, las restricciones y los casos de prueba se encuentran en el documento compartido en el moodle.

---

## Cómo y qué entregar

1. Verificar que el proyecto compila sin errores: `mvn compile`.
2. Comprimir la **carpeta completa** del proyecto en un único archivo `.zip`. Es importante incluir el `pom.xml` y la carpeta `src/`.
3. Nombrar el archivo `Apellido_Nombre.zip` (por ejemplo, `Perez_Juan.zip`).
4. Subir el archivo a la plataforma del curso antes de que finalice el tiempo de la prueba.