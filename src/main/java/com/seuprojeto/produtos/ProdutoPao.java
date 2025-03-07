package com.seuprojeto.produtos;

public class ProdutoPao extends ProdutosPanificadora {
    public ProdutoPao() {
        super();
    }

    public ProdutoPao(String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
    }

    public ProdutoPao(ProdutoPao outro) {
        super(outro);
    }

    @Override
    public String getDescricao() {
        return "Pao: " + getNome() + " - Preco: R$" + String.format("%.2f", getPreco());
    }
}