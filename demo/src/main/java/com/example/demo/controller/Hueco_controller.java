package com.example.demo.controller;
import com.example.demo.modelos.Hueco;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;

@RestController
public class Hueco_controller {
    @Autowired
    private Hueco hueco;


}
