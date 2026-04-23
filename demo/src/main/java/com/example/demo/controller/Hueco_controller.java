package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelos.Hueco;
import com.example.demo.modelos.Sala;
import com.example.demo.service.Sala_service;
import com.example.demo.modelos.Usuario;

@RestController
public class Hueco_controller{
    @Autowired
    private Sala sala;
    @Autowired
    private Hueco hueco;
    @Autowired
    private Sala_service sala_service;

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> escoger_hueco(@RequestParam int id_sala, @RequestParam int id_hueco, @RequestParam Usuario user){
        sala = sala_service.searchById(id_sala);
        hueco = sala.getHueco(id_hueco);
        try{
            if (!hueco.getEstado()){
            user.incrementarReserva(hueco);
            hueco.cambiarEstado(true);
            return ResponseEntity.ok(hueco);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este hueco ya esta escogido por alguien");
        }
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error desconocido");
        }
    }
}