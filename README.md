# RED SEGURA SINCELEJO

## Árboles y grafos aplicados a una red de atención de emergencias

### 1. Descripción del proyecto

RedSegura es un sistema desarrollado en Java que representa una red de atención de emergencias en Sincelejo mediante estructuras de datos como árboles binarios de búsqueda, árboles AVL y grafos.

El sistema permite administrar vértices y rutas, representar conexiones, realizar recorridos y encontrar caminos de menor costo entre diferentes puntos de la ciudad.

### 2. Tecnologías utilizadas

- Java 17
- Apache NetBeans
- Maven
- JUnit 5
- Git y GitHub

### 3. Estructura del proyecto

El proyecto está organizado en los siguientes paquetes:

- `com.redsegura`: contiene la clase principal `RedSegura`.
- `com.redsegura.app`: contiene la fábrica de datos iniciales.
- `com.redsegura.core`: contiene el núcleo del sistema.
- `com.redsegura.graph`: contiene las clases relacionadas con grafos, recorridos y algoritmos.
- `com.redsegura.model`: contiene los modelos de vértices y aristas.
- `com.redsegura.tree`: contiene las implementaciones de árboles ABB y AVL.

### 4. Funcionalidades implementadas

**Árbol binario de búsqueda (ABB)**

- Inserción de vértices.
- Búsqueda.
- Eliminación.
- Recorridos inorden, preorden y postorden.
- Cálculo de altura.
- Conteo de comparaciones.

**Árbol AVL**

- Inserción y eliminación.
- Búsqueda de vértices.
- Cálculo de altura y factor de equilibrio.
- Rotaciones LL, RR, LR y RL.
- Verificación del balance del árbol.
- Recorridos.

**Grafos**

- Creación de 12 vértices y 18 rutas.
- Representación mediante lista de adyacencia.
- Representación mediante matriz de adyacencia ponderada.
- Representación mediante matriz de incidencia.
- Recorrido BFS utilizando una cola.
- Recorrido DFS utilizando recursividad.
- Detección de ciclos.
- Identificación de componentes conexos débiles.
- Bloqueo y habilitación de rutas.

**Algoritmo de Dijkstra**

- Búsqueda del camino de menor costo.
- Uso de `PriorityQueue`.
- Registro de distancias y vértices predecesores.
- Reconstrucción del camino encontrado.
- Manejo de vértices inexistentes y destinos sin conexión.

### 5. Datos de la red

El sistema representa una red de Sincelejo con 12 puntos:

- UAJS Sede C.
- UAJS Sede E.
- Universidad de Sucre.
- CECAR.
- Hospital Universitario.
- Clínica Las Américas.
- Estación Central SETP.
- Terminal de Transporte.
- Parque Santander.
- Mercado de Sincelejo.
- PEP Argelia.
- Glorieta Sincelejito.

La red cuenta con 18 rutas ponderadas, algunas dirigidas y otras no dirigidas.

### 6. Resultados del algoritmo de Dijkstra

**Ruta inicial: S02 → S08**

Camino encontrado:

`S02 → S01 → S07 → S08`

| Ruta | Costo |
|---|---:|
| R04 | 8 minutos |
| R01 | 4 minutos |
| R16 | 12 minutos |
| **Total** | **24 minutos** |

**Ruta después de bloquear R16**

Al bloquear la ruta R16, el sistema calcula nuevamente el camino:

`S02 → S01 → S09 → S10 → S08`

| Ruta | Costo |
|---|---:|
| R04 | 8 minutos |
| R03 | 5 minutos |
| R08 | 3 minutos |
| R09 | 8 minutos |
| **Total** | **24 minutos** |

### 7. Análisis de complejidad

| Estructura o algoritmo | Complejidad temporal |
|---|---|
| Árbol ABB | O(h), peor caso O(n) |
| Árbol AVL | O(log n) |
| BFS | O(V + E) |
| DFS | O(V + E) |
| Dijkstra con PriorityQueue | O((V + E) log V) |

Donde:

- V representa la cantidad de vértices.
- E representa la cantidad de aristas.
- n representa la cantidad de elementos.
- h representa la altura del árbol.

### 8. Pruebas unitarias

El proyecto utiliza JUnit 5 para verificar el funcionamiento de las estructuras de datos y los algoritmos.

Resultados de las pruebas:

| Clase de prueba | Pruebas |
|---|---:|
| DFSTest | 4 |
| DijkstraSolverTest | 7 |
| MixedGraphTest | 8 |
| AvlTest | 6 |
| BinarySearchTreeTest | 5 |
| **Total** | **30** |

Todas las pruebas se ejecutaron correctamente:

- 30 pruebas ejecutadas.
- 0 fallos.
- 0 errores.
- 0 pruebas omitidas.

Resultado de ejecución: `BUILD SUCCESS`.

### 9. Ejecución del proyecto

Para ejecutar el proyecto desde Apache NetBeans:

1. Abrir el proyecto RedSegura.
2. Verificar que esté configurado para compilar con Java 17.
3. Ejecutar la clase principal `RedSegura.java`.

También se pueden ejecutar las pruebas desde Maven utilizando:

```bash
mvn test
```

### 10. Autor

Proyecto académico desarrollado para la asignatura **Estructura de Datos II**, aplicando árboles y grafos a una red de atención de emergencias en Sincelejo.
