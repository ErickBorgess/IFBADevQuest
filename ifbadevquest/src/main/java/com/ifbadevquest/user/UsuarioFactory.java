package com.ifbadevquest.user;

public class UsuarioFactory {
    public static Usuario criarUsuario(String tipo, String nome) {
        if ("ALUNO".equalsIgnoreCase(tipo)) {
            return new Aluno(nome);
        } else if ("PROFESSOR".equalsIgnoreCase(tipo)) {
            return new Professor(nome);
        } else if ("VISITANTE".equalsIgnoreCase(tipo)) {
            return new Visitante(nome);
        }
        throw new IllegalArgumentException("Tipo de usuário desconhecido: " + tipo);   
    }
}
