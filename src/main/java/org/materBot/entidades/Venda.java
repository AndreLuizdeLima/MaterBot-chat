package org.materBot.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private String nomeComprador;
    private List<Produto> produtos = new ArrayList<>();
    private LocalDate dataCompra;

    public Venda() {
    }

    public Venda(String nomeComprador, LocalDate dataCompra) {
        this.nomeComprador = nomeComprador;
        this.dataCompra = dataCompra;
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    public void setNomeComprador(String nomeComprador) {
        this.nomeComprador = nomeComprador;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Double getValorTotal() {
        double total = 0.0;
        if (produtos != null) {
            for (Produto p : produtos) {
                total += p.getCusto() * p.getQuantidade();
            }
        }
        return total;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public void insertProduto(Produto prod){
        produtos.add(prod);
    }

    public void removeProduto(Produto prod){
        produtos.remove(prod);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "nomeComprador='" + nomeComprador + '\'' +
                ", produtos=" + produtos +
                ", valorTotal=" +  getValorTotal() +
                ", dataCompra=" + dataCompra +
                '}';
    }
}
