
package com.redsegura.model;

public class Vertex {

    private final String id;
    private String nombre;
    private String tipo;

    // Constructor principal
    public Vertex(String id, String nombre, String tipo) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío");
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo no puede estar vacío");
        }

        this.id = id.trim();
        this.nombre = nombre.trim();
        this.tipo = tipo.trim();
    }

    // Constructor compatible con las clases anteriores
    public Vertex(String id, String nombre) {
        this(id, nombre, "General");
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEtiqueta() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        this.nombre = nombre.trim();
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo no puede estar vacío");
        }

        this.tipo = tipo.trim();
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " (" + tipo + ")";
    }
}
