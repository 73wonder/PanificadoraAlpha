package com.seuprojeto.produtos;

public abstract class ProdutosPanificadora {
    private String nome;
    private double preco;
    private int quantidade;

    public ProdutosPanificadora(){
        this.nome = "Sem nome";
        this.preco = 0.0;
        this.quantidade = 0;
    }

    public ProdutosPanificadora(String nome, double preco, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public ProdutosPanificadora(ProdutosPanificadora outro) {
        this.nome = outro.nome;
        this.preco = outro.preco;
        this.quantidade = outro.quantidade;
    }

    public String getNome(){

        return nome;
    }

    public void setNome(String nome){

        this.nome = nome;
    }

    public double getPreco() {

        return preco;
    }

    public void setPreco(double preco) {

        this.preco = preco;
    }

    public int getQuantidade() {

        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public abstract String getDescricao();
}
