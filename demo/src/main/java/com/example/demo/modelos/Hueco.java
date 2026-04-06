package com.example.demo.modelos;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
public class Hueco {
    
    public enum Rol_hueco{
        DISPONIBLE, EN_USO
    }

    private Rol_hueco rol_hueco;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    Sala sala;
}
