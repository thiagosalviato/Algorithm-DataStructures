package Graphs;

import java.util.ArrayList;

public class Graphs<Type> {

    private ArrayList<Vertex<Type>> vertex;
    private ArrayList<Edges<Type>> edges;

    public Graphs(){
        this.vertex = new ArrayList<Vertex<Type>>();
        this.edges = new ArrayList<Edges<Type>>();
    }

    public void addictVertex(Type data){
        Vertex<Type> newVertex = new Vertex<Type>(data);
        this.vertex.add(newVertex);
    }

    public void addictEdge(Double weight, Type start, Type end){
        Vertex<Type> start = this.getVertex(dataStart);
        Vertex<Type> end = this.getVertex(dataEnd);
        Edges<Type> edges = new Edges<Type>(weight,start,end);
        start.addictEdgesOut(edges);
        end.addictEdgesIn(edges);
        this.edges.add(edges);
    }

    public Vertex<Type>  getVertex(Type data){
        Vertex<Type> vertex = null;
        for (int i = 0; i < this.vertex.size(); i++) {
            if (this.vertex.get(i).getData().equals(data)){
                vertex = this.vertex.get(i);
                break;
            }
        }
        return vertex;
    }
}
