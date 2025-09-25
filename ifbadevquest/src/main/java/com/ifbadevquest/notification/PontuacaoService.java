package com.ifbadevquest.notification;

import java.util.ArrayList;
import java.util.List;
import com.ifbadevquest.user.Usuario;

public class PontuacaoService {
    private final List<PontuacaoObserver> observers = new ArrayList<>();

    public void adicionarObserver(PontuacaoObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(PontuacaoObserver observer) {
        observers.remove(observer);
    }

    public void notificarObservers(Usuario usuario, int pontos) {
        for (PontuacaoObserver observer : observers) {
            observer.pontuacaoRecebida(usuario, pontos);
        }
    }
}
