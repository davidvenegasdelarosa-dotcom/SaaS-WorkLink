package com.example.demo.controller;
import com.example.demo.repository.UsuarioRepository;
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
    @Autowired 
    private JwtService jwt;
    private String gmail = "@gmail.com";

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> iniciar_sesion(@RequestBody Login login){
        if(!usuario_repositorio.existsByCorreo(login.getCorreo())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este correo no existe");
        } else if(!usuario_repositorio.existsByLogin(login)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("La contraseña es incorrecta");
        } else {
            String token = jwt.generateToken(login.getCorreo());
            return ResponseEntity.ok(token);
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> crear_cuenta(@RequestBody Usuario usuario){
        try{
            if(!usuario_repositorio.existsByCorreo(usuario.getLogin_Correo())){
                Usuario nuevo = usuario_repositorio.save(usuario);
                return ResponseEntity.status(HttpStatus.CONFLICT).body(nuevo);
            } if(usuario.getLogin_correo.endsWith(gmail)){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo debe tener la extensión @gmail.com");
            }
            else return ResponseEntity.status(HttpStatus.CONFLICT).body("Este correo ya existe");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se ha producido un error desconocido");
        }
}

}
