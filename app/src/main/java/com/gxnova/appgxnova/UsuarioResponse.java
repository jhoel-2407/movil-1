package com.gxnova.appgxnova;

import java.util.List;

public class UsuarioResponse {

    private int id_usuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String foto_perfil;
    private String fecha_registro;
    private String estado;
    private boolean verificado;

    public int getId_usuario() { return id_usuario; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getFoto_perfil() { return foto_perfil; }
    public String getFecha_registro() { return fecha_registro; }
    public String getEstado() { return estado; }
    public boolean isVerificado() { return verificado; }
}
