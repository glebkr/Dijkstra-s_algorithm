package com.glebkr;

import java.util.HashSet;

public class Graph {
    private HashSet<Vertex> vertices = new HashSet<>();

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public HashSet<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(HashSet<Vertex> vertices) {
        this.vertices = vertices;
    }

}
