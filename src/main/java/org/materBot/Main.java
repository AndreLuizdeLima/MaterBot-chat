package org.materBot;
import static org.materBot.servicos.ImprimeMenu.menu;
import static org.materBot.servicos.Relatorios.relatorio;
import static org.materBot.servicos.Relatorios.relatorioPorProduto;

public class Main {
    public static void main(String[] args) {
        relatorio();
        relatorioPorProduto();
        /*menu();*/
    }
}