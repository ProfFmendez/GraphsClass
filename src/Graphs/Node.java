package Graphs;

import java.util.ArrayList;

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
    public void addLink(Node endNode, int weight){
        Link link = new Link(this, endNode, weight);
        this.links.add(link);
    }

    public void removeLink(Node endNode){
        this.links.removeIf(link -> link.getEndNode().equals(endNode));
    }

    //Print method
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
