package com.ifbadevquest.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.ifbadevquest.challenge.ComponenteDesafio;
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
import com.ifbadevquest.user.UsuarioFactory;
import java.util.List;

public class InterfaceUI {
    private final Scanner scanner;
    private final PontuacaoService pontuacaoService;
    private final Relatorio relatorio;
    private Aluno jogador;
    private Desafio desafioAtual;

    public InterfaceUI() {
        this.scanner = new Scanner(System.in);
        this.pontuacaoService = new PontuacaoService();
        this.pontuacaoService.adicionarObserver(new ConquistaObserver());
        this.relatorio = new Relatorio();
    }

    public void run() {
        System.out.println("Bem-vindo ao IFBADevQuest!");
        criarJogador();
        prepararDesafio();

        int opcao = -1;
        while (opcao != 0) {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    responderDesafio();
                    break;
                case 2:
                    verPerfil();
                    break;
                case 3:
                    gerarRelatorios();
                    break;
                case 0:
                    System.out.println("Obrigado por jogar! Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Responder ao Desafio: '" + desafioAtual.getTitulo() + "'");
        System.out.println("2. Ver Perfil e Conquistas");
        System.out.println("3. Gerar Relatórios");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void criarJogador() {
        System.out.print("Digite seu nome para começar: ");
        String nome = scanner.nextLine();
        this.jogador = (Aluno) UsuarioFactory.criarUsuario("ALUNO", nome);
        System.out.println("Olá, " + jogador.getNome() + "! Vamos começar.");
    }

    private void prepararDesafio() {
        // Prepara um desafio de exemplo para o jogador
        desafioAtual = new Desafio("Quiz de Matemática Básica");
        ComponenteQuiz componente = new ComponenteQuiz();
        componente.adicionarQuestao(new Questao("1 + 1 = ", "2"));
        componente.adicionarQuestao(new Questao("2 + 2 = ", "4"));
        desafioAtual.adicionarComponente(componente);
        desafioAtual.setPontuacaoStrategy(new AcertoSimplesStrategy());
    }

    private void responderDesafio() {
        System.out.println("\n--- Respondendo ao Desafio: " + desafioAtual.getTitulo() + " ---");
        Map<Integer, String> respostas = new HashMap<>();

        // Extrai o ComponenteQuiz para pegar as questões
        for (ComponenteDesafio comp : desafioAtual.getComponentes()) {
            if (comp instanceof ComponenteQuiz) {
                ComponenteQuiz quiz = (ComponenteQuiz) comp;
                List<Questao> questoes = quiz.getQuestoes();
                for (int i = 0; i < questoes.size(); i++) {
                    System.out.print("Questão " + (i + 1) + ": " + questoes.get(i).getEnunciado());
                    String resposta = scanner.nextLine();
                    respostas.put(i, resposta);
                }
            }
        }

        // Lógica de cálculo de pontos (Strategy e Decorator)
        int pontosBase = desafioAtual.calcularPontos(respostas);
        CalculadorDePontos calculador = new DoubleXPDecorator(new CalculadorDePontosBase(pontosBase));
        int pontosFinais = calculador.calcularPontos();

        System.out.println("Pontuação final do desafio: " + pontosFinais);

        // Notifica o Observer
        pontuacaoService.notificarObservers(jogador, pontosFinais);
    }

    private void verPerfil() {
        System.out.println("\n--- Perfil de " + jogador.getNome() + " ---");
        System.out.println("Pontos Totais: " + jogador.getPontosTotais());
        jogador.getMuralDeConquistas().exibir();
    }

    private void gerarRelatorios() {
        System.out.println("\n--- Geração de Relatórios ---");
        relatorio.gerarRelatorioDesempenho(jogador, "CSV");
        relatorio.gerarRelatorioDesempenho(jogador, "JSON");
        relatorio.gerarRelatorioDesempenho(jogador, "PDF");
        System.out.println("Relatórios gerados na pasta 'relatorios/'.");
    }
}
