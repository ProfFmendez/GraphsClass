package Graphs;

import java.util.ArrayList;

/**
 * Representación simple de un grafo mediante listas de adyacencia.
 * Cada nodo mantiene sus enlaces salientes (objetos {@link Link}).
 * <p>
 * - isWeighted indica si los enlaces contienen pesos - un grafo ponderado (si no, se ignora el campo weight).
 * - isDirected indica si los enlaces son dirigidos (un enlace entre A y B no crea automáticamente el inverso).
 * <p>
 * Esta clase contiene métodos auxiliares para construir y manipular el grafo
 */
public class Graph {

    private ArrayList<Node> nodes;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected) {
        this.nodes = new ArrayList<Node>();
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    // Helper methods

    /**
     * addNode Añade un nuevo nodo al grafo.
     *
     * @param webPage etiqueta/identificador del nodo (p.ej. nombre de página web)
     * @return la instancia de {@link Node} creada y añadida
     */
    public Node addNode(String webPage) {
        Node node = new Node(webPage);
        this.nodes.add(node);
        return node;
    }

    /**
     * addLink Crea un enlace desde startNode hacia endNode.
     * Si el grafo no es ponderado, el parámetro weight se ignora y se fija a -1.
     * Si el grafo no es dirigido, se añade también el enlace inverso.
     *
     * @param startNode nodo origen
     * @param endNode   nodo destino
     * @param weight    peso del enlace (se usa sólo si isWeighted == true)
     */
    public void addLink(Node startNode, Node endNode, int weight) {
        if (!this.isWeighted) {
            weight = -1;
        }
        startNode.addLink(endNode, weight);
        if (!this.isDirected) {
            endNode.addLink(startNode, weight);
        }
    }

    /**
     * removeLink Elimina el enlace entre startNode y endNode. Si el grafo no es dirigido,
     * elimina también el enlace inverso.
     *
     * Nota: removeLink busca enlaces por referencia al nodo destino y los
     * elimina; si hay múltiples enlaces hacia el mismo destino (multigrafo),
     * este eliminará todos los que tengan el mismo endNode.
     */
    public void removeLink(Node startNode, Node endNode) {
        startNode.removeLink(endNode);
        if (!this.isDirected) {
            endNode.removeLink(startNode);
        }
    }

    /**
     * removeNode Elimina un nodo del grafo y todos los enlaces entrantes que apuntan a él.
     * Primero se elimina el nodo de la lista principal y luego se recorre el
     * resto de nodos para quitar enlaces que tengan como destino el nodo borrado.
     *
     * Comportamiento importante: si se pasa una referencia a un nodo que no está
     * en la lista igualmente intentará eliminar enlaces entrantes.
     *
     * @param node nodo a eliminar
     */
    public void removeNode(Node node) {
        this.nodes.remove(node);
        for (Node n : this.nodes) {
            n.removeLink(node);
        }
    }

    /**
     * getNodeByWebPage Busca un nodo por su etiqueta (webPage) y lo imprime usando el metodo
     * {@link Node#print}. Si no existe, imprime un mensaje indicando que no se
     * encontró.
     *
     * @param webPage etiqueta del nodo a buscar
     */
    public void getNodeByWebPage(String webPage) {
        for (Node node : this.nodes) {
            if (node.getWebPage().equals(webPage)) {
                node.print();
                return;
            }
        }
        System.out.println("Node with web page '" + webPage + "' not found.");
    }

    //Getters and Setters
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public void setWeighted(boolean weighted) {
        isWeighted = weighted;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }

    // Print method

    /**
     * print Imprime en consola una representación de todos los nodos y sus enlaces.
     * Utiliza {@link Node#print} para cada nodo.
     */
    public void print() {
        for (Node node : this.nodes) {
            node.print();
        }
    }

}
