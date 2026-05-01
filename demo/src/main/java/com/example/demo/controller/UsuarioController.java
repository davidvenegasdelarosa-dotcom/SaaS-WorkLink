package com.example.demo.controller;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.Usuario_service;
import com.example.demo.modelos.Usuario;
import com.example.demo.modelos.Hueco;
import com.example.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class UsuarioController {
    @Autowired
    private UsuarioRepository usuario_repositorio;
    @Autowired 
    private Usuario_service usuarioservice;
    @Autowired 
    private JwtService jwt;
    @Autowired
    private Usuario user;
    private String gmail = "@gmail.com";

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> iniciar_sesion(@RequestParam String correo, @RequestParam String password){
        usuarioservice.login(correo, password);
        String token = jwt.generateToken(correo, user.getRol());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Usuario> crear_cuenta(@RequestParam String nombre, @RequestParam String correo, @RequestParam String password){
        Usuario user = usuarioservice.create(nombre, correo, password);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/MisReservas")
    @ResponseBody
    public ResponseEntity<List<Hueco>> mostrarReservas(@RequestParam Usuario user){
        return ResponseEntity.ok(user.getReservas());
    }

}
