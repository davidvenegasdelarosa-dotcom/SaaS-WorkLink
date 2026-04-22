package com.example.demo.service;
import com.example.demo.modelos.Hueco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.modelos.Sala;
import java.util.List;

@Service
public interface Sala_service extends JpaRepository <Sala, long>{
    Sala searchById(long id); //Buscamos la sala según su id
}