package Traversals;

import Graphs.Graph;
import Graphs.Link;
import Graphs.Node;

import java.util.ArrayList;

/**
 * - DFS explora lo más profundo posible por cada rama antes de retroceder
 *   (backtracking). Es útil para tareas como detección de componentes conexas,
 *   orden topológico (con variaciones) y búsqueda en espacios de estados.
 * - Esta implementación usa recursión para representar la pila de llamadas;
 *   la variable `depth` sirve únicamente para imprimir la sangría y visualizar
 *   el proceso de entrada/salida en cada nivel de recursión.
 * - La lista `visited` se mantiene externa y evita visitar un mismo nodo
 *   varias veces, necesario para grafos con ciclos.
 *
 * Notas de implementación y complejidad:
 * - Complejidad temporal: O(V + E) visitando cada vértice y arista una vez.
 * - Complejidad espacial: O(V) por la lista `visited` y por la pila de recursión
 *   en el peor caso (profundidad del grafo).
 */
public class DFS {

    /**
     * Entrada pública para DFS que inicializa la recursión con profundidad 0.
     *
     * @param startNode nodo desde el que empezar la exploración
     * @param visited lista donde se almacenan los nodos ya descubiertos
     */
    public static void depthFirstTraversal(Node startNode, ArrayList<Node> visited){
        depthFirstTraversal(startNode, visited, 0);
    }

    /**
     * Implementación recursiva de DFS.
     *
     * @param startNode nodo actual que estamos visitando
     * @param visited lista de nodos descubiertos hasta el momento
     * @param depth     nivel de profundidad (solo para imprimir sangrías y visualizar)
     */
    private static void depthFirstTraversal(Node startNode, ArrayList<Node> visited, int depth){
        // Usamos `depth` para crear una sangría visual que ayuda a seguir la recursión
        String indent = "  ".repeat(depth);
        System.out.println(indent + "→ Visiting: " + startNode.getWebPage());

        // Recorremos los enlaces/sucesores del nodo actual
        for(Link l: startNode.getLinks()){
            Node node = l.getEndNode();
            if(!visited.contains(node)){
                // Marcamos el nodo como descubierto antes de entrar en él (pre-order)
                visited.add(node);
                System.out.println(indent + "  ├─ Found unvisited link: " + node.getWebPage());
                // Llamada recursiva: profundizamos en ese nodo
                depthFirstTraversal(node, visited, depth + 1);
            } else {
                // Si ya fue visitado, lo informamos y no lo volvemos a procesar
                System.out.println(indent + "  └─ Already visited: " + node.getWebPage());
            }
        }
        // Mensaje que representa el acto de retroceder en la recursión (backtracking)
        System.out.println(indent + "← Backtracking from: " + startNode.getWebPage());
    }

    // Metodo main de ejemplo que construye un pequeño grafo y ejecuta DFS.
    // Mantengo el main para que los estudiantes puedan ejecutar y observar el proceso.
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

        System.out.println("\nDepth First Search execution:\n");
        ArrayList<Node> visited = new ArrayList<Node>();
        visited.add(graphDFS.getNodes().getFirst());

        depthFirstTraversal(graphDFS.getNodes().getFirst(), visited);
        System.out.println("\nDFS traversal completed. Visited nodes in order:");
        for(Node node: visited) {
            System.out.println("- " + node.getWebPage());
        }
    }
}
