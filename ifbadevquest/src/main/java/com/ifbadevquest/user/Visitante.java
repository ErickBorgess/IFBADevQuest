package com.ifbadevquest.user;

public class Visitante implements Usuario {
    //to-do criar atributos específicos da classe Visitante
    private String nome;
    private String tipo;

    public Visitante(String nome) {
        this.nome = nome;
        this.tipo = "Visitante";
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
    
}
