/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividadeav1;

import java.util.Scanner;

/**
 *
 * @author 32617617
 */
public class Atividadeav1 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[][] poltronas = new int[6][8]; // 6 fileiras e 8 assentos
        int escolha;

        do {
            mostrarMenu();
            escolha = leitor.nextInt();

            switch (escolha) {
                case 1:
                    reservarAssento(leitor, poltronas);
                    break;
                case 2:
                    cancelarReserva(leitor, poltronas);
                    break;
                case 3:
                    exibirMapa(poltronas);
                    break;
                case 4:
                    mostrarEstatisticas(poltronas);
                    break;
                case 5:
                    System.out.println("Finalizando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 5);

        leitor.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1 - Reservar poltrona");
        System.out.println("2 - Liberar poltrona");
        System.out.println("3 - Mostrar mapa da sala");
        System.out.println("4 - Ver estatisticas");
        System.out.println("5 - Sair");
        System.out.print("Informe sua escolha: ");
    }

    public static void reservarAssento(Scanner leitor, int[][] sala) {
        System.out.print("Informe a fileira (1-6): ");
        int linha = leitor.nextInt();

        System.out.print("Informe o assento (1-8): ");
        int coluna = leitor.nextInt();

        if (valido(linha, coluna)) {
            if (sala[linha - 1][coluna - 1] == 0) {
                sala[linha - 1][coluna - 1] = 1;
                System.out.println("Poltrona reservada com sucesso!");
            } else {
                System.out.println("Assento indisponivel. Ja esta ocupado.");
            }
        } else {
            System.out.println("Posicao invalida.");
        }
    }

    public static void cancelarReserva(Scanner leitor, int[][] sala) {
        System.out.print("Informe a fileira (1-6): ");
        int linha = leitor.nextInt();

        System.out.print("Informe o assento (1-8): ");
        int coluna = leitor.nextInt();

        if (valido(linha, coluna)) {
            if (sala[linha - 1][coluna - 1] == 1) {
                sala[linha - 1][coluna - 1] = 0;
                System.out.println("Reserva removida!");
            } else {
                System.out.println("Assento ja está livre.");
            }
        } else {
            System.out.println("Posição invalida.");
        }
    }

    public static void exibirMapa(int[][] sala) {
        System.out.println("\n--- Mapa da sala ---");
        for (int l = 0; l < sala.length; l++) {
            System.out.print("Fileira " + (l + 1) + ": ");
            for (int c = 0; c < sala[l].length; c++) {
                System.out.print((sala[l][c] == 1 ? "[X]" : "[ ]") + " ");
            }
            System.out.println();
        }
    }

    public static void mostrarEstatisticas(int[][] sala) {
        int totalLivres = 0, totalOcupados = 0;
        int totalPoltronas = sala.length * sala[0].length;

        for (int[] fileira : sala) {
            for (int assento : fileira) {
                if (assento == 0)
                    totalLivres++;
                else
                    totalOcupados++;
            }
        }
        System.out.println("Total de assentos livres: " + totalLivres);
        System.out.println("Total de assentos ocupados: " + totalOcupados);
        System.out.printf("Percentual de ocupação: %.2f%%\n", (totalOcupados * 100.0) / totalPoltronas);
    }

    public static boolean valido(int linha, int coluna) {
        return linha >= 1 && linha <= 6 && coluna >= 1 && coluna <= 8;
    }
}