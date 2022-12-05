package Graphs;

public class Main {
    public static void main(String[] args) {
        Graphs<String> graph = new Graphs<String>();
        graph.addictVertex("Thiago");
        graph.addictVertex("Robert");
        graph.addictVertex("Danna");
        graph.addictVertex("John");

        graph.addictEdge(2.0, "Thiago","John");
    }
}
