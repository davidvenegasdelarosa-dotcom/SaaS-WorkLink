package com.example.demo.modelos;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
@Entity
public class Hueco {

    @Id
    private int id;
    private LocalDate fecha;
    private List<Hora> hora;
    private boolean ocupado; //Si el hueco esta ocupado, será true, sinó falso.
    private Usuario user; //El usuario que hizo la reserva

    @ManyToOne
    @JoinColumn(name = "sala_id")
    Sala sala;

    public void cambiarEstado(boolean estado){
        ocupado = estado;
    }

    public List<Hora> getHoras(){
        return this.hora;
    }

    public boolean getEstado(){
        return ocupado;
    }

    public Usuario getUser(){
        return this.user;
    }

}
