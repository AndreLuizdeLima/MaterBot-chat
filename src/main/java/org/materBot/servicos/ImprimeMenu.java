package org.materBot.servicos;

import org.materBot.entidades.Produto;
import org.materBot.entidades.Venda;

import java.time.LocalDate;
import java.util.Scanner;

import static org.materBot.servicos.Compra.bebida;
import static org.materBot.servicos.Compra.salgado;
import static org.materBot.servicos.Compra.refeicao;
import static org.materBot.servicos.Login.login;

public class ImprimeMenu {
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        double preco = 0.0;
        String item = null;
        int quantidade;
        String resposta = null;

        System.out.print("Ola! Por favor, digite seu nome: ");
        String nome = scan.nextLine();

        Venda minhaVenda = new Venda();
        minhaVenda.setNomeComprador(nome);
        minhaVenda.setDataCompra(LocalDate.now());

        System.out.println("\nSeja bem-vindo(a), " + nome + "! Vamos ao cardapio:");

        do {
            int opcao = 0;
            do {
                System.out.println("""
                        \n╔════════════════════════════════╗
                        ║         MENU DE COMPRAS        ║
                        ╠════════════════════════════════╣
                        ║ 1 - Bebidas     (R$ 5,00)      ║
                        ║ 2 - Salgados    (R$ 6,00)      ║
                        ║ 3 - Refeicoes   (R$ 10,00)     ║
                        ║ 4 - Sair                       ║
                        ╚════════════════════════════════╝
                        """);
                System.out.print("Escolha uma opcao: ");
                opcao = scan.nextInt();
                scan.nextLine();

                if (opcao == 1) {
                    item = bebida();
                    preco = 5.0;
                } else if (opcao == 2) {
                    item = salgado();
                    preco = 6.0;
                } else if (opcao == 3) {
                    item = refeicao();
                    preco = 10.0;
                } else if (opcao == 4) {
                    System.exit(0);
                } else if (opcao == 88888) {
                    login();
                } else {
                    System.out.println("Opção inválida.");
                    System.out.println("Informe um número válido entre 1 e 3.");
                }
            } while (opcao <= 0 || opcao >= 5);

            do {
                System.out.print("Quantas unidades deseja? ");
                quantidade = scan.nextInt();
                if (quantidade <= 0) {
                    System.out.println("valor invalido");
                }
            } while (quantidade <= 0);

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

        RelatorioCSV.gerarArquivo(minhaVenda);
    }
}
