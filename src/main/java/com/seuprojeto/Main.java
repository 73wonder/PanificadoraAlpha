package com.seuprojeto;

import  com.seuprojeto.produtos.Estoque;
import com.seuprojeto.produtos.ProdutosPanificadora;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
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
        System.out.print("Escolha uma opção: ");
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
//            ProdutoPao();
        } else if (tipo == 2) {
//            ProdutoBolo();
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


}
