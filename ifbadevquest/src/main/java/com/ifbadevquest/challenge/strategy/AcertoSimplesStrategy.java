package com.ifbadevquest.challenge.strategy;

import java.util.List;
import java.util.Map;
import com.ifbadevquest.challenge.ComponenteDesafio;
import com.ifbadevquest.challenge.ComponenteQuiz;
import com.ifbadevquest.challenge.Desafio;
import com.ifbadevquest.challenge.Questao;

public class AcertoSimplesStrategy implements PontuacaoStrategy {
    private final int PONTOS_POR_ACERTO = 10;

    @SuppressWarnings("unchecked")
    public int calcularPontos(Desafio desafio, Object resposta) {
        // Utilização de Map para representar as respostas do usuário
        if (!(resposta instanceof Map)) {
            return 0;
        }
        Map<Integer, String> respostasUsuario;
        try {
            respostasUsuario = (Map<Integer, String>) resposta;
        } catch (ClassCastException e) {
            return 0;
        }

        int pontosTotais = 0;

        for (ComponenteDesafio componente : desafio.getComponentes()) {
            if (componente instanceof ComponenteQuiz) {
                ComponenteQuiz quiz = (ComponenteQuiz) componente;
                List<Questao> questoes = quiz.getQuestoes();

                for (Map.Entry<Integer, String> respostaEntry : respostasUsuario.entrySet()) {
                    int indexQuestao = respostaEntry.getKey();
                    String respostaDada = respostaEntry.getValue();

                    if (indexQuestao >= 0 && indexQuestao < questoes.size()) {
                        Questao questaoCorrespondente = questoes.get(indexQuestao);

                        if (respostaDada.equalsIgnoreCase(questaoCorrespondente.getRespostaCorreta())) {
                            pontosTotais += PONTOS_POR_ACERTO;
                        }
                    }
                }
            }
        }
        return pontosTotais;
    }

}
