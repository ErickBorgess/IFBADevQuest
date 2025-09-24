package com.ifbadevquest.gamification;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoDeMedalhas implements ConquistaComponent {
    private final String nome;
    private final List<ConquistaComponent> conquistas = new ArrayList<>();

    public ConjuntoDeMedalhas(String nome) {
        this.nome = nome;
    }

    public void adicionar(ConquistaComponent conquista) {
        this.conquistas.add(conquista);
    }

    public void remover(ConquistaComponent conquista) {
        this.conquistas.remove(conquista);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void exibir() {
        System.out.println("Conjunto: " + getNome());
        for (ConquistaComponent conquista : conquistas) {
            conquista.exibir();
        }
    }
}
