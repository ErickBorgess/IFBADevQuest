package com.ifbadevquest.challenge;

import java.util.ArrayList;
import java.util.List;

import com.ifbadevquest.challenge.strategy.PontuacaoStrategy;

public class Desafio {
    private final String titulo;
    private final List<ComponenteDesafio> componentes = new ArrayList<>();
    private final List<ComponenteQuiz> componentesQuiz = new ArrayList<>();
    private PontuacaoStrategy pontuacaoStrategy; 

    public Desafio(String titulo) {
        this.titulo = titulo;
    }

    public void adicionarComponente(ComponenteDesafio componente) {
        this.componentes.add(componente);
    }

    public List<ComponenteDesafio> getComponentes() {
        return componentes;
    }
    
    public void setPontuacaoStrategy(PontuacaoStrategy pontuacaoStrategy) {
        this.pontuacaoStrategy = pontuacaoStrategy;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public int calcularPontos(Object resposta) {
        if (pontuacaoStrategy == null) {
            throw new IllegalStateException("Estratégia de Pontuação nao foi definida!");
        }
        return pontuacaoStrategy.calcularPontos(this, resposta);
    }

    public void adicionarComponente(ComponenteQuiz componente) {
        this.componentesQuiz.add(componente);
    }

}
