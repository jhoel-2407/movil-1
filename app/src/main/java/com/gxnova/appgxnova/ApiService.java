package com.gxnova.appgxnova;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Body;
import retrofit2.http.Path;

public interface ApiService {

    // LOGIN
    @POST("api/auth/login")
    Call<LoginResponse> login(@Body LoginRequest request);

    // USUARIOS
    @GET("api/usuarios")
    Call<List<UsuarioResponse>> obtenerUsuarios();

    // CATEGORIAS
    @GET("api/categorias")
    Call<List<CategoriaResponse>> obtenerCategorias();

    // TRABAJOS
    @GET("api/trabajos")
    Call<TrabajoResponse>obtenerTrabajos();

    // POSTULACIONES
    @GET("api/postulaciones")
    Call<List<PostulacionResponse>> obtenerPostulaciones();

    // NOTIFICACIONES
    @GET("api/notificaciones")
    Call<List<NotificacionResponse>> obtenerNotificaciones();

    // HABILIDADES
    @GET("api/habilidades")
    Call<List<HabilidadResponse>> obtenerHabilidades();

    //Trabajos
    @POST("api/trabajos")
    Call<TrabajoResponse> crearTrabajo(@Body TrabajoRequest request);

}
