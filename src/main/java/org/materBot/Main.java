package org.materBot;

import org.materBot.entidades.Produto;
import org.materBot.entidades.Venda;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Venda minhaVenda = new Venda();
        Produto produto = new Produto("Pastel",2.0, 1);
        minhaVenda.setNomeComprador("Andre");
        minhaVenda.setDataCompra(LocalDate.now());
        minhaVenda.insertProduto(produto);
        minhaVenda.insertProduto(produto);
        minhaVenda.insertProduto(produto);
        System.out.println(minhaVenda);
    }
}