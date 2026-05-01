package com.example.demo.service;
import java.util.ArrayList;
import com.example.demo.modelos.Hora;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.repository.SalaRepository;
import com.example.demo.modelos.Hora;
import com.example.demo.modelos.Hueco;
import com.example.demo.modelos.Sala;
import com.example.demo.modelos.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Hueco_service {
    @Autowired
    SalaRepository salaRepository;

    public void escogerHueco(int id_sala, int id_hueco, Usuario user){
        Hueco hueco = controlarErrores(id_sala, id_hueco);
        user.incrementarReserva(hueco);
        hueco.cambiarEstado(true);
    }

    public void eliminarHueco(int id_sala, int id_hueco, Usuario user){
        //user.eliminarReserva(sala_service.searchById(id_sala).getHueco(id_hueco));
        Hueco hueco = controlarErrores(id_sala, id_hueco);
        user.eliminarReserva(hueco);
    }

    private Hueco controlarErrores(int a, int b){ //Metodo privado para el control de errores para no duplicar codigo
        Sala sala = salaRepository.searchById(a);
        if (sala == null){
            throw new RuntimeException("La sala no existe");
        }
        Hueco hueco = sala.getHueco(b);
        if (hueco == null){
            throw new RuntimeException("El hueco no existe");
        }
        return hueco;
   }

   public List<Hora> horasLibres(Hueco hueco){
        List<Hora> hora = hueco.getHoras();
        List<Hora> resultado = new ArrayList<>();
        Hora hora1;
        Hora hora2;
        Hora insertar = new Hora();
        int size = hora.size();
        if(size>0){
            int contador = 0;
            hora1 = hora.get(0);
            if(hora1.getHoraInicial()>9){
                insertar.setAll(9, hora1.getHoraInicial(), 0, hora1.getMinutoFinal());
                resultado.add(insertar);
            }
            contador ++;
            while(contador<size){
                hora2 = hora.get(contador);
                if(hora2.getHoraInicial()>hora1.getHoraFinal()){
                    insertar.setAll(hora1.getHoraFinal(), hora2.getHoraInicial(), hora1.getMinutoFinal(), hora2.getMinutoInicial());
                    resultado.add(insertar);
                }
                hora1 = hora2;
                contador++;
            }
            if(hora1.getHoraFinal()<22 || (hora1.getHoraFinal()==22 && hora1.getMinutoFinal()==0)){
                insertar.setAll(hora1.getHoraFinal(), 23, hora1.getMinutoFinal(), 0);
                resultado.add(insertar);
            }
        } else {
            insertar.setAll(9, 0, 23, 0);
            resultado.add(insertar);
        }

        return resultado;
    }
}
