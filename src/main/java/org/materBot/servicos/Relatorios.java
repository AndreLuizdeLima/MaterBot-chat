package org.materBot.servicos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.materBot.servicos.RelatorioCSV.caminhoArquivo;

public class Relatorios {

    public static void relatorio() {
        double soma = 0;
        int contador = 0;

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            leitor.readLine();

            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.trim().endsWith(";")) {
                    String[] partes = linha.split(";");
                    if (partes.length == 3) {
                        try {
                            String valorFormatado = partes[2].replace(",", ".");
                            double valor = Double.parseDouble(valorFormatado);
                            soma += valor;
                            contador++;
                        } catch (NumberFormatException e) {
                            System.err.println("Erro ao converter valor: " + partes[2]);
                        }
                    }
                }
            }

            if (contador > 0) {
                System.out.println("\nResumo geral das vendas:");
                System.out.println("-----------------------------------------");
                System.out.printf("%-25s %10.2f\n", "Soma total das vendas: R$", soma);
                System.out.printf("%-25s %10.2f\n", "Média das vendas: R$", soma / contador);
                System.out.printf("%-25s %10d\n", "Total de vendas:", contador);
                System.out.println("-----------------------------------------");
            } else {
                System.out.println("Nenhuma venda encontrada.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void relatorioPorProduto() {
        Map<String, Double> valorTotalPorItem = new HashMap<>();
        Map<String, Integer> quantidadePorItem = new HashMap<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            leitor.readLine();

            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.trim().endsWith(";")) continue;

                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    String nomeProduto = partes[0];
                    int quantidade = Integer.parseInt(partes[1]);
                    double custo = Double.parseDouble(partes[2].replace(",", "."));

                    valorTotalPorItem.put(nomeProduto, valorTotalPorItem.getOrDefault(nomeProduto, 0.0) + (quantidade * custo));

                    quantidadePorItem.put(nomeProduto, quantidadePorItem.getOrDefault(nomeProduto, 0) + quantidade);
                }
            }

            if (valorTotalPorItem.isEmpty()) {
                System.out.println("Nenhum produto encontrado.");
            } else {
                System.out.println("\nResumo de vendas por produto:");
                System.out.printf("%-20s %10s %15s\n", "Produto", "Quantidade", "Valor Total");
                System.out.println("-----------------------------------------------------");
                for (String produto : valorTotalPorItem.keySet()) {
                    double valor = valorTotalPorItem.get(produto);
                    int qtd = quantidadePorItem.get(produto);
                    System.out.printf("%-20s %10d %15.2f\n", produto, qtd, valor);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        System.exit(0);
    }
}
