package com.ifbadevquest.history;

import com.ifbadevquest.user.Aluno;

public class AdicionarPontosComando implements Comando {
    private final Aluno aluno;
    private final int pontos;

    public AdicionarPontosComando(Aluno aluno, int pontos) {
        this.aluno = aluno;
        this.pontos = pontos;
    }

    @Override
    public void executar() {
        aluno.adicionarPontos(pontos);
        System.out.println("[COMANDO] " + pontos + " pontos adicionados a " + aluno.getNome());
    }

    @Override
     public void desfazer() {
        aluno.adicionarPontos(-pontos);
        System.out.println("[COMANDO] " + pontos + " pontos removidos de " + aluno.getNome());
    }
}
