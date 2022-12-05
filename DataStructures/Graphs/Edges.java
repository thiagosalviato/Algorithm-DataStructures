package Graphs;

import java.util.ArrayList;

public class Edges<Type> {
    private Double weight;
    private Vertex<Type> start;
    private Vertex<Type> end;

    public Edges(Double weight, Vertex<Type> start, Vertex<Type> end){
        this.weight = weight;
        this.start = start;
        this.end = end;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Vertex<Type> getStart() {
        return start;
    }

    public void setStart(Vertex<Type> start) {
        this.start = start;
    }

    public Vertex<Type> getEnd() {
        return end;
    }

    public void setEnd(Vertex<Type> end) {
        this.end = end;
    }
}
