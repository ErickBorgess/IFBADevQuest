package com.ifbadevquest.gamification.bonus;

public class StreakBonusDecorator extends PontosDecorator {
    private final int BONUS = 5;

    public StreakBonusDecorator(CalculadorDePontos calculadorBase) {
        super(calculadorBase);
    }

    @Override
    public int calcularPontos() {
        return calculadorBase.calcularPontos() + BONUS;
    }

}
