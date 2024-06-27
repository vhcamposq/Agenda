package Agenda;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Agenda ===");
            System.out.println("1. Adicionar Compromisso");
            System.out.println("2. Remover Compromisso");
            System.out.println("3. Listar Compromissos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcao) {
                case 1:
                    agenda.adicionarCompromisso();
                    break;
                case 2:
                    agenda.removerCompromisso();
                    break;
                case 3:
                    agenda.listarCompromissos();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
