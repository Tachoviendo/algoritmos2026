# Solución: Control de Corchetes Balanceados

## 📋 Descripción del Problema

El objetivo es determinar si una secuencia de corchetes `{` y `}` se encuentran correctamente balanceados. Un conjunto de corchetes está balanceado cuando:
- Cada corchete de apertura `{` tiene un correspondiente corchete de cierre `}`
- Los corchetes están ordenados correctamente (no hay cierres sin apertura previa)

---

## 🔧 Solución

### Algoritmo

```
función booleana controlCorchetes(listaDeEntrada)
    crear pila vacía p
    
    mientras listaDeEntrada no sea vacía hacer
        caracter ← obtener siguiente elemento de listaDeEntrada
        
        si caracter = '{' entonces
            apilar(p, caracter)
        
        sino si caracter = '}' entonces
            si pilaVacía(p) entonces
                retornar FALSO
            sino
                desapilar(p)
            fin si
        fin si
    fin mientras
    
    si pilaVacía(p) entonces
        retornar VERDADERO
    sino
        retornar FALSO
    fin si
fin función
```

### Estrategia

El algoritmo utiliza una **pila** como estructura de datos auxiliar:

1. **Para cada `{`**: Se apila el símbolo
2. **Para cada `}`**: 
   - Si la pila está vacía → retorna `FALSO` (hay más cierres que aperturas)
   - Si la pila tiene elementos → se desapila (se empareja con una apertura previa)
3. **Al final**: Si la pila está vacía → todos los símbolos estaban balanceados

---

## 💡 Ejemplos

### Caso 1: Balanceado ✅

**Entrada:** `{}{{}}` → **Resultado:** `VERDADERO`

| Paso | Carácter | Acción | Estado Pila |
|------|----------|--------|------------|
| 1 | `{` | apilar | `{` |
| 2 | `}` | desapilar | (vacía) |
| 3 | `{` | apilar | `{` |
| 4 | `{` | apilar | `{{` |
| 5 | `}` | desapilar | `{` |
| 6 | `}` | desapilar | (vacía) |

✅ La pila termina vacía → **VERDADERO**

### Caso 2: Desbalanceado ❌

**Entrada:** `{{}{{}` → **Resultado:** `FALSO`

| Paso | Carácter | Acción | Estado Pila |
|------|----------|--------|------------|
| 1 | `{` | apilar | `{` |
| 2 | `{` | apilar | `{{` |
| 3 | `}` | desapilar | `{` |
| 4 | `{` | apilar | `{{` |
| 5 | `{` | apilar | `{{{` |
| 6 | `}` | desapilar | `{{` |

❌ La pila NO está vacía → **FALSO**

---

## 📊 Análisis de Complejidad

### Complejidad Temporal: **O(n)**

- El algoritmo recorre la lista completa **una sola vez**
- Por cada carácter, realiza operaciones:
  - `apilar` → O(1)
  - `desapilar` → O(1)
  - `pilaVacía` → O(1)
  
Todas estas operaciones son **constantes**, por lo que:

$$T(n) = O(n)$$

### Complejidad Espacial: **O(n)**

- En el **peor caso**, todos los caracteres son aperturas `{`:
  ```
  {{{{{{
  ```
- Se apilan **n elementos** en la pila
- El espacio adicional requerido es:

$$S(n) = O(n)$$

---

## 📈 Resumen

| Métrica | Valor |
|---------|-------|
| **Complejidad Temporal** | O(n) |
| **Complejidad Espacial** | O(n) |
| **Estructura Utilizada** | Pila |
| **Recorridos** | 1 |

---

## 🎯 Conclusión

La solución es **óptima** en tiempo, ya que necesitamos revisar cada carácter al menos una vez. El uso de una pila permite resolver el problema de manera eficiente y elegante, aprovechando la naturaleza LIFO (*Last In, First Out*) de esta estructura de datos.