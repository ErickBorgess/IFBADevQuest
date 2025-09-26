package com.ifbadevquest.reporting;

import com.ifbadevquest.reporting.api.RankingExternoAPI;
import com.ifbadevquest.user.Usuario;

public class RankingAdapter implements ServicoDeRanking {
    private final RankingExternoAPI rankingAPI = new RankingExternoAPI();

    @Override
    public void atualizarPontuacao(Usuario usuario, int pontos) {
        System.out.println("[ADAPTER] Adaptando e enviando dados para a API externa...");
        rankingAPI.enviarScore(usuario.getNome(), pontos);
    }
}
