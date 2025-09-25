package com.ifbadevquest.notification;

import com.ifbadevquest.gamification.conquest.Medalha;
import com.ifbadevquest.user.Aluno;
import com.ifbadevquest.user.Usuario;

public class ConquistaObserver implements PontuacaoObserver {
    
    
    @Override
    public void pontuacaoRecebida(Usuario usuario, int pontos) {
        if(usuario instanceof Aluno) {
            Aluno aluno = (Aluno) usuario;
            aluno.adicionarPontos(pontos);
            System.out.println("Aluno " + aluno.getNome() + " agora tem " + aluno.getPontosTotais() + " pontos.");

            if(aluno.getPontosTotais() >= 20) {
                aluno.getMuralDeConquistas().adicionar(new Medalha("Mestre dos Quizzes (+20 pontos)"));
                System.out.println("Nova Medalha Desbloqueada! " + aluno.getNome());
            }
        }
    }

}
