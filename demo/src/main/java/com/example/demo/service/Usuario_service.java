package com.example.demo.service;
import com.example.demo.repository.UsuarioRepository;
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

    public Usuario login(String correo, String password){
       try{
         if(!userRepository.existsByCorreo(correo)){
            throw new RuntimeException("El correo no existe");
        } else{
            if(!userRepository.existsByCorreoAndPassword(correo, password)){
                throw new RuntimeException("La contraseña es incorrecta");
            }
            //Si llega aqui entonces el inicio de sesion es exitoso
            return userRepository.findByCorreoAndPassword(correo, password);
        }
       } catch(Exception E){
        throw new RuntimeException("Ha ocurrido un error inesperado");
       }
    }

    public Usuario create(String name, String correo, String password){
        try{
            if(!correo.endsWith(gmail)){
                throw new RuntimeException("El correo debe terminar con @gmail.com");
            }
            if(userRepository.existsByCorreo(correo)){
                throw new RuntimeException("Este correo ya existe, prueba otro");
            } else {
                //Aqui meteria el usuario nuevo en la base de datos y luego lo llevaria al inicio de sesion de nuevo
                //Se le pone, por defecto, rol de cliente, no el admin
                Usuario user = new Usuario();
                user.setCorreo(correo).setName(name).setPassword(password);
                userRepository.save(user);
            }
        } catch(Exception e){
            throw new RuntimeException("Ha ocurrido un error inesperado");
        }
        return null;
    }
}
