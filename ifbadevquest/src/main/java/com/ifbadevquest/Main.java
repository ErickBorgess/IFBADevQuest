package com.ifbadevquest;

import java.util.HashMap;
import java.util.Map;
import com.ifbadevquest.challenge.ComponenteQuiz;
import com.ifbadevquest.challenge.Desafio;
import com.ifbadevquest.challenge.Questao;
import com.ifbadevquest.challenge.strategy.AcertoSimplesStrategy;
import com.ifbadevquest.gamification.bonus.CalculadorDePontos;
import com.ifbadevquest.gamification.bonus.CalculadorDePontosBase;
import com.ifbadevquest.gamification.bonus.DoubleXPDecorator;
import com.ifbadevquest.notification.ConquistaObserver;
import com.ifbadevquest.notification.PontuacaoService;
import com.ifbadevquest.reporting.Relatorio;
import com.ifbadevquest.user.Aluno;
import com.ifbadevquest.user.Usuario;
import com.ifbadevquest.user.UsuarioFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INÍCIO DO TESTE INTEGRADO: IFBADevQuest ---");

        PontuacaoService pontuacaoService = new PontuacaoService();
        
        pontuacaoService.adicionarObserver(new ConquistaObserver());

        Usuario jogador = UsuarioFactory.criarUsuario("ALUNO", "Erick");
        System.out.println("Jogador " + jogador.getNome() + " do tipo " + jogador.getTipo() + " entrou no jogo.");

        // Montamos um desafio
        Desafio quizMatematica = new Desafio("Quiz de Matemática Básica");
        ComponenteQuiz componente = new ComponenteQuiz();
        componente.adicionarQuestao(new Questao("1 + 1 = ", "2"));
        componente.adicionarQuestao(new Questao("2 + 2 = ", "4"));
        quizMatematica.adicionarComponente(componente);
        quizMatematica.setPontuacaoStrategy(new AcertoSimplesStrategy());

        // Simula resposta do jogador ao desafio
        Map<Integer, String> respostas = new HashMap<>();
        respostas.put(0, "2");
        respostas.put(1, "4");
        
        // Calculo dos pontos base usando a Strategy
        int pontosBase = quizMatematica.calcularPontos(respostas);
        System.out.println("Pontos base calculados pela Strategy: " + pontosBase);

        // O sistema verifica se há bônus ativos
        CalculadorDePontos calculador = new CalculadorDePontosBase(pontosBase);
        // Decorator para aplicar o bônus
        calculador = new DoubleXPDecorator(calculador);
        int pontosFinais = calculador.calcularPontos();
        System.out.println("Pontos finais após bônus (Decorator): " + pontosFinais);

        // O serviço notifica todos os observers sobre a pontuação final
        System.out.println("\nNotificando observers sobre a pontuação final...");
        pontuacaoService.notificarObservers(jogador, pontosFinais);
        
        System.out.println("\n--- VERIFICANDO RESULTADO FINAL ---");
        // Exibimos o mural de conquistas do jogador para ver se ele ganhou a medalha
        if (jogador instanceof Aluno) {
            Aluno aluno = (Aluno) jogador;
            aluno.getMuralDeConquistas().exibir();
        }
        
        System.out.println("\n--- GERAÇÃO DE RELATÓRIOS ---");
        
        Relatorio relatorioService = new Relatorio();
        relatorioService.gerarRelatorioDesempenho(jogador, "CSV");
        relatorioService.gerarRelatorioDesempenho(jogador, "JSON");
        relatorioService.gerarRelatorioDesempenho(jogador, "PDF");
    }
}