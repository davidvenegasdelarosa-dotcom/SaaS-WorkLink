package com.example.demo.controller;
import com.example.demo.modelos.Hueco;
import com.example.demo.modelos.Sala;
import com.example.demo.repository.SalaRepository;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;

@RestController
public class Sala_controller {
    @Autowired
    private Sala sala;
    @Autowired 
    private SalaRepository salaRepository;

    @GetMapping()
    public ResponseEntity<List<Hueco>> mostrar_lista_huecos(@PathVariable long id){
        sala = salaRepository.searchById(id);
        return ResponseEntity.ok(sala.getListaHuecos()); //Mostramos la lista de huecos de la sala (disponibles o no)
    }
}
