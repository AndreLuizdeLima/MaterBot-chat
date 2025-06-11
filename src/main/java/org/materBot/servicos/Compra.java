package org.materBot.servicos;

import java.util.Scanner;

public class Compra {
    public static String bebida() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n-- Bebidas disponiveis --");
        System.out.println("1 - Cafe preto");
        System.out.println("2 - Cafe com leite");
        System.out.print("Escolha sua bebida: ");
        int escolha = scan.nextInt();
        scan.nextLine();

        String item = null;
        if (escolha == 1) item = "Cafe preto";
        else if (escolha == 2) item = "Cafe com leite";
        else {
            System.out.println("Opcao invalida.");
        }
        return item;
    }

    public static String salgado() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n-- Salgados disponiveis --");
        System.out.println("1 - Coxinha");
        System.out.println("2 - Pastel");
        System.out.println("3 - Pao de queijo");
        System.out.print("Escolha seu salgado: ");
        int escolha = scan.nextInt();
        scan.nextLine();
        String item = null;
        if (escolha == 1) item = "Coxinha";
        else if (escolha == 2) item = "Pastel";
        else if (escolha == 3) item = "Pao de queijo";
        else {
            System.out.println("Opcao invalida.");
        }
        return item;
    }

    public static String refeicao() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n-- Refeicoes disponiveis --");
        System.out.println("1 - Prato feito");
        System.out.println("2 - Lasanha");
        System.out.println("3 - Macarronada");
        System.out.print("Escolha sua refeicao: ");
        int escolha = scan.nextInt();
        scan.nextLine();

        String item = null;
        if (escolha == 1) item = "Prato feito";
        else if (escolha == 2) item = "Lasanha";
        else if (escolha == 3) item = "Macarronada";
        else {
            System.out.println("Opcao invalida.");
        }
        return item;
    }
}
