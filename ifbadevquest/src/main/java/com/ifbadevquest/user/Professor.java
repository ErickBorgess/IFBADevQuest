package com.ifbadevquest.user;

public class Professor implements Usuario {
    //to-do criar atributos específicos da classe Professor
    private String nome;
    private String tipo;

    public Professor(String nome) {
        this.nome = nome;
        this.tipo = "Professor";
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
