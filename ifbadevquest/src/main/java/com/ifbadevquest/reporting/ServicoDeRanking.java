package com.ifbadevquest.reporting;

import com.ifbadevquest.user.Usuario;

public interface ServicoDeRanking {
    void atualizarPontuacao(Usuario usuario, int pontos);
}
