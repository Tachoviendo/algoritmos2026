# Ejercicio 5 — Operaciones del Trie y NodoTrie

---

## 1. buscar(String palabra) — palabra completa

**Descripción**: Recorre el trie letra por letra siguiendo los hijos correspondientes. Solo devuelve `true` si el camino completo existe Y el último nodo está marcado como `esPalabra`.

**Precondición**: `palabra != null`.
**Postcondición**: devuelve `true` si la palabra fue insertada; `false` si no existe o si existe el camino pero no es palabra completa (ej. "cas" cuando solo está "casa").

**Orden**: O(L) con L = largo de la palabra. No depende de cuántas palabras haya en el trie.

```
// Árbol
buscar(palabra):
    si palabra es nula o vacía → retornar false
    retornar raiz.buscar(palabra, 0)

// Nodo
buscar(palabra, pos):
    si pos == palabra.largo → retornar esPalabra
    i = indice(palabra[pos])
    si hijos[i] == null → retornar false
    retornar hijos[i].buscar(palabra, pos+1)
```

---

## 2. predecir(String prefijo) — lista de palabras por prefijo

**Descripción**: Dos pasos. Primero baja hasta el nodo donde termina el prefijo (`descender`). Luego hace un DFS desde ese nodo recolectando todas las palabras que cuelgan de ahí (`recolectar`).

**Precondición**: `prefijo != null` (puede ser vacío, en cuyo caso devuelve todas las palabras).
**Postcondición**: devuelve la lista de palabras que comienzan con `prefijo`; lista vacía si no existe ninguna.

**Orden**: O(P + K) con P = largo del prefijo y K = cantidad de caracteres del subárbol resultante. El resto del trie no se toca.

```
// Árbol
predecir(prefijo):
    resultado = lista vacía
    nodo = raiz.descender(prefijo, 0)
    si nodo != null → nodo.recolectar(prefijo, resultado)
    retornar resultado

// Nodo — descender
descender(prefijo, pos):
    si pos == prefijo.largo → retornar este nodo
    i = indice(prefijo[pos])
    si hijos[i] == null → retornar null
    retornar hijos[i].descender(prefijo, pos+1)

// Nodo — recolectar (DFS)
recolectar(acumulado, resultado):
    si esPalabra → agregar acumulado a resultado
    para cada hijo no nulo en posición i:
        letra = 'a' + i
        hijos[i].recolectar(acumulado + letra, resultado)
```

---

## 3. insertar(String palabra, T dato) — con dato asociado

**Descripción**: Igual que el insertar básico, pero el nodo final guarda un dato genérico T (por ejemplo, una lista de páginas del libro donde aparece la palabra).

**Precondición**: `palabra != null` y no vacía.
**Postcondición**: el camino correspondiente a `palabra` existe en el trie, el nodo final tiene `esPalabra = true` y `dato = valor`.

**Orden**: O(L) con L = largo de la palabra.

```
// Nodo — campo adicional
dato: T = null

// Árbol
insertar(palabra, dato):
    si palabra no es nula ni vacía:
        raiz.insertar(palabra, dato, 0)

// Nodo
insertar(palabra, dato, pos):
    si pos == palabra.largo:
        esPalabra = true
        este.dato = dato
    si no:
        i = indice(palabra[pos])
        si hijos[i] == null → hijos[i] = nuevo Nodo
        hijos[i].insertar(palabra, dato, pos+1)
```

---

## 4. eliminar(String palabra) — eliminar una palabra

**Descripción**: Recorre el trie hasta el nodo final y desmarca `esPalabra`. La versión simple no elimina nodos; la versión completa elimina los nodos que quedan "huérfanos" (sin hijos y sin marcar como palabra).

**Precondición**: `palabra != null` y no vacía.
**Postcondición**: `buscar(palabra)` retorna `false`. Los nodos intermedios que forman prefijos de otras palabras no se eliminan.

**Orden**: O(L) con L = largo de la palabra.

```
// Árbol — versión simple (solo desmarca)
eliminar(palabra):
    si palabra no es nula ni vacía:
        raiz.eliminar(palabra, 0)

// Nodo — versión simple
eliminar(palabra, pos):
    si pos == palabra.largo:
        esPalabra = false   ← solo desmarcar
    si no:
        i = indice(palabra[pos])
        si hijos[i] != null:
            hijos[i].eliminar(palabra, pos+1)

// Nodo — versión completa (retorna true si el nodo puede borrarse)
eliminar(palabra, pos):
    si pos == palabra.largo:
        esPalabra = false
        retornar todos los hijos son null  ← si no quedan caminos, se puede borrar
    i = indice(palabra[pos])
    si hijos[i] == null → retornar false   ← palabra no existe
    sePuedeBorrar = hijos[i].eliminar(palabra, pos+1)
    si sePuedeBorrar:
        hijos[i] = null
    retornar no esPalabra y todos los hijos son null
```
