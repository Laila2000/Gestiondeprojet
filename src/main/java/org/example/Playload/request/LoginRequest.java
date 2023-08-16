package org.example.Playload.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String nom;
    @NotBlank
    private String password;
    public String getusername(){
        return  nom;
    }
    public void setusername(String nom){
        this.nom=nom;

    }
    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
