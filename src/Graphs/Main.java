package Graphs;

/**
 * Clase de demostración que construye dos grafos sencillos y muestra el uso
 * de los métodos de la API: añadir nodos, añadir/quitar enlaces, eliminar
 * nodos y mostrar el grafo por consola.
 *
 */
public class Main {

    public static void main (String[] args){

        /*
         * Ejemplo 1: grafo no ponderado y no dirigido.
         * - isWeighted = false  -> los pesos serán ignorados (se usan -1)
         * - isDirected = false  -> al añadir un enlace también se añade el inverso
         */

        Graph linkedWebPagesNonW = new Graph(false, false);

        Node google = linkedWebPagesNonW.addNode("Google");
        Node instagram = linkedWebPagesNonW.addNode("Instagram");
        Node github = linkedWebPagesNonW.addNode("Github");
        Node linkedin = linkedWebPagesNonW.addNode("LinkedIn");
        Node twitch = linkedWebPagesNonW.addNode("Twitch");

        linkedWebPagesNonW.addLink(google, instagram, -1);
        linkedWebPagesNonW.addLink(google, linkedin, -1);
        linkedWebPagesNonW.addLink(instagram, github, -1);
        linkedWebPagesNonW.addLink(github, linkedin, -1);
        linkedWebPagesNonW.addLink(linkedin, twitch, -1);

        linkedWebPagesNonW.print();

        System.out.println("\n****************************************\n");

        /*
         * Ejemplo 2: grafo ponderado y dirigido.
         * Aquí los pesos tienen significado y no se añaden enlaces inversos
         * automáticamente porque isDirected = true.
         */

        Graph linkedWebPagesW = new Graph(true, true);

        Node googleW = linkedWebPagesW.addNode("Google");
        Node instagramW = linkedWebPagesW.addNode("Instagram");
        Node githubW = linkedWebPagesW.addNode("Github");
        Node linkedinW = linkedWebPagesW.addNode("LinkedIn");
        Node twitchW = linkedWebPagesW.addNode("Twitch");

        linkedWebPagesW.addLink(googleW, instagramW, 3);
        linkedWebPagesW.addLink(googleW, linkedinW, 2);
        linkedWebPagesW.addLink(instagramW, githubW, 6);
        linkedWebPagesW.addLink(githubW, linkedinW, 3);
        linkedWebPagesW.addLink(githubW, instagramW, 6);
        linkedWebPagesW.addLink(linkedinW, twitchW, 1);

        linkedWebPagesW.print();

        System.out.println("\n****************************************\n");

        // Demostración de eliminación de nodos y enlaces
        linkedWebPagesW.removeNode(instagramW);
        linkedWebPagesW.removeLink(googleW, linkedinW);
        linkedWebPagesW.print();

    }

}
