package Traversals;

import Graphs.Graph;
import Graphs.Node;

import java.util.ArrayList;

/**
 * - BFS explora un grafo por niveles: primero visita el nodo inicial,
 *   luego todos sus vecinos directos, luego los vecinos de esos vecinos, y así sucesivamente.
 * - Aquí usamos una cola (representada con ArrayList) para mantener el orden FIFO
 *   en el que los nodos deben ser procesados.
 * - La lista `visited` evita procesar un mismo nodo más de una vez y por tanto
 *   evita ciclos infinitos en grafos con ciclos.
 *
 * Notas de implementación y complejidad:
 * - Complejidad temporal: O(V + E) donde V son vértices y E son aristas,
 *   asumiendo operaciones de cola en O(1). En esta implementación la eliminación
 *   en la posición 0 de un ArrayList es O(n), por lo que para grandes grafos
 *   es preferible usar LinkedList o la interfaz Queue (ArrayDeque/LinkedList).
 * - Complejidad espacial: O(V) por la estructura `visited` y la `queue`.
 */
public class BFS {

    /**
     * Realiza la travesía en anchura (BFS) a partir de `startNode`.
     *
     * @param startNode nodo desde el que empezamos la exploración
     * @param visited lista (externa) donde se registran los nodos visitados
     *                en el orden en el que fueron descubiertos
     */
    public static void breadthFirstTraversal(Node startNode, ArrayList<Node> visited) {
        // Cola FIFO para almacenar los nodos pendientes de visitar.
        // Se podría usar Queue<Node> q = new LinkedList<>() o ArrayDeque por eficiencia.
        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(startNode);
        // Marcamos el nodo inicial como visitado antes de procesarlo (descubrimiento).
        visited.add(startNode);

        // Procesamos hasta que no queden nodos en la cola
        while (!queue.isEmpty()) {
            // Tomamos el siguiente nodo de la cola (frente)
            Node currentNode = queue.remove(0);
            System.out.println("→ Visiting: " + currentNode.getWebPage());

            // Recorremos los enlaces/sucesores del nodo actual
            for (var link : currentNode.getLinks()) {
                Node neighbor = link.getEndNode();
                // Si no ha sido visitado aún, lo marcamos y lo encolamos
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    System.out.println("  ├─ Found unvisited link: " + neighbor.getWebPage());
                } else {
                    // Si ya se visitó, lo ignoramos para evitar volver a procesarlo
                    System.out.println("  └─ Already visited: " + neighbor.getWebPage());
                }
            }
        }

    }

    // Metodo main de ejemplo que construye un pequeño grafo y ejecuta BFS.
    // Mantengo el main para que los estudiantes puedan ejecutar y observar el orden.
    public static void main (String[] args){
        Graph graphDFS = new Graph(false, true);

        Node google = graphDFS.addNode("Google");
        Node instagram = graphDFS.addNode("Instagram");
        Node github = graphDFS.addNode("Github");
        Node linkedin = graphDFS.addNode("LinkedIn");
        Node twitch = graphDFS.addNode("Twitch");
        Node youTube = graphDFS.addNode("YouTube");

        graphDFS.addLink(google, instagram, -1);
        graphDFS.addLink(google, linkedin, -1);
        graphDFS.addLink(instagram, github, -1);
        graphDFS.addLink(instagram, twitch, -1);
        graphDFS.addLink(linkedin, youTube, -1);

        graphDFS.print();

        System.out.println("\nBreadth First Search execution:\n");
        ArrayList<Node> visited = new ArrayList<Node>();
        breadthFirstTraversal(graphDFS.getNodes().getFirst(), visited);
        System.out.println("\nBFS traversal completed. Visited nodes in order:");
        for(Node node: visited) {
            System.out.println("- " + node.getWebPage());
        }
    }

}
