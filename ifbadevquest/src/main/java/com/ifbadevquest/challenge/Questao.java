package com.ifbadevquest.challenge;

public class Questao {
    private final String enunciado;
    private final String respostaCorreta;

    public Questao(String enunciado, String respostaCorreta) {
        this.enunciado = enunciado;
        this.respostaCorreta = respostaCorreta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }
}
