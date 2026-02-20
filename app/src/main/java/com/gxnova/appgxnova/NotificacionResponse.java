package com.gxnova.appgxnova;

public class NotificacionResponse {

    private int id_notificacion;
    private String titulo;
    private String mensaje;
    private boolean leida;
    private String fecha;

    public int getId_notificacion() {
        return id_notificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean isLeida() {
        return leida;
    }

    public String getFecha() {
        return fecha;
    }
}
