package Graphs;

import java.util.ArrayList;

public class Vertex<Type> {
    private Type data;
    private ArrayList<Type> edgesIn;
    private ArrayList<Edges<Type>> edgesOut;

    public Vertex(Type value){
        this.data = value;
        this.edgesIn = new ArrayList<Type>();
        this.edgesOut = new ArrayList<Edges<Type>>();
    }

    public Type getData() {
        return data;
    }

    public void setData(Type data) {
        this.data = data;
    }

    public void addictEdgesIn(Edges<Type> edges){
        this.edgesIn.add((Type) edges);
    }


}
