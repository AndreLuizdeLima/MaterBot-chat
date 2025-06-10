package org.materBot.servicos;

import org.materBot.entidades.Produto;
import org.materBot.entidades.Venda;

import java.time.LocalDate;
import java.util.Scanner;

public class ImprimeMenu {
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        String item;
        double preco;
        int quantidade;
        String resposta = null;

        System.out.print("Ola! Por favor, digite seu nome: ");
        String nome = scan.nextLine();

        Venda minhaVenda = new Venda();
        minhaVenda.setNomeComprador(nome);
        minhaVenda.setDataCompra(LocalDate.now());

        System.out.println("\nSeja bem-vindo(a), " + nome + "! Vamos ao cardapio:");

        do {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║         MENU DE COMPRAS        ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1 - Bebidas     (R$ 5,00)      ║");
            System.out.println("║ 2 - Salgados    (R$ 6,00)      ║");
            System.out.println("║ 3 - Refeicoes   (R$ 10,00)     ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Escolha uma opcao: ");
            int opcao = scan.nextInt();
            scan.nextLine();

            item = "";
            preco = 0.0;

            switch (opcao) {
                case 1 -> {
                    System.out.println("\n-- Bebidas disponiveis --");
                    System.out.println("1 - Cafe preto");
                    System.out.println("2 - Cafe com leite");
                    System.out.print("Escolha sua bebida: ");
                    int escolha = scan.nextInt();
                    scan.nextLine();

                    if (escolha == 1) item = "Cafe preto";
                    else if (escolha == 2) item = "Cafe com leite";
                    else {
                        System.out.println("Opcao invalida.");
                        continue;
                    }
                    preco = 5.0;
                }

                case 2 -> {
                    System.out.println("\n-- Salgados disponiveis --");
                    System.out.println("1 - Coxinha");
                    System.out.println("2 - Pastel");
                    System.out.println("3 - Pao de queijo");
                    System.out.print("Escolha seu salgado: ");
                    int escolha = scan.nextInt();
                    scan.nextLine();

                    if (escolha == 1) item = "Coxinha";
                    else if (escolha == 2) item = "Pastel";
                    else if (escolha == 3) item = "Pao de queijo";
                    else {
                        System.out.println("Opcao invalida.");
                        continue;
                    }
                    preco = 6.0;
                }

                case 3 -> {
                    System.out.println("\n-- Refeicoes disponiveis --");
                    System.out.println("1 - Prato feito");
                    System.out.println("2 - Lasanha");
                    System.out.println("3 - Macarronada");
                    System.out.print("Escolha sua refeicao: ");
                    int escolha = scan.nextInt();
                    scan.nextLine();

                    if (escolha == 1) item = "Prato feito";
                    else if (escolha == 2) item = "Lasanha";
                    else if (escolha == 3) item = "Macarronada";
                    else {
                        System.out.println("Opcao invalida.");
                        continue;
                    }
                    preco = 10.0;
                }

                default -> {
                    System.out.println("Opcao invalida.");
                    continue;
                }
            }

            System.out.print("Quantas unidades deseja? ");
            quantidade = scan.nextInt();
            scan.nextLine();

            Produto produto = new Produto(item, preco, quantidade);
            minhaVenda.insertProduto(produto);

            double totalProduto = preco * quantidade;
            System.out.printf("Produto adicionado: %s - Quantidade: %d - Valor total: R$ %.2f\n", item, quantidade, totalProduto);

            System.out.print("Deseja comprar mais alguma coisa? (sim/nao): ");
            resposta = scan.nextLine().trim().toLowerCase();

            while (!resposta.equals("sim") && !resposta.equals("nao")) {
                System.out.print("Por favor, responda com 'sim' ou 'nao': ");
                resposta = scan.nextLine().trim().toLowerCase();
            }

        } while (resposta.equals("sim"));

        double totalCompra = minhaVenda.getValorTotal();

        System.out.println("\nPedido finalizado!");
        System.out.printf("Valor total da compra: R$ %.2f\n", totalCompra);
        System.out.println("\nResumo final do pedido:");
        System.out.println(minhaVenda);

        GeraRelatorio.gerarArquivo(minhaVenda);
    }
}
