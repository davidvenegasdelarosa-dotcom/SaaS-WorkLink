package com.example.demo.controller;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.Usuario_service;
import com.example.demo.modelos.Usuario;
import com.example.demo.modelos.Login;
import com.example.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody; 
import java.lang.String;

public class UsuarioController {
    @Autowired
    private UsuarioRepository usuario_repositorio;
    @Autoowired Usuario_service usuarioservice;
    @Autowired 
    private JwtService jwt;
    @Autowired
    private Login login;
    private String gmail = "@gmail.com";

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> iniciar_sesion(@RequestParam String correo, @RequestParam String password){
        login.setCorreo(correo).setPassword(password);
        usuarioservice.login(login);
        // IMPORTANTE CORREGIR PARA OBTENER ROL DE USER: String token = jwt.generateToken(correo, user.rol());
        return ResponseEntity.ok(token);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> crear_cuenta(@RequestParam String nombre, @RequestParam String correo, @RequestParam String password){
        try{
            if(!usuario_repositorio.existsByCorreo(usuario.getLogin_correo())){
                Usuario nuevo = usuario_repositorio.save(usuario);
                return ResponseEntity.status(HttpStatus.CONFLICT).body(nuevo);
            } if(((String) usuario.getLogin_correo).endsWith(gmail)){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo debe tener la extensión @gmail.com");
            }
            else return ResponseEntity.status(HttpStatus.CONFLICT).body("Este correo ya existe");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se ha producido un error desconocido");
        }
}

}
