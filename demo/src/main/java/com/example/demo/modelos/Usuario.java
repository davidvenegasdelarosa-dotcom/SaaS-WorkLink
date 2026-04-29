package com.example.demo.modelos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
@Entity
public class Usuario {

    private List<Hueco> reserva; //Las reservas será una lista de huecos no disponibles

    @NotBlank
    private String name;

    @Id //El correo es el que identifica a cada usuario
    @NotBlank(message = "El correo no puede estar vacío")
    private String correo;

    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public Object getLogin_correo;

    public enum Rol{
        ADMIN, CLIENTE
    }


    public void eliminarReserva(Hueco hueco){
        reserva.remove(hueco);
        hueco.cambiarEstado(false);
    }

    public Usuario setName(String name){
        this.name = name;
        return this;
    }

    public void incrementarReserva(Hueco hueco){
        reserva.add(hueco);
    }

    public void setPassword(String password){
        this.password=password;
    }

    public Usuario setCorreo(String correo){
        this.correo=correo;
        return this;
    }

    public String getCorreo(){
        return this.correo;
    }

    public String getRol(){
        return rol.toString();
    }
}
