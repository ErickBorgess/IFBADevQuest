package com.ifbadevquest.gamification.bonus;

public class DoubleXPDecorator extends PontosDecorator {

    public DoubleXPDecorator(CalculadorDePontos calculadorBase) {
        super(calculadorBase);
    }

    @Override
    public int calcularPontos() {
        return calculadorBase.calcularPontos() * 2;
    }

}
