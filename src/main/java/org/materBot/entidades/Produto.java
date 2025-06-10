package org.materBot.entidades;

public class Produto {

    private String nome;
    private Double custo;
    private Integer quantidade;

    public Produto() {
    }

    public Produto(String nome, Double custo, Integer quantidade) {
        this.nome = nome;
        this.custo = custo;
        this.quantidade = quantidade;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", custo=" + custo +
                ", quantidade=" + quantidade +
                '}';
    }
}
