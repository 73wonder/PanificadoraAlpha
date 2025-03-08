package com.seuprojeto;

import com.seuprojeto.produtos.Estoque;
import com.seuprojeto.produtos.ProdutosPanificadora;
import java.util.Map;

public class VendasService implements Venda{

    private Estoque estoque;
    private Map<ProdutosPanificadora, Integer> itensVendidos;
    private double total;

    public VendasService(Estoque estoque) {
        this.estoque = estoque;
        this.total = 0.0;
    }

    @Override
    public void realizarVenda(Map<ProdutosPanificadora, Integer> itens) throws Exception {
        for(Map.Entry<ProdutosPanificadora, Integer> entry : itens.entrySet()) {
            ProdutosPanificadora produto = entry.getKey();
            int quantidadeVendida = entry.getValue();
            if(produto.getQuantidade() < quantidadeVendida) {
                throw new Exception("Estoque insficiente para " + produto.getNome());
            }
            produto.setQuantidade(produto.getQuantidade() - quantidadeVendida);
            total += produto.getPreco() * quantidadeVendida;
        }
        this.itensVendidos = itens;
    }

    @Override
    public String gerarResumoVenda() {
        StringBuilder resumo = new StringBuilder("Resumo da Venda:\n");
        for (Map.Entry<ProdutosPanificadora, Integer> entry : itensVendidos.entrySet()) {
            ProdutosPanificadora produto = entry.getKey();
            int quantidade = entry.getValue();
            resumo.append(produto.getDescricao())
                    .append(" - Quantidade: ")
                    .append(quantidade)
                    .append("\n");
        }
        resumo.append("Total: R$ ").append(String.format("%.2f", total));
        return resumo.toString();
    }
}
