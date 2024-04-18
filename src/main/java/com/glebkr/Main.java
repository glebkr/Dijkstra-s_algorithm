package com.glebkr;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Vertex vertexF = new Vertex("F");

        vertexA.addDestination(vertexB, 10);
        vertexA.addDestination(vertexC, 15);

        vertexB.addDestination(vertexD, 12);
        vertexB.addDestination(vertexF, 15);

        vertexC.addDestination(vertexE, 10);

        vertexD.addDestination(vertexE, 2);
        vertexD.addDestination(vertexF, 1);

        vertexF.addDestination(vertexE, 5);

        Graph graph = new Graph();

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);
        graph.addVertex(vertexF);

        calculateDijkstraGraph(vertexA);

        System.out.println(graph.getVertices().toArray()[0]);
    }

    public static void calculateDijkstraGraph(Vertex sourceVertex) {
        sourceVertex.setDistance(0);

        HashSet<Vertex> visitedVertices = new HashSet<>();
        HashSet<Vertex> unvisitedVertices = new HashSet<>();

        unvisitedVertices.add(sourceVertex);

        while (!unvisitedVertices.isEmpty()) {
            Vertex currentVertex = getVertexWithMinimalDistance(unvisitedVertices);
            unvisitedVertices.remove(currentVertex);

            for (Map.Entry<Vertex, Integer> adjacentVertex : currentVertex.getAdjacentVertices().entrySet()) {
                Vertex vertex = adjacentVertex.getKey();
                Integer edgeWeight = adjacentVertex.getValue();
                if (!visitedVertices.contains(vertex)) {
                    calculateVertexDistance(vertex, edgeWeight, currentVertex);
                    unvisitedVertices.add(vertex);
                }
            }

            visitedVertices.add(currentVertex);
        }
    }

    private static Vertex getVertexWithMinimalDistance(HashSet<Vertex> unvisitedVertexes) {
        Integer lowestDistance = Integer.MAX_VALUE;
        Vertex lowestVertex = null;

        for (Vertex vertex : unvisitedVertexes) {
            if (vertex.getDistance() < lowestDistance) {
                lowestDistance = vertex.getDistance();
                lowestVertex = vertex;
            }
        }

        return lowestVertex;
    }

    private static void calculateVertexDistance(Vertex vertex, Integer edgeWeight, Vertex sourceVertex) {
        if (sourceVertex.getDistance() + edgeWeight < vertex.getDistance()) {
            vertex.setDistance(sourceVertex.getDistance() + edgeWeight);
            LinkedList<Vertex> shortestPath = new LinkedList<>(sourceVertex.getShortestPath());
            shortestPath.add(sourceVertex);
            vertex.setShortestPath(shortestPath);
        }
    }




}