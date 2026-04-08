package com.example.demo.modelos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Usuario {

    @NotBlank(message = "El nombre no puede esar vacío")
    private char nombre;

    @Id //El correo es el que identifica a cada usuario
    @NotBlank(message = "El correo y contraseña no pueden etar vacíos")
    private Login login;

    @Enumerated(EnumType.STRING)
    private Rol_usuario rol_usuario;

    public enum Rol_usuario{
        ADMIN, CLIENTE
    }

    public String getLogin_correo(){
        return login.getCorreo();
    }
}
