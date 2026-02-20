package com.gxnova.appgxnova;

public class TrabajoRequest {

    private String titulo;
    private String descripcion;
    private int categoria_id;
    private double precio;

    public TrabajoRequest(String titulo, String descripcion, int categoria_id, double precio) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria_id = categoria_id;
        this.precio = precio;
    }
}
