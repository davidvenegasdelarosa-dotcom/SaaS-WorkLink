package com.example.demo.modelos;

public class Hora {
    int horaInicial;
    int minutoInicial;
    int horaFinal;
    int minutoFinal;
    
    public int getHoraInicial(){
        return this.horaInicial;
    }

    public int getHoraFinal(){
        return this.horaFinal;

    }
    
    public int getMinutoInicial(){
        return this.minutoInicial;

    }
    
    public int getMinutoFinal(){
        return this.minutoFinal;
    }
    
    public void setHoraInicial(int hora){
        this.horaInicial = hora;
    }

    public void setHoraFinal(int hora){
        this.horaFinal = hora;
    }

    public void setMinutoInicial(int minuto){
        this.minutoInicial = minuto;
    }

    public void setMinutoFinal(int minuto){
        this.minutoFinal = minuto;
    }
    
    public Hora setAll(int a, int b, int c, int d){
        this.setHoraInicial(a);
        this.setHoraFinal(b);
        this.setMinutoInicial(c);
        this.setMinutoFinal(d);
        return this;
    }

}
