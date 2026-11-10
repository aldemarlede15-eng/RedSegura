
package com.redsegura.model;

public class Edge {

    private final String id;
    private final Vertex origen;
    private final Vertex destino;
    private final int peso;
    private final String etiqueta;
    private final boolean dirigida;

    // Constructor principal
    public Edge(String id, Vertex origen, Vertex destino,
                int peso, String etiqueta, boolean dirigida) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de la ruta no puede estar vacío");
        }

        if (origen == null || destino == null) {
            throw new IllegalArgumentException("Los vértices no pueden ser nulos");
        }

        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero");
        }

        if (etiqueta == null || etiqueta.trim().isEmpty()) {
            throw new IllegalArgumentException("La etiqueta no puede estar vacía");
        }

        this.id = id.trim();
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
        this.etiqueta = etiqueta.trim();
        this.dirigida = dirigida;
    }

    // Constructor compatible con el código anterior
    public Edge(Vertex origen, Vertex destino, int peso) {
        this("SIN-ID", origen, destino, peso, "Conexión general", true);
    }

    public String getId() {
        return id;
    }

    public Vertex getOrigen() {
        return origen;
    }

    public Vertex getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public boolean isDirigida() {
        return dirigida;
    }

    @Override
    public String toString() {
        String conexion = dirigida ? "->" : "<->";

        return id + ": "
                + origen.getId() + " " + conexion + " "
                + destino.getId() + " | "
                + etiqueta + " | "
                + peso + " min";
    }
}
