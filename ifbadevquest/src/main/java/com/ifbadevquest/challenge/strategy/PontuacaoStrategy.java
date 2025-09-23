package com.ifbadevquest.challenge.strategy;

import com.ifbadevquest.challenge.Desafio;

public interface PontuacaoStrategy {
    int calcularPontos(Desafio desafio, Object resposta);
}
