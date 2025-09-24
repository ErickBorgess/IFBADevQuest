package com.ifbadevquest;

import java.util.HashMap;
import java.util.Map;

import com.ifbadevquest.challenge.ComponenteQuiz;
import com.ifbadevquest.challenge.Desafio;
import com.ifbadevquest.challenge.Questao;
import com.ifbadevquest.challenge.strategy.AcertoSimplesStrategy;
import com.ifbadevquest.gamification.ConjuntoDeMedalhas;
import com.ifbadevquest.gamification.Medalha;

public class Main {
    public static void main(String[] args) {
        /* ---TESTE CRIAÇÃO DE DESAFIO E CÁLCULO DE PONTOS ---
        Desafio quizGeral = new Desafio("Quiz de Conhecimentos Gerais");
        
        ComponenteQuiz componente = new ComponenteQuiz();
        componente.adicionarQuestao(new Questao("1 + 1 = ", "2")); 
        componente.adicionarQuestao(new Questao("2 + 2 = ", "4"));
        
        quizGeral.adicionarComponente(componente);
        quizGeral.setPontuacaoStrategy(new AcertoSimplesStrategy());

        // Simula respostas com 2 acertos
        Map<Integer, String> respostasTudoCorreto = new HashMap<>();
        respostasTudoCorreto.put(0, "2");
        respostasTudoCorreto.put(1, "4");

        int pontosTotais = quizGeral.calcularPontos(respostasTudoCorreto);
        System.out.println("Pontos para 2 acertos: " + pontosTotais);

        // Simula respostas com 1 acerto e 1 erro
        Map<Integer, String> respostasParciais = new HashMap<>();
        respostasParciais.put(0, "3");
        respostasParciais.put(1, "4");

        int pontosParciais = quizGeral.calcularPontos(respostasParciais);
        System.out.println("Pontos para 1 acerto: " + pontosParciais); */

        /* ---TESTE MEDALHAS E CONJUNTO  ---
        System.out.println("--- Teste de Medalhas e Conjuntos ---");

        // Cria as medalhas individuais
        Medalha m1 = new Medalha("Primeiro Desafio Concluído");
        Medalha m2 = new Medalha("Dez Quizzes Perfeitos");
        Medalha m3 = new Medalha("Velocista (Respondeu em menos de 1 minuto)");

        // Cria um conjunto para agrupar as medalhas de quiz
        ConjuntoDeMedalhas conjuntoQuizzes = new ConjuntoDeMedalhas("Conquistas de Quiz");
        conjuntoQuizzes.adicionar(m1);
        conjuntoQuizzes.adicionar(m2);

        // Cria o conjunto principal que representa todas as conquistas do aluno
        ConjuntoDeMedalhas totalConquistas = new ConjuntoDeMedalhas("Mural de Conquistas do Aluno");
        
        // Adiciona o conjunto de quizzes e uma medalha individual ao conjunto principal
        totalConquistas.adicionar(conjuntoQuizzes);
        totalConquistas.adicionar(m3);

        // ExibE tudo com uma única chamada
        totalConquistas.exibir(); */
    }
}