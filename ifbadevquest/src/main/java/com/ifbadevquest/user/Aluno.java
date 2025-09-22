package com.ifbadevquest.user;

public class Aluno implements Usuario {
    //to-do criar atributos específicos da classe Aluno
    private String nome;
    private String tipo;

    public Aluno(String nome) {
        this.nome = nome;
        this.tipo = "Aluno";
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
