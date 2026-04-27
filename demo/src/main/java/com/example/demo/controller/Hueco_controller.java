package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.Hueco_service;

import com.example.demo.modelos.Hueco;
import com.example.demo.modelos.Sala;
import com.example.demo.service.Sala_service;
import com.example.demo.modelos.Usuario;

@RestController
public class Hueco_controller{
    @Autowired
    private Hueco hueco;
    @Autowired
    private Sala_service sala_service;
    @Autowired
    private Hueco_service hueco_service;

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> escoger_hueco(@RequestParam int id_sala, @RequestParam int id_hueco, @RequestParam Usuario user){
        try{
            hueco_service.escogerHueco( id_sala, id_hueco, user);
            return ResponseEntity.ok("La reserva se ha realizado exitosamente");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error desconocido");
        }
    }

    @DeleteMapping()
    @ResponseBody
    public ResponseEntity<?> eliminar_hueco(@RequestParam int id_sala, @RequestParam int id_hueco, @RequestParam Usuario user){
        try{
            hueco_service.eliminarHueco(id_sala, id_hueco, user);
            return ResponseEntity.ok("La eliminacion del hueco ha sido exitosa");

        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error desconocido");
        }

    }
}