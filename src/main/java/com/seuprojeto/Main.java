package com.seuprojeto;

import com.seuprojeto.produtos.Estoque;
import com.seuprojeto.produtos.ProdutoBolo;
import com.seuprojeto.produtos.ProdutoPao;
import com.seuprojeto.produtos.ProdutosPanificadora;
import com.seuprojeto.produtos.TipoProduto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Estoque estoque = new Estoque();
        VendasService vendasService = new VendasService(estoque);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto(estoque, scanner);
                    break;
                case 2:
                    listarProdutos(estoque);
                    break;
                case 3:
                    modificarProduto(estoque, scanner);
                    break;
                case 4:
                    removerProduto(estoque, scanner);
                    break;
                case 5:
                    realizarVenda(estoque, vendasService, scanner);
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- Menu Panificadora ---");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Listar Produtos");
        System.out.println("3. Modificar Produto");
        System.out.println("4. Remover Produto");
        System.out.println("5. Realizar Venda");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opçao: ");
    }

    private static void cadastrarProduto(Estoque estoque, Scanner scanner) {
        System.out.print("Tipo de produto (1 - Pão, 2 - Bolo): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        ProdutosPanificadora produto;
        if (tipo == 1) {
            produto = new ProdutoPao(nome, preco, quantidade);
        } else if (tipo == 2) {
            produto = new ProdutoBolo(nome, preco, quantidade);
        } else {
            System.out.println("Tipo inválido!");
            return;
        }
        estoque.adicionarProduto(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void listarProdutos(Estoque estoque) {

        System.out.println("\n--- Lista de Produtos ---");
        List<ProdutosPanificadora> produtos = estoque.listarProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (ProdutosPanificadora p : produtos) {
                System.out.println(p.getDescricao() + " - Quantidade: " + p.getQuantidade());
            }
        }
    }

    private static void modificarProduto(Estoque estoque, Scanner scanner) {

        System.out.print("Nome do produto a modificar: ");
        String nome = scanner.nextLine();
        ProdutosPanificadora produto = estoque.buscarProduto(nome);
        if (produto != null) {
            System.out.print("Novo nome (deixe em branco para manter): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                produto.setNome(novoNome);
            }
            System.out.print("Novo preco (deixe 0 para manter): ");
            double novoPreco = scanner.nextDouble();
            if (novoPreco > 0) {
                produto.setPreco(novoPreco);
            }
            System.out.print("Nova quantidade (deixe 0 para manter): ");
            int novaQuantidade = scanner.nextInt();
            if (novaQuantidade > 0) {
                produto.setQuantidade(novaQuantidade);
            }
            System.out.println("Produto modificado com sucesso!");
        } else {
            System.out.println("Produto nao encontrado!");
        }
    }

    private static void removerProduto(Estoque estoque, Scanner scanner) {

        System.out.println("Nome do produto a remover: ");
        String nome = scanner.nextLine();
        ProdutosPanificadora produto = estoque.buscarProduto(nome);
        if(produto != null) {
            estoque.removerProduto(nome);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto nao encontrado!");
        }
    }

    private static void realizarVenda(Estoque estoque, VendasService vendasService, Scanner scanner) {

        Map<ProdutosPanificadora, Integer> itens = new HashMap<>();
        while (true) {
            System.out.print("Nome do produto a vender (ou 'fim' para encerrar): ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("fim")) {
                break;
            }
            ProdutosPanificadora produto = estoque.buscarProduto(nome);
            if (produto != null) {
                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine();
                itens.put(produto, quantidade);
            } else {
                System.out.println("Produto nao encontrado!");
            }
        }
        try {
            vendasService.realizarVenda(itens);
            System.out.println(vendasService.gerarResumoVenda());
        } catch (Exception e) {
            System.out.println("Erro na venda: " + e.getMessage());
        }
    }
}