package com.seuprojeto.produtos;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<ProdutosPanificadora> produtos;

    public Estoque(){
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(ProdutosPanificadora produto){
        produtos.add(produto);
    }

    public void removerProduto(String nome) {
        produtos.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }

    public ProdutosPanificadora buscarProduto(String nome) {
        for (ProdutosPanificadora p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public List<ProdutosPanificadora> listarProdutos() {
        return produtos;
    }
}
