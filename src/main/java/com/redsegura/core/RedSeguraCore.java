package com.redsegura.core;

import com.redsegura.app.DataFactory;
import com.redsegura.graph.MixedGraph;

/**
 * Núcleo del sistema RedSegura.
 * Centraliza la creación y el acceso al grafo.
 */
public class RedSeguraCore {

    private final MixedGraph graph;

    public RedSeguraCore() {
        this.graph = DataFactory.createGraph();
    }

    public MixedGraph getGraph() {
        return graph;
    }
}
