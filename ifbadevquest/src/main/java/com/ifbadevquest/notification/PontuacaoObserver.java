package com.ifbadevquest.notification;

import com.ifbadevquest.user.Usuario;

public interface PontuacaoObserver {
    void pontuacaoRecebida(Usuario usuario, int pontos);
}
