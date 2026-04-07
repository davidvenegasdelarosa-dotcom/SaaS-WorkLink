package com.example.demo.repository;
import com.example.demo.modelos.Usuario;
import org.springframework.data.jpa.repository.Jparepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface bd_service extends Jparepository <Usuario, String>{
    boolean existsByCorreo(String correo); //Comprobamos si el correo esta en la base de datos
    boolean existsByCorreoAndPassword(String correo, String password); //Comprobamos si el correo y la contraseña son una tupla
}
