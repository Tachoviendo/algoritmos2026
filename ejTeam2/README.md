# ejTeam2 — Ejercicios Obligatorios UT0

Algoritmos y Estructuras de Datos — Primer Semestre 2026  
Universidad Católica del Uruguay

## Integrantes

<!-- Completar con los integrantes del equipo -->
- ...
- ...
- ...

---

## Objetivo del repositorio

Resolver los ejercicios obligatorios de la UT0 de transición a Java, practicando tipos de datos, control de flujo, programación orientada a objetos, manejo de Strings y colecciones.

---

## Estructura del proyecto

```
ejTeam2/
  src/
    main/java/
      ejercicios/       ← clases de cada ejercicio
      general/          ← App.java (punto de entrada)
    test/java/
      general/          ← tests
  pom.xml
  README.md
```

---

## Cómo compilar y ejecutar

Desde la carpeta `ejTeam2/`:

```bash
# Compilar
mvn compile

# Ejecutar
mvn exec:java -Dexec.mainClass="general.App"

# Compilar y ejecutar en un solo comando
mvn compile exec:java -Dexec.mainClass="general.App"
```

Al ejecutar aparece un menú donde podés elegir el número de ejercicio (1 al 14).

---

## Ejercicios implementados

| # | Tema | Clase(s) |
|---|------|----------|
| 1 | Variables e inicialización | `PruebaAtributos` |
| 2 | Operadores y expresiones | `ArithmeticDemo` |
| 3 | Control de flujo (while, do-while, for) | `Contador` |
| 4 | Factorial y primalidad | `UtilMath` |
| 5 | Tipos de datos, objetos y memoria | `Marcapasos` |
| 6 | Sobrecarga y arreglos numéricos | `Multsuma` |
| 7 | Strings I: análisis y transformaciones | `StringDemo` |
| 8 | Strings II: StringBuilder y pool | `StringBuilderDemo` |
| 9 | ContadorPalabras orientado a objetos | `ProcesadorTexto`, `ContadorPalabras`, `ContadorPalabrasVerboso`, `ResultadoAnalisis` |
| 10 | Archivos, arreglos y colecciones | `ContadorPalabras` (extendido) |
| 11 | Entrada por archivo y por teclado | `Principal` |
| 12 | Depuración y corrección de errores | `Depuracion` |
| 13 | Tipos enumerados | `TipoCaracter`, `AnalizadorCaracteres` |
| 14 | Proyecto integrador T9 + JUnit 5 | `TransformadorT9`, `TransformadorT9Test` |

---

## Ejercicio 1 — JVM, JDK y JRE

**JDK (Java Development Kit)**  
Es el kit de desarrollo. Incluye todo lo necesario para escribir, compilar y ejecutar programas Java: el compilador (`javac`), la JVM, bibliotecas estándar y herramientas de diagnóstico. Es lo que instalás cuando querés desarrollar en Java.

**JRE (Java Runtime Environment)**  
Es el entorno de ejecución. Contiene la JVM y las bibliotecas necesarias para correr programas Java, pero no incluye el compilador. Es lo que necesita alguien que solo quiere ejecutar un programa, no desarrollarlo.

**JVM (Java Virtual Machine)**  
Es la máquina virtual que ejecuta el bytecode generado por el compilador. Gracias a ella, el mismo programa Java compilado puede correr en cualquier sistema operativo sin recompilarse ("write once, run anywhere").

### Tipos primitivos y de referencia

| Categoría | Tipo | Ejemplo | Descripción |
|-----------|------|---------|-------------|
| Primitivo | `int` | `int edad = 25;` | Entero de 32 bits |
| Primitivo | `double` | `double pi = 3.14;` | Real de 64 bits |
| Primitivo | `boolean` | `boolean activo = true;` | Verdadero o falso |
| Primitivo | `char` | `char letra = 'A';` | Un carácter Unicode |
| Primitivo | `byte` | `byte nivel = 80;` | Entero de 8 bits (−128 a 127) |
| Primitivo | `short` | `short codigo = 1000;` | Entero de 16 bits |
| Referencia | `String` | `String nombre = "Juan";` | Cadena de texto (objeto) |
| Referencia | `int[]` | `int[] nums = {1, 2, 3};` | Arreglo (objeto) |
| Referencia | `Marcapasos` | `new Marcapasos(1, (short)10)` | Cualquier clase definida |

---

## Ejercicio 2 — Conversiones usadas

| Conversión | Código | Descripción |
|------------|--------|-------------|
| `String` → `int` | `Integer.parseInt("42")` | Parsea un String a entero |
| `String` → `double` | `Double.parseDouble("3.14")` | Parsea un String a real |
| `int` → `String` | `String.valueOf(42)` | Convierte un entero a String |
| `int` → `double` | `(double) entero` | Widening cast, automático |
| `double` → `int` | `(int) real` | Narrowing cast, pierde decimales |

---

## Ejercicio 5 — Cálculo de memoria de Marcapasos

Considerando solo las variables de instancia declaradas:

| Atributo | Tipo | Tamaño |
|----------|------|--------|
| `idDispositivo` | `int` | 4 bytes |
| `codigoFabricante` | `short` | 2 bytes |
| `latidosPorMinuto` | `byte` | 1 byte |
| `nivelBateria` | `byte` | 1 byte |
| **Total por instancia** | | **8 bytes** |

Si todos los atributos fueran `int`, ocuparían 16 bytes. Al usar `short` y `byte` donde el rango lo permite, se reduce a la mitad.

**Simplificaciones:** no se considera el overhead del objeto Java (header de ~12-16 bytes), el padding de alineación de memoria, ni la referencia que apunta al objeto desde el heap.

---

## Ejercicio 10 — Arreglos vs Colecciones para intersección

| | Arreglos | Colecciones (`HashSet`) |
|---|----------|------------------------|
| Complejidad | O(n × m) — por cada elemento de A se recorre todo B | O(n + m) — se construye un set y se busca en O(1) |
| Código | Más verbose, bucles anidados | Más conciso, usa la API de Java |
| Duplicados | Hay que controlarlos manualmente | El `Set` los elimina automáticamente |
| Flexibilidad | Tamaño fijo | Tamaño dinámico |
| Cuándo usarlo | Listas chicas o cuando no podés importar colecciones | Siempre que el rendimiento importe |

---

## Ejercicio 14 — Cómo correr los tests

Desde la carpeta `ejTeam2/`:

```bash
mvn test
```

### Checklist final

- [x] `TransformadorT9` convierte texto a T9 correctamente
- [x] Maneja espacios y caracteres no alfabéticos sin romper
- [x] Variante invertida funciona (invierte primero, luego convierte)
- [x] Lee desde archivo y escribe en archivo de salida
- [x] Test básico pasa
- [x] Test parametrizado cubre todas las letras del teclado T9
- [x] Test de excepción verifica que `null` lanza `IllegalArgumentException`
- [x] Test de timeout verifica que textos largos se procesan en menos de 1 segundo
- [x] `mvn test` corre toda la suite sin errores

---

## Glosario (Ejercicio 9)

**Clase**  
Es la plantilla o molde a partir del cual se crean objetos. Define qué atributos y métodos va a tener cada objeto de ese tipo. Ejemplo: `Marcapasos` es una clase.

**Objeto**  
Es una instancia concreta de una clase. Cuando hacés `new Marcapasos(1, (short)10)` estás creando un objeto. Tiene sus propios valores para los atributos definidos en la clase.

**Atributo**  
Es una variable que pertenece a una clase u objeto. Representa el estado del objeto. Ejemplo: `latidosPorMinuto` en `Marcapasos`.

**Método**  
Es una función definida dentro de una clase. Define el comportamiento del objeto. Ejemplo: `contarPalabras(String texto)` en `ContadorPalabras`.

**Instancia**  
Es sinónimo de objeto. Decir "crear una instancia de ContadorPalabras" es lo mismo que decir "crear un objeto de tipo ContadorPalabras".

**Herencia**  
Mecanismo por el cual una clase puede reutilizar el código de otra. La subclase hereda atributos y métodos de la superclase y puede agregar o modificar comportamiento. Ejemplo: `ContadorPalabrasVerboso` hereda de `ContadorPalabras`.

**Polimorfismo**  
Permite usar un objeto de distintas formas según el tipo de referencia. Una variable de tipo `ProcesadorTexto` puede apuntar tanto a un `ContadorPalabras` como a un `ContadorPalabrasVerboso`, y cada uno se comporta distinto al llamar al mismo método.

**Encapsulamiento**  
Es ocultar los detalles internos de una clase y exponer solo lo necesario. Se logra declarando atributos como `private` y dando acceso a través de getters y setters. Evita que código externo modifique el estado del objeto de formas no controladas.

**Abstracción**  
Es la idea de definir un contrato sin especificar la implementación. Las interfaces y clases abstractas son herramientas de abstracción. `ProcesadorTexto` es una abstracción: dice qué se puede hacer (contar palabras) sin decir cómo.

---

## Decisiones de diseño (Ejercicio 9)

- Se usó una **interface** (`ProcesadorTexto`) en lugar de una clase abstracta porque no hay estado compartido entre las implementaciones, solo un contrato de métodos.
- Se creó `ResultadoAnalisis` para poder devolver más de un dato desde `analizar()`, evitando tener que llamar a varios métodos por separado.
- `ContadorPalabrasVerboso` extiende `ContadorPalabras` para demostrar sobreescritura: misma firma de método, distinto comportamiento.
- La sobrecarga de `contarPalabras` permite trabajar con un `String` suelto o con un arreglo de líneas sin cambiar el nombre del método.
