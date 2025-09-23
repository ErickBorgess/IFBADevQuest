package com.ifbadevquest.challenge;

import java.util.ArrayList;
import java.util.List;

public class ComponenteQuiz {
    private final List<Questao> questoes = new ArrayList<>();

    public void adicionarQuestao(Questao questao) {
        this.questoes.add(questao);
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public String getTipo() {
        return "Quiz";
    }
}
