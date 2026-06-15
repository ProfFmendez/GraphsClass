package Graphs;

import java.util.ArrayList;

/**
 * Representa un vértice (nodo) del grafo. Cada nodo mantiene una lista de
 * enlaces salientes ({@link Link}). La etiqueta 'webPage' se usa aquí como
 * identificador textual del nodo (p. ej. el nombre de una página web en la demo).
 */
public class Node {

    //Attributes
    private String webPage;
    private ArrayList<Link> links;

    public Node(String webPage) {
        this.webPage = webPage;
        this.links = new ArrayList<Link>();
    }

    //Getters and setters
    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<Link> links) {
        this.links = links;
    }

    // Helper methods
    /**
     * addLink Añade un enlace saliente desde este nodo hacia endNode con el peso
     * especificado. Si el grafo no es ponderado, el peso se ignora y se fija a -1.
     *
     * @param endNode nodo destino del enlace
     * @param weight peso del enlace (puede ser -1 si no hay pesos)
     */
    public void addLink(Node endNode, int weight){
        Link link = new Link(this, endNode, weight);
        this.links.add(link);
    }

    /**
     * removeLink Elimina todos los enlaces salientes cuyo nodo destino sea endNode.
     * Utiliza removeIf con una expresión lambda para filtrar rápidamente.
     *
     * Esta operación: O(k) donde k es el número de enlaces salientes de este nodo.
     *
     * @param endNode nodo destino cuyos enlaces deben eliminarse
     */
    public void removeLink(Node endNode){
        this.links.removeIf(link -> link.getEndNode().equals(endNode));
    }

    // Print method
    /**
     * Imprime una representación visual sencilla del nodo y sus enlaces
     * salientes. Formatea la salida para que sea legible en consola y muestre
     * el destino y el peso de cada enlace.
     */
    public void print(){
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║ Node: " + String.format("%-24s", webPage) + "    ║");
        System.out.println("╠═══════════════════════════════════╣");
        if (links.isEmpty()) {
            System.out.println("║ No outgoing links                 ║");
        } else {
            for (Link link : links) {
                String linkInfo = "→ " + link.getEndNode().getWebPage() + " (weight: " + link.getWeight() + ")";
                System.out.println("║ " + String.format("%-31s", linkInfo) + "   ║");
            }
        }
        System.out.println("╚═══════════════════════════════════╝");
    }

}
