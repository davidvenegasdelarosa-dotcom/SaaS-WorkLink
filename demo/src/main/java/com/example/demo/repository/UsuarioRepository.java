package com.example.demo.repository;
import com.example.demo.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, String>{
    boolean existsByCorreo(String correo); //Comprobamos si el correo esta en la base de datos
    boolean existsByCorreoAndPassword(String correo, String password); //Comprobamos si el correo y la contraseña son una tupla
}
