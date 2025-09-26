package com.ifbadevquest.history;

import java.util.Stack;

public class HistoricoDeAcao {
    private final Stack<Comando> historico = new Stack<>();

    public void executarComando(Comando comando) {
        comando.executar();
        historico.push(comando);
    }

    public void desfazerUltimoComando() {
        if (!historico.isEmpty()) {
            Comando ultimoComando = historico.pop();
            ultimoComando.desfazer();
            System.out.println("[HISTÓRICO] Ação desfeita com sucesso.");
        } else {
            System.out.println("[HISTÓRICO] Nenhum comando para desfazer.");
        }
    }
}
