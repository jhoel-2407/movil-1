package com.gxnova.appgxnova;

public class LoginRequest {

    String correo;
    String password;

    public LoginRequest(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }
}