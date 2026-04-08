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
