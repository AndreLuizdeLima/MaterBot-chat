package org.materBot.servicos;


import org.materBot.entidades.Produto;
import org.materBot.entidades.Venda;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class RelatorioCSV {

    static String caminhoArquivo =   "Coloque o caminho para criar a pasta ex" +
            "C:\\Users\\bah\\Área de Trabalho\\pasta\\venda.csv";

    public static void gerarArquivo(Venda venda) {
        try (FileWriter arquivo = new FileWriter(caminhoArquivo, true)) {

            // adiciona cabeçalho se nao tiver nada no arquivo
            if (new java.io.File(caminhoArquivo).length() == 0) {
                arquivo.write("nome;data;valorTotal;\n");
            }

            // formata a data
            DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataFormatada = venda.getDataCompra().format(formatar);

            // dados da venda
            arquivo.write(String.format("%s;%s;%.2f;\n",
                    venda.getNomeComprador(),
                    dataFormatada,
                    venda.getValorTotal()));

            // dados dos produtos
            for (Produto p : venda.getProdutos()) {
                arquivo.write(String.format("%s;%d;%.2f\n",
                        p.getNome(),
                        p.getQuantidade(),
                        p.getCusto()));
            }

            // pula linha depois de inserir os dados
            arquivo.write("\n");

            System.out.println("Venda adicionada ao arquivo CSV: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao gerar arquivo CSV: " + e.getMessage());
        }
    }
}