package com.seuprojeto.produtos;

public class ProdutoBolo extends ProdutosPanificadora {

    public ProdutoBolo() {
        super();
    }

    public ProdutoBolo(String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
    }

    public ProdutoBolo(ProdutoBolo outro) {
        super(outro);
    }

    @Override
    public String getDescricao() {
        return "Bolo: " + getNome() + " - Preco: R$" + String.format("%.2f", getPreco());
    }
}
