package com.example.demo.modelos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.OneToMany;
import java.util.List;
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "La sala debe ser de un tipo")
    private Rol_sala rol_sala;

    public enum Rol_sala{
        SILENCIO, NORMAL
    }

    @OneToMany(mappedBy = "sala")
    List<Hueco> huecos; //Una sala sera, obviamente, una sucesión de huecos disponibles y en uso
}
