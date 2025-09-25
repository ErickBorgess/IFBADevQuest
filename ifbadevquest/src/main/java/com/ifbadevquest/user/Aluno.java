package com.ifbadevquest.user;

import com.ifbadevquest.gamification.conquest.ConjuntoDeMedalhas;

public class Aluno implements Usuario {
    private String nome;
    private String tipo;
    private int pontosTotais;
    private final ConjuntoDeMedalhas muralDeConquistas = new ConjuntoDeMedalhas("Mural de Conquistas de " + nome);

    public Aluno(String nome) {
        this.nome = nome;
        this.tipo = "Aluno";
    }

    public void adicionarPontos(int pontos) {
        this.pontosTotais += pontos;
    }

    public ConjuntoDeMedalhas getMuralDeConquistas() {
        return muralDeConquistas;
    }

    public int getPontosTotais() {
        return pontosTotais;
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
