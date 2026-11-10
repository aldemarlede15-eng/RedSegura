
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
- Estructuras de datos

### 3. Estructura del proyecto

El proyecto está organizado en los siguientes paquetes:

- `com.redsegura`: clase principal RedSegura.
- `com.redsegura.model`: clases Vertex y Edge.
- `com.redsegura.graph`: grafo, representaciones, BFS, DFS y Dijkstra.
- `com.redsegura.tree`: árbol binario de búsqueda y árbol AVL.
- `com.redsegura.app`: fábrica de datos iniciales.

### 4. Funcionalidades

- Registro de 12 vértices.
- Administración de 18 rutas.
- Conexiones dirigidas y no dirigidas.
- Representación mediante lista de adyacencia.
- Representación mediante matriz de adyacencia ponderada.
- Representación mediante matriz de incidencia.
- Recorrido BFS utilizando una cola.
- Recorrido DFS mediante recursividad.
- Búsqueda, inserción y eliminación en ABB.
- Inserción, búsqueda, eliminación y balanceo en AVL.
- Búsqueda de rutas óptimas mediante Dijkstra.
- Bloqueo de rutas y recálculo de caminos.
- Validación de vértices y pesos inválidos.

### 5. Algoritmos y complejidad

| Algoritmo | Complejidad |
|---|---|
| Búsqueda ABB | O(h) |
| Inserción ABB | O(h) |
| Eliminación ABB | O(h) |
| Búsqueda AVL | O(log n) |
| Inserción AVL | O(log n) |
| Eliminación AVL | O(log n) |
| BFS | O(V + E) |
| DFS | O(V + E) |
| Dijkstra con PriorityQueue | O((V + E) log V) |

Donde:

- V representa la cantidad de vértices.
- E representa la cantidad de aristas.
- h representa la altura del árbol.

### 6. Prueba de Dijkstra

Se realiza una búsqueda de la ruta más corta desde S02 hasta S08.

Ruta inicial:

S02 → S01 → S07 → S08

Rutas utilizadas:

- R04: 8 minutos.
- R01: 4 minutos.
- R16: 12 minutos.

Tiempo total: 24 minutos.

Al bloquear la ruta R16, el sistema calcula una ruta alternativa:

S02 → S01 → S09 → S10 → S08

Rutas utilizadas:

- R04: 8 minutos.
- R03: 5 minutos.
- R08: 3 minutos.
- R09: 8 minutos.

Tiempo total: 24 minutos.

### 7. Pruebas unitarias

El proyecto utiliza JUnit 5 para verificar el funcionamiento de sus estructuras y algoritmos.

Pruebas implementadas:

- DijkstraSolverTest: 5 pruebas.
- MixedGraphTest: 8 pruebas.
- AvlTest: 6 pruebas.
- BinarySearchTreeTest: 5 pruebas.

Total: 24 pruebas ejecutadas correctamente.

### 8. Ejecución del proyecto

1. Abrir el proyecto en Apache NetBeans.
2. Verificar las dependencias Maven.
3. Ejecutar la clase principal `RedSegura.java`.
4. Para ejecutar las pruebas, utilizar la opción Test del proyecto.

### 9. Autor

Proyecto académico desarrollado para la asignatura Estructura de Datos II.

Tecnología: Java 17.

