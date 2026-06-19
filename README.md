# Grafos - Proyecto de ejemplo

Este proyecto es una pequeña biblioteca y demo para que los estudiantes
entiendan cómo representar grafos en Java y prueben operaciones básicas
(añadir/quitar nodos y enlaces, impresión por consola).

Contenido importante:

**Estructuras base (Graphs/):**
- src/Graphs/Graph.java: clase que representa el grafo (listas de adyacencia).
- src/Graphs/Node.java: clase que representa un nodo y sus enlaces salientes.
- src/Graphs/Link.java: clase que representa una arista (posible peso).
- src/Graphs/Main.java: ejemplo de uso y demostración en consola.

**Algoritmos de recorrido (Traversals/):**
- src/Traversals/BFS.java: implementación de Breadth-First Search (búsqueda en anchura).
  Explora el grafo por niveles, visitando primero todos los vecinos directos antes 
  de pasar a niveles más profundos. Complejidad O(V + E). Incluye método main con ejemplo.
- src/Traversals/DFS.java: implementación de Depth-First Search (búsqueda en profundidad).
  Explora el grafo recursivamente, profundizando lo máximo posible en cada rama antes 
  de retroceder (backtracking). Complejidad O(V + E). Incluye método main con ejemplo.

Estado actual y objetivo docente
--------------------------------
La implementación actual provee:
- **Estructuras base:** Graph, Node y Link para representar grafos con listas de adyacencia.
- **Algoritmos de recorrido:** BFS (búsqueda en anchura) y DFS (búsqueda en profundidad).

Ambos algoritmos incluyen:
- Explicaciones detalladas en comentarios para estudiantes.
- Análisis de complejidad temporal y espacial.
- Métodos main con ejemplos ejecutables que muestran cómo operar sobre un grafo.

Esto compilará las clases en el directorio `out` y ejecutará la clase seleccionada.
