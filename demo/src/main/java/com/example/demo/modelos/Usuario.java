package com.example.demo.modelos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
@Entity
public class Usuario {

    private List<Hueco> reserva; //Las reservas será una lista de huecos no disponibles

    @NotBlank(message = "El nombre no puede esar vacío")
    private char nombre;

    @Id //El correo es el que identifica a cada usuario
    @NotBlank(message = "El correo y contraseña no pueden estar vacíos")
    private Login login;

    @Enumerated(EnumType.STRING)
    private Rol_usuario rol_usuario;

    public Object getLogin_correo;

    public enum Rol_usuario{
        ADMIN, CLIENTE
    }

    public Login getLogin(){
        return login;
    }

    public void incrementarReserva(Hueco hueco){
        reserva.add(hueco);
    }

    public String getLogin_correo(){
        return login.getCorreo();
    }

    public String getRol(){
        return rol_usuario.toString();
    }
}
