package com.ifbadevquest.reporting.api;

public class RankingExternoAPI {
    public void enviarScore(String idUsuario, int pontos) {
        System.out.println("[API EXTERNA] Score recebido para o usuário '" + idUsuario + "': " + pontos + " pontos.");
    }
}
