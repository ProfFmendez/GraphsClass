package Graphs;

public class Main {

    public static void main (String[] args){

        /*
         * Here we have a non-weighted and non-directed graph
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
        linkedWebPagesNonW.addLink(github, instagram, -1);

        linkedWebPagesNonW.addLink(linkedin, twitch, -1);

        linkedWebPagesNonW.print();

        System.out.println("\n****************************************\n");

        /*
         * Here we have a weighted and directed graph
         */

        Graph linkedWebPagesW = new Graph(true, true);

        Node googleW = linkedWebPagesW.addNode("Google");
        Node instagramW = linkedWebPagesW.addNode("Instagram");
        Node githubW = linkedWebPagesW.addNode("Github");
        Node linkedinW = linkedWebPagesW.addNode("LinkedIn");
        Node twitchW = linkedWebPagesW.addNode("Twitch");

        linkedWebPagesW.addLink(googleW, instagramW, 3);
        linkedWebPagesW.addLink(googleW, linkedinW, 2);

        linkedWebPagesW.addLink(instagramW, githubW, 5);

        linkedWebPagesW.addLink(githubW, linkedinW, 3);
        linkedWebPagesW.addLink(githubW, instagramW, 6);

        linkedWebPagesW.addLink(linkedinW, twitchW, 1);

        linkedWebPagesW.print();

    }

}
