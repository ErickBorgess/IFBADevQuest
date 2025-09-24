package com.ifbadevquest;

import java.util.HashMap;
import java.util.Map;

import com.ifbadevquest.challenge.ComponenteQuiz;
import com.ifbadevquest.challenge.Desafio;
import com.ifbadevquest.challenge.Questao;
import com.ifbadevquest.challenge.strategy.AcertoSimplesStrategy;

public class Main {
    public static void main(String[] args) {
        Desafio quizGeral = new Desafio("Quiz de Conhecimentos Gerais");
        
        ComponenteQuiz componente = new ComponenteQuiz();
        componente.adicionarQuestao(new Questao("1 + 1 = ", "2")); 
        componente.adicionarQuestao(new Questao("2 + 2 = ", "4"));
        
        quizGeral.adicionarComponente(componente);
        quizGeral.setPontuacaoStrategy(new AcertoSimplesStrategy());

        // Simular respostas com 2 acertos
        Map<Integer, String> respostasTudoCorreto = new HashMap<>();
        respostasTudoCorreto.put(0, "2");
        respostasTudoCorreto.put(1, "4");

        int pontosTotais = quizGeral.calcularPontos(respostasTudoCorreto);
        System.out.println("Pontos para 2 acertos: " + pontosTotais);

        // Simular respostas com 1 acerto e 1 erro
        Map<Integer, String> respostasParciais = new HashMap<>();
        respostasParciais.put(0, "3");
        respostasParciais.put(1, "4");

        int pontosParciais = quizGeral.calcularPontos(respostasParciais);
        System.out.println("Pontos para 1 acerto: " + pontosParciais);
    }
}