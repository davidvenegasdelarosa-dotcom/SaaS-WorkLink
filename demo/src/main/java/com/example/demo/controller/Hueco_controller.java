package com.example.demo.controller;
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
    public ResponseEntity<?> escoger_hueco(@RequestParam long id_sala, @RequestParam long id_hueco){
        sala = sala_service.searchById(id_sala);
        
    }
}