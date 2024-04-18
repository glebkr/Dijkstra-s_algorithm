package com.glebkr;

import java.util.HashMap;
import java.util.LinkedList;

public class Vertex {

    private String name;
    private Integer distance = Integer.MAX_VALUE;
    private LinkedList<Vertex> shortestPath = new LinkedList<>();

    private HashMap<Vertex, Integer> adjacentVertices = new HashMap<>();

    public void addDestination(Vertex vertex, Integer distance) {
        this.adjacentVertices.put(vertex, distance);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", shortestPath=" + shortestPath +
                '}';
    }

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Vertex> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(LinkedList<Vertex> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public HashMap<Vertex, Integer> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(HashMap<Vertex, Integer> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

}
