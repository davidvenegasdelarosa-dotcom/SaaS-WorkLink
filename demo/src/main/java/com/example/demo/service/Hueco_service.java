package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.modelos.Hueco;
import com.example.demo.modelos.Sala;
import com.example.demo.modelos.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Hueco_service {
    @Autowired
    Sala_service sala_service;

    public void escogerHueco(int id_sala, int id_hueco, Usuario user){
        Hueco hueco = controlarErrores(id_sala, id_hueco);
        user.incrementarReserva(hueco);
        hueco.cambiarEstado(true);
    }

    public void eliminarHueco(int id_sala, int id_hueco, Usuario user){
        //user.eliminarReserva(sala_service.searchById(id_sala).getHueco(id_hueco));
        Hueco hueco = controlarErrores(id_sala, id_hueco);
        user.eliminarReserva(hueco);
    }

    private Hueco controlarErrores(int a, int b){ //Metodo privado para el control de errores para no duplicar codigo
        Sala sala = sala_service.searchById(a);
        if (sala == null){
            throw new RuntimeException("La sala no existe");
        }
        Hueco hueco = sala.getHueco(b);
        if (hueco == null){
            throw new RuntimeException("El hueco no existe");
        }
        return hueco;
   }
}
