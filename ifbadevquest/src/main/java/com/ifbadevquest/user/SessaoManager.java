package com.ifbadevquest.user;

public class SessaoManager {
    private static SessaoManager instancia;

    private SessaoManager() {
        // Construtor privado para evitar instância externa
    }

    public static SessaoManager getInstancia() {
        if (instancia == null) {
            instancia = new SessaoManager();
        }
        return instancia;
    }

    //adicionar método para login, logout e obter o usuário logado
}
