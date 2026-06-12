package Graphs;

import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> nodes;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected) {
        this.nodes = new ArrayList<Node>();
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    //Helper methods
    public Node addNode(String webPage) {
        Node node = new Node(webPage);
        this.nodes.add(node);
        return node;
    }

    public void addLink(Node startNode, Node endNode, int weight) {
        if (!this.isWeighted) {
            weight = -1;
        }
        startNode.addLink(endNode, weight);
        if (!this.isDirected) {
            endNode.addLink(startNode, weight);
        }
    }

    public void removeLink(Node startNode, Node endNode) {
        startNode.removeLink(endNode);
        if (!this.isDirected) {
            endNode.removeLink(startNode);
        }
    }

    public void removeNode(Node node) {
        this.nodes.remove(node);
        for (Node n : this.nodes) {
            n.removeLink(node);
        }
    }

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

    //Print method
    public void print(){
        for (Node node : this.nodes){
            node.print();
        }
    }

}
