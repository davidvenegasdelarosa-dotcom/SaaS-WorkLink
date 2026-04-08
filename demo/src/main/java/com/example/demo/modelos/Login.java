package com.example.demo.modelos;

public class Login {
    private String correo;
    private String password;
    public Login(){}
    public void setCorreo(String correo){
        this.correo=correo;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getCorreo(){
        return(this.correo);
    }

    public String getPassword(){
        return(this.password);
    }
}
