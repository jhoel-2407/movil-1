package com.gxnova.appgxnova;

public class RegisterRequest {

    String nombre;
    String correo;
    String password;

    public RegisterRequest(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }
}
