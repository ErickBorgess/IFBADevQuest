package com.ifbadevquest.reporting;

import com.ifbadevquest.gamification.conquest.ConjuntoDeMedalhas;
import com.ifbadevquest.user.Aluno;
import com.ifbadevquest.user.Usuario;
import com.google.gson.Gson;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Relatorio {
    private static final String PASTA_RELATORIOS = "relatorios/";

    public Relatorio() {
        File diretorio = new File(PASTA_RELATORIOS);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }
    }

    public void gerarRelatorioDesempenho(Usuario usuario, String formato) {
        System.out.println("\n[FACADE] Gerando relatório para " + usuario.getNome() + " em " + formato + "...");

        try {
            DadosRelatorio dados = buscarDadosDoAluno(usuario);
            if (dados == null) return;

            String caminhoCompleto = PASTA_RELATORIOS;

            if ("CSV".equalsIgnoreCase(formato)) {
                GeradorCSV.gerar(caminhoCompleto, dados);
            } else if ("JSON".equalsIgnoreCase(formato)) {
                GeradorJSON.gerar(caminhoCompleto, dados);
            } else if ("PDF".equalsIgnoreCase(formato)) {
                GeradorPDF.gerar(caminhoCompleto, dados);
            } else {
                System.out.println("[RELATORIO] Formato não suportado: " + formato);
            }
        } catch (IOException e) {
            System.err.println("[RELATORIO] Erro ao gerar relatório: " + e.getMessage());
        }
    }

    private DadosRelatorio buscarDadosDoAluno(Usuario usuario) {
        if (usuario instanceof Aluno) {
            Aluno aluno = (Aluno) usuario;
            // Lógica para contar as medalhas
            int numMedalhas = contarMedalhas(aluno.getMuralDeConquistas());
            return new DadosRelatorio(aluno.getNome(), aluno.getPontosTotais(), numMedalhas);
        }
        return null;
    }

    private int contarMedalhas(ConjuntoDeMedalhas conjunto) {
        return conjunto.getConquistas().size();
    }
}

// --- Subsistemas de Geração de Arquivos ---

class GeradorCSV {
    public static void gerar(String caminho, DadosRelatorio dados) throws IOException {
        String nomeArquivo = caminho + "relatorio-" + dados.nomeJogador + ".csv";
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write("Chave: Valor\n");
            writer.write("Nome:" + dados.nomeJogador + "\n");
            writer.write("PontosTotais: " + dados.pontosTotais + "\n");
            writer.write("QuantidadeMedalhas: " + dados.totalMedalhas + "\n");
        }
        System.out.println("[Subsistema] Relatório " + nomeArquivo + " gerado com sucesso!");
    }
}

class GeradorJSON {
     public static void gerar(String caminho, DadosRelatorio dados) throws IOException {
        String nomeArquivo = caminho + "relatorio-" + dados.nomeJogador + ".json";
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            gson.toJson(dados, writer);
        }
        System.out.println("[Subsistema] Relatório " + nomeArquivo + " gerado com sucesso!");
     }
}

class GeradorPDF {
    public static void gerar(String caminho, DadosRelatorio dados) throws IOException {
        String nomeArquivo = caminho + "relatorio-" + dados.nomeJogador + ".pdf";
        PdfWriter writer = new PdfWriter(nomeArquivo);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        
        document.add(new Paragraph("Relatório de Desempenho - IFBADevQuest"));
        document.add(new Paragraph("Jogador: " + dados.nomeJogador));
        document.add(new Paragraph("Total de Pontos: " + dados.pontosTotais));
        document.add(new Paragraph("Total de Medalhas: " + dados.totalMedalhas));
        
        document.close();
        System.out.println("[Subsistema] Relatório " + nomeArquivo + " gerado com sucesso!");
    }
}
