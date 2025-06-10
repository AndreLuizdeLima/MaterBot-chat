package org.materBot.servicos;


import org.materBot.entidades.Produto;
import org.materBot.entidades.Venda;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class GeraRelatorio {

    static String caminhoArquivo =   "C:\\Temp\\venda.csv";

    public static void gerarArquivo(Venda venda) {
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {  // true para modo append
            // Se o arquivo estiver vazio, escreve o cabeçalho
            if (new java.io.File(caminhoArquivo).length() == 0) {
                writer.write("nome;data;valorTotal;\n");
            }

            // Formata a data
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataFormatada = venda.getDataCompra().format(formatter);

            // Escreve os dados da venda
            writer.write(String.format("%s;%s;%.2f;\n",
                    venda.getNomeComprador(),
                    dataFormatada,
                    venda.getValorTotal()));

            // Escreve os produtos
            for (Produto produto : venda.getProdutos()) {
                writer.write(String.format("%s;%d;%.2f\n",
                        produto.getNome(),
                        produto.getQuantidade(),
                        produto.getCusto()));
            }

            // Adiciona linha em branco no final
            writer.write("\n");

            System.out.println("Venda adicionada ao arquivo CSV: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao gerar arquivo CSV: " + e.getMessage());
        }
    }
}
