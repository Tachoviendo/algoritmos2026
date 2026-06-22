# UT04 — Grafos Dirigidos y No Dirigidos

## Algoritmos y Estructuras de Datos
**Universidad Católica del Uruguay – Campus Salto**

Problem Set compuesto por **10 ejercicios en Java**:

- 5 ejercicios sobre grafos dirigidos.
- 5 ejercicios sobre grafos no dirigidos.

---

# Estructura del Proyecto

```text
src/
│
├── clases/
│   ├── Grafo.java
│   ├── Vertice.java
│   └── Arista.java
│
├── ejercicio01/
├── ejercicio02/
├── ejercicio03/
├── ejercicio04/
├── ejercicio05/
├── ejercicio06/
├── ejercicio07/
├── ejercicio08/
├── ejercicio09/
├── ejercicio10/
│
└── AppProblemSet.java
```

### Organización

- `clases/` contiene las clases base del TDA Grafo provistas por la cátedra.
- Cada ejercicio se implementa en un paquete independiente.
- Cada paquete expone un método estático:

```java
public static void ejecutar()
```

- `AppProblemSet.java` contiene un menú para ejecutar cada ejercicio.

---

# Grafos Dirigidos

## Grafo de Trabajo

```text
V0 → V1(2), V3(1)
V1 → V3(3), V4(10)
V2 → V0(4), V5(5)
V3 → V2(2), V4(2), V5(8), V6(4)
V4 → V6(6)
V6 → V5(1)
V5 → (sin salidas)
```

---

# D1 — TDA y Consultas Básicas

**Nivel:** Básico ●○○

## Consigna

Implementar las siguientes operaciones:

- `gradoSalida(v)`
- `gradoEntrada(v)`
- `sonAdyacentes(v, w)`
- `listarAdyacentes(v)`

## Salida Esperada

```text
gradoSalida(V3) = 4
gradoEntrada(V3) = 2

gradoSalida(V5) = 0

sonAdyacentes(V0,V1) = true
sonAdyacentes(V1,V0) = false

Adyacentes de V3:
V2(2), V4(2), V5(8), V6(4)
```

---

# D2 — Dijkstra con Recuperación de Camino

**Nivel:** Intermedio ●●○

## Consigna

Implementar:

```java
caminosMinimos(origen)
camino(origen, destino)
```

Utilizar Dijkstra y reconstruir caminos mediante un vector de predecesores.

Origen de prueba:

```text
V2
```

## Salida Esperada

```text
Costos mínimos desde V2:

{
 V0=4,
 V1=6,
 V2=0,
 V3=5,
 V4=7,
 V5=5,
 V6=9
}

Costo a V6 = 9

Camino V2→V6:
[V2, V0, V3, V6]
```

---

# D3 — Floyd, Excentricidad y Centro

**Nivel:** Intermedio ●●○

## Grafo

```text
A → B(1), E(6)
B → C(1), E(5)
C → D(1), E(4)
D → E(3)
E → A(7)
```

## Consigna

Implementar:

```java
floyd()
excentricidad(v)
centro()
```

### Definiciones

- **Excentricidad:** máxima distancia mínima desde cualquier vértice hacia el vértice analizado.
- **Centro:** vértice con menor excentricidad.

## Salida Esperada

```text
Excentricidades:

A = 12
B = 12
C = 12
D = 10
E = 6

Centro = E
Excentricidad = 6
```

---

# D4 — Warshall y Alcanzabilidad

**Nivel:** Básico–Intermedio ●●○

## Consigna

Implementar Warshall para obtener la cerradura transitiva.

Método:

```java
existeCamino(i, j)
```

## Salida Esperada

```text
existeCamino(V2, V6) = true

existeCamino(V4, V0) = false

existeCamino(V5, *) = false
```

Observación:

```text
V4 solamente alcanza a V6 y V5.
V5 no tiene salidas.
```

---

# D5 — Ciclos y Orden Topológico

**Nivel:** Desafiante ●●●

## Grafo Acíclico de Prueba

```text
C1 → C2, C3
C2 → C4
C3 → C4
C4 → C5
```

## Consigna

Mediante DFS:

- Detectar ciclos.
- Si no hay ciclos, generar un orden topológico válido.

## Salida Esperada

### Grafo de Trabajo

```text
Contiene ciclo:

V0 → V3 → V2 → V0
```

### Grafo de Previaturas

```text
Acíclico
```

Orden topológico válido:

```text
C1, C2, C3, C4, C5
```

---

# Grafos No Dirigidos

## Grafo de Trabajo

```text
1 — 3 (1)
3 — 2 (2)
3 — 6 (3)
6 — 4 (4)
2 — 5 (5)
1 — 2 (6)
1 — 4 (7)
```

---

# ND1 — TDA No Dirigido y Conexidad

**Nivel:** Básico ●○○

## Consigna

Representar cada arista en ambos sentidos.

Implementar:

```java
esConexo()
```

utilizando DFS o BFS.

## Salida Esperada

```text
esConexo() = true
```

Luego eliminar:

```text
2 — 5
```

Resultado:

```text
esConexo() = false
```

porque el vértice 5 queda aislado.

---

# ND2 — Árbol Abarcador Mínimo (Prim)

**Nivel:** Intermedio ●●○

## Consigna

Implementar Prim comenzando desde el vértice:

```text
1
```

En cada paso seleccionar la arista de menor peso que conecte un vértice nuevo.

## Salida Esperada

```text
Árbol Abarcador Mínimo:

1–3
3–2
3–6
6–4
2–5

Costo total = 15
```

---

# ND3 — Árbol Abarcador Mínimo (Kruskal)

**Nivel:** Intermedio ●●○

## Consigna

Implementar Kruskal procesando las aristas en orden creciente de peso.

Mostrar:

- Aristas elegidas.
- Aristas descartadas por formar ciclo.

## Salida Esperada

Orden de procesamiento:

```text
1–3
3–2
3–6
6–4
2–5
1–2
1–4
```

Árbol resultante:

```text
1–3
3–2
3–6
6–4
2–5

Costo = 15
```

Descartadas:

```text
1–2
1–4
```

---

# ND4 — BFS y Distancia en Aristas

**Nivel:** Intermedio ●●○

## Consigna

Implementar BFS utilizando una cola.

Calcular:

```java
distancia(origen, destino)
```

medida como cantidad de aristas.

Origen:

```text
1
```

## Salida Esperada

```text
Distancias desde 1:

dist(2) = 1
dist(3) = 1
dist(4) = 1

dist(5) = 2
dist(6) = 2
```

---

# ND5 — Puntos de Articulación

**Nivel:** Desafiante ●●●

## Grafo de Prueba

```text
A — B
A — C

C — D
C — E

D — E

E — F
F — G
G — D
```

## Consigna

Mediante DFS calcular:

```java
num_bp(v)
bajo(v)
```

Identificar los puntos de articulación.

## Salida Esperada

```text
Puntos de articulación:

{A, C}
```

### Justificación

#### A

```text
Al eliminar A,
el vértice B queda aislado.
```

#### C

```text
Al eliminar C,
se separa el bloque:

{D, E, F, G}
```

---

# Objetivos de Aprendizaje

Al finalizar este Problem Set se espera haber implementado:

### Grafos dirigidos

- Consultas básicas del TDA.
- Dijkstra.
- Floyd.
- Warshall.
- Detección de ciclos.
- Orden topológico.

### Grafos no dirigidos

- Conexidad.
- BFS.
- DFS.
- Prim.
- Kruskal.
- Puntos de articulación.

---

# Autor

Universidad Católica del Uruguay  
Algoritmos y Estructuras de Datos