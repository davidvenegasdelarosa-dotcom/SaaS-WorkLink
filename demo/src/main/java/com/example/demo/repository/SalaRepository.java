package com.example.demo.repository;
import com.example.demo.modelos.Hueco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Sala;
import java.util.List;

@Service
public interface SalaRepository extends JpaRepository <Sala, Long>{
    Sala searchById(long id); //Buscamos la sala según su id
}