package com.redsegura.graph;

import com.redsegura.model.Edge;
import java.util.List;

public class PathResult {

    private final List<String> path;
    private final List<Edge> edges;
    private final int totalCost;

    public PathResult(List<String> path, List<Edge> edges, int totalCost) {
        this.path = List.copyOf(path);
        this.edges = List.copyOf(edges);
        this.totalCost = totalCost;
    }

    public List<String> getPath() {
        return path;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int getTotalCost() {
        return totalCost;
    }
}