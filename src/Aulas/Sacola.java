package Aulas;

import java.util.Scanner;

public class Sacola {
    static String[] prods = { "Feijão", "Batata", "Alface", "Arroz" };
    static int[] sacola = new int[1000];
    static int[] quantidadeProds = new int[1000];
    static int qtde = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Screen.clear();

        int op = imprimeMenu();
        //System.out.println("VC digitou: " + op);

        while (op > 0) {

            if (op == 1) {
                imprimeProdutos();
                System.out.println("digite alguma tecla para continuar...");
                sc.nextLine();
            }

            if (op == 2) {
                imprimeSacola();
                System.out.println("digite alguma tecla para continuar...");
                sc.nextLine();
            }

            // Inserir item
            if (op == 3) {
                imprimeProdutos();
                System.out.println("Digite o número de um item:");
                int numero = sc.nextInt();
                sc.nextLine();

                System.out.println("Digite a quantidade de "+prods[numero]+" a ser adicionado à sacola:");
                int quantidade = sc.nextInt();
                sc.nextLine();

                System.out.println(quantidade+" unidades de "+prods[numero]+" foram adicionados à sacola.");

                sacola[qtde] = numero;
                quantidadeProds[qtde] = quantidade;
                qtde++;
                imprimeSacola();
            }

            // Remover item
            if (op == 4) {
                imprimeSacola();
                System.out.println("Digite o número de um item a ser removido:");
                int numero = sc.nextInt();
                sc.nextLine();

                for (int i = numero; i < qtde; i++) {
                    sacola[i] = sacola[i + 1];
                    quantidadeProds[i] = quantidadeProds[i + 13];
                }

                qtde--;
                imprimeSacola();
            }

            // Finalizar
            if (op == 5) {

            }

            Screen.clear();
            op = imprimeMenu();
        }
    }

    public static void imprimeProdutos() {
        System.out.println("\nPRODUTOS");
        System.out.println("=================");
        for (int i = 0; i < prods.length; i++) {
            System.out.println(i + " - " + prods[i]);
        }
    }

    public static void imprimeSacola() {
        System.out.println("\nPRODUTOS NA SACOLA");
        System.out.println("=================");
        if(qtde == 0) {
            System.out.println("sacola vazia....");
        }
        for (int i = 0; i < qtde; i++) {
            int codigo = sacola[i];
            System.out.println(i + " - " + prods[codigo] + "(x" + quantidadeProds[i] + ")");
        }
        System.out.println("=================");
    }

    public static int imprimeMenu() {
        Scanner sc = new Scanner(System.in);
        int op = -1;

        while (op < 0 || op > 5) {
            System.out.println("\nMENU");
            System.out.println("=================");
            System.out.println("[1] - LISTAR PRODUTOS");
            System.out.println("[2] - LISTAR SACOLA");
            System.out.println("[3] - INSERIR NA SACOLA");
            System.out.println("[4] - REMOVER ITEM DA SACOLA");
            System.out.println("[5] - FINALIZAR");
            System.out.println("[0] - SAIR");
            System.out.println("DIGITE UMA OPÇÃO:");
            op = sc.nextInt();
            sc.nextLine();

            if(op < 0 || op > 5) {
                Screen.clear();
                System.out.println("OPÇÃO INVÁLIDA!");
            }
        }
        return op;
    }
}