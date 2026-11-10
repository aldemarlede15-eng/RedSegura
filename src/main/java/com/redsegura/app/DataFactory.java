
package com.redsegura.app;

import com.redsegura.graph.MixedGraph;
import com.redsegura.model.Vertex;

public class DataFactory {

    public static MixedGraph createGraph() {

        MixedGraph graph = new MixedGraph();

        // =====================================
        // 1. CREAR LOS 12 VERTICES
        // =====================================

        graph.addVertex(new Vertex("S01", "UAJS Sede C", "Universidad"));
        graph.addVertex(new Vertex("S02", "UAJS Sede E", "Universidad"));
        graph.addVertex(new Vertex("S03", "Universidad de Sucre", "Universidad"));
        graph.addVertex(new Vertex("S04", "CECAR", "Universidad"));

        graph.addVertex(new Vertex("S05", "Hospital Universitario", "Salud"));
        graph.addVertex(new Vertex("S06", "Clínica Las Américas", "Salud"));

        graph.addVertex(new Vertex("S07", "Estación Central SETP", "Transporte"));
        graph.addVertex(new Vertex("S08", "Terminal de Transporte", "Transporte"));

        graph.addVertex(new Vertex("S09", "Parque Santander", "Punto de encuentro"));
        graph.addVertex(new Vertex("S10", "Mercado de Sincelejo", "Comercio"));
        graph.addVertex(new Vertex("S11", "PEP Argelia", "Paradero"));
        graph.addVertex(new Vertex("S12", "Glorieta Sincelejito", "Movilidad"));

        // =====================================
        // 2. CREAR LAS 18 RUTAS
        // =====================================

        // R01: S01 -> S07
        graph.addDirectedEdge(
                "R01", "S01", "S07", 4,
                "Corredor universitario"
        );

        // R02: S07 -> S01
        graph.addDirectedEdge(
                "R02", "S07", "S01", 6,
                "Retorno por vía alterna"
        );

        // R03: S01 <-> S09
        graph.addUndirectedEdge(
                "R03", "S01", "S09", 5,
                "Corredor peatonal"
        );

        // R04: S02 <-> S01
        graph.addUndirectedEdge(
                "R04", "S02", "S01", 8,
                "Conexión entre sedes"
        );

        // R05: S02 -> S06
        graph.addDirectedEdge(
                "R05", "S02", "S06", 10,
                "Ruta de atención"
        );

        // R06: S06 -> S05
        graph.addDirectedEdge(
                "R06", "S06", "S05", 4,
                "Corredor clínico"
        );

        // R07: S05 <-> S09
        graph.addUndirectedEdge(
                "R07", "S05", "S09", 6,
                "Vía hospitalaria"
        );

        // R08: S09 <-> S10
        graph.addUndirectedEdge(
                "R08", "S09", "S10", 3,
                "Centro histórico"
        );

        // R09: S10 -> S08
        graph.addDirectedEdge(
                "R09", "S10", "S08", 8,
                "Salida al terminal"
        );

        // R10: S08 -> S10
        graph.addDirectedEdge(
                "R10", "S08", "S10", 9,
                "Ingreso desde terminal"
        );

        // R11: S03 <-> S12
        graph.addUndirectedEdge(
                "R11", "S03", "S12", 4,
                "Corredor Puerta Roja"
        );

        // R12: S12 <-> S09
        graph.addUndirectedEdge(
                "R12", "S12", "S09", 7,
                "Troncal al centro"
        );

        // R13: S04 <-> S11
        graph.addUndirectedEdge(
                "R13", "S04", "S11", 6,
                "Conexión universitaria"
        );

        // R14: S11 -> S07
        graph.addDirectedEdge(
                "R14", "S11", "S07", 8,
                "Ruta SETP al centro"
        );

        // R15: S07 <-> S09
        graph.addUndirectedEdge(
                "R15", "S07", "S09", 3,
                "Transferencia central"
        );

        // R16: S07 -> S08
        graph.addDirectedEdge(
                "R16", "S07", "S08", 12,
                "Ruta SETP al terminal"
        );

        // R17: S09 -> S03
        graph.addDirectedEdge(
                "R17", "S09", "S03", 7,
                "Ruta hacia universidad"
        );

        // R18: S12 -> S04
        graph.addDirectedEdge(
                "R18", "S12", "S04", 9,
                "Ruta hacia CECAR"
        );

        return graph;
    }
}
