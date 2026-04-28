package com.example.demo.service;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.modelos.Login;
import com.example.demo.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.lang.String;

@Service
@Transactional
public class Usuario_service {
    @Autowired
    UsuarioRepository userRepository;
    @Autowired
    JwtService jwt;

    String gmail = "@gmail.com";

    public void login(Login login){
       try{
         if(!userRepository.existsByCorreo(login.getCorreo())){
            throw new RuntimeException("El correo no existe");
        } else{
            login.setCorreo(correo).setPassword(password);
            if(!userRepository.existsByLogin(login)){
                throw new RuntimeException("La contraseña es incorrecta");
            }
            //Si llega aqui entonces el inicio de sesion es exitoso
        }
       } catch(Exception E){
        throw new RuntimeException("Ha ocurrido un error inesperado");
       }
    }

    public void create(Usuario usuario){
        try{
            if(!usuario.getLogin_correo().endswith(gmail)){
                throw new RuntimeException("El correo debe terminar con @gmail.com");
            }
            if(userRepository.existsByCorreo(usuario.getLogin_correo())){
                throw new RuntimeException("Este correo ya existe, prueba otro");
            } else {
                //Aqui meteria el usuario nuevo en la base de datos y luego lo llevaria al inicio de sesion de nuevo
            }
        } catch(Exception e){
            throw new RuntimeException("Ha ocurrido un error inesperado");
        }
    }
}
