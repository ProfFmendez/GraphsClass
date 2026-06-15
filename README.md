# Grafos - Proyecto de ejemplo

Este proyecto es una pequeña biblioteca y demo para que los estudiantes
entiendan cómo representar grafos en Java y prueben operaciones básicas
(añadir/quitar nodos y enlaces, impresión por consola).

Contenido importante:
- src/Graphs/Graph.java: clase que representa el grafo (listas de adyacencia).
- src/Graphs/Node.java: clase que representa un nodo y sus enlaces salientes.
- src/Graphs/Link.java: clase que representa una arista (posible peso).
- src/Graphs/Main.java: ejemplo de uso y demostración en consola.

Estado actual y objetivo docente
--------------------------------
La implementación actual provee la estructura y operaciones auxiliares pero
no implementa algoritmos de búsqueda o rutas (BFS, DFS, Dijkstra, A*, etc.).
La intención es que los estudiantes usen esta base para:
- Implementar y comparar BFS y DFS en grafos dirigidos/no dirigidos.
- Implementar Dijkstra en grafos ponderados.
- Experimentar con transformaciones (eliminar nodos, enlaces, grafos
  dirigidos vs no dirigidos).

Cómo compilar y ejecutar (Windows - PowerShell)
------------------------------------------------
Desde la raíz del proyecto (donde está README.md) ejecuta:

```powershell
javac -d out src/Graphs/*.java ; java -cp out Graphs.Main
```

Esto compilará las clases en el directorio `out` y ejecutará la clase `Graphs.Main`.

Sugerencias para tareas
-----------------------
- Añade métodos en `Graph` para buscar nodos por índice o devolver Optional<Node>.
- Implementa BFS/DFS que devuelva el orden de visita y la distancia mínima
  (en caso de grafos no ponderados BFS puede usarse para distancia mínima en aristas).
- Implementa Dijkstra usando una cola de prioridad para grafos ponderados.

Si necesitas, puedo:
- Añadir plantillas de métodos para BFS/DFS/Dijkstra en este proyecto.
- Proveer tests o casos de ejemplo para que los estudiantes validen sus
  implementaciones.
