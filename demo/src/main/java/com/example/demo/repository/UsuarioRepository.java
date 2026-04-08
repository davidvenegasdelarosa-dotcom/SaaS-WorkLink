package com.example.demo.repository;
import com.example.demo.modelos.Usuario;
import com.example.demo.modelos.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Login>{
    boolean existsByCorreo(String correo); //Comprobamos si el correo esta en la base de datos
    boolean existsByLogin(Login login); //Comprobamos si el correo y la contraseña son una tupla
}
