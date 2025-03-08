package com.seuprojeto;

import com.seuprojeto.produtos.ProdutosPanificadora;
import java.util.Map;

public interface Venda {

    void realizarVenda(Map<ProdutosPanificadora, Integer> itens) throws Exception;
    String gerarResumoVenda();
}
