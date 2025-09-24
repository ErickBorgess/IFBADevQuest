package com.ifbadevquest.gamification;

public class Medalha implements ConquistaComponent {
    private String nome;

    public Medalha(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void exibir() {
        System.out.println("-> Medalha: " + getNome());
    }

}
