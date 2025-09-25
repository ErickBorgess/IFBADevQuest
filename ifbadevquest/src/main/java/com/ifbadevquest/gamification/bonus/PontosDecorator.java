package com.ifbadevquest.gamification.bonus;

public abstract class PontosDecorator implements CalculadorDePontos {
    protected CalculadorDePontos calculadorBase;

    public PontosDecorator(CalculadorDePontos calculadorBase) {
        this.calculadorBase = calculadorBase;
    }

    @Override
    public int calcularPontos() {
        return calculadorBase.calcularPontos();
    }
}
