package com.example.demo.modelos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Usuario {

    @NotBlank(message = "El nombre no puede esar vacío")
    private char nombre;

    @Id //El correo es el que identifica a cada usuario
    @NotBlank(message = "El correo no puede estar vacío")
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String contraseña;

    @Enumerated(EnumType.STRING)
    private Rol_usuario rol_usuario;

    public enum Rol_usuario{
        ADMIN, CLIENTE
    }
}
