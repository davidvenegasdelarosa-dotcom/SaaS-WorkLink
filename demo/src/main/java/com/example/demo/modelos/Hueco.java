package com.example.demo.modelos;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
public class Hueco {

    private int id;
    private boolean ocupado; //Si el hueco esta ocupado, será true, sinó falso.

    @ManyToOne
    @JoinColumn(name = "sala_id")
    Sala sala;

    public void disponible_a_uso(){
        ocupado = true;
    }
}
