package com.ifbadevquest.gamification.bonus;

public class CalculadorDePontosBase implements CalculadorDePontos {
    private final int pontosBase;

    public CalculadorDePontosBase(int pontosBase) {
        this.pontosBase = pontosBase;
    }
    
    @Override
    public int calcularPontos() {
        return pontosBase;
    }

}
