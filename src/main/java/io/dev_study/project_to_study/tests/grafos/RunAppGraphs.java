package io.dev_study.project_to_study.tests.grafos;

public class RunAppGraphs {

    public static void main(String[] args) {
        Graphs<String> stringGraphs = new Graphs<String>();

        stringGraphs.addNode("João");
        stringGraphs.addNode("Bia");
        stringGraphs.addNode("Gab");
        stringGraphs.addNode("Pedro");
        stringGraphs.addNode("Lili");

        stringGraphs.addEdge("João", "Bia", 5.0);
        stringGraphs.addEdge("João", "Pedro", 5.0);
        stringGraphs.addEdge("Bia", "Pedro", 7.0);
        stringGraphs.addEdge("Gab", "Pedro", 3.0);
        stringGraphs.addEdge("Pedro", "Lili", 5.0);
        stringGraphs.addEdge("Lili", "Gab", 6.0);
        stringGraphs.addEdge("Bia", "Lili", 8.0);

        stringGraphs.widthSearch();
    }
}
