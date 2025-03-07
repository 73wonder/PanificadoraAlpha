package com.seuprojeto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();
        } while (opcao != 6);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- Menu Panificadora---");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Listar Produtos");
        System.out.println("3. Modificar Produto");
        System.out.println("4. Remover Produto");
        System.out.println("5. Realizar Venda");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }
}
