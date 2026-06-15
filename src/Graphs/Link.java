package Graphs;

/**
 * Representa una arista/enlace entre dos nodos del grafo.
 * startNode -> endNode con un posible peso (weight). En grafos no ponderados
 * el campo weight puede tomar un valor por defecto (-1) que indica ausencia
 * de peso significativo.
 */
public class Link {

    //Attributes
    private Node startNode;
    private Node endNode;
    private int weight;

    public Link(Node startNode, Node endNode, int weight) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;
    }

    //Getters and setters
    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
