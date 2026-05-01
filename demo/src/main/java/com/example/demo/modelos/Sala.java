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
    List<Hueco> huecos; //Una sala será, obviamente, una sucesión de huecos disponibles y en uso

    public List<Hueco> getListaHuecos(){
        return huecos;
    }

    public Hueco getHueco(int id_hueco){
        return huecos.get(id_hueco);
    }

    public List<Hueco> getHuecosLibresPorDia(){
        return this.huecos;
    }

    public void cambiar_estado(int id_hueco){
        huecos.get(id_hueco).cambiarEstado(true);
    }
}
