package Agenda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    private List<Compromisso> compromissos;
    private Scanner scanner;
    private static final String ARQUIVO = "agenda.txt";

    public Agenda() {
        compromissos = new ArrayList<>();
        scanner = new Scanner(System.in);
        carregarCompromissos();
    }

    public void adicionarCompromisso() {
        System.out.print("Digite a descrição do compromisso: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a data e hora do compromisso (dd/MM/yyyy HH:mm): ");
        String dataHoraStr = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        try {
            LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, formatter);
            Compromisso compromisso = new Compromisso(descricao, dataHora);
            compromissos.add(compromisso);
            salvarCompromissos();
            System.out.println("Compromisso adicionado com sucesso.");
        } catch (Exception e) {
            System.out.println("Data e hora inválidas. Tente novamente.");
        }
    }

    public void removerCompromisso() {
        listarCompromissos();
        System.out.print("Digite o número do compromisso a ser removido: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (numero > 0 && numero <= compromissos.size()) {
            compromissos.remove(numero - 1);
            salvarCompromissos();
            System.out.println("Compromisso removido com sucesso.");
        } else {
            System.out.println("Número de compromisso inválido.");
        }
    }

    public void listarCompromissos() {
        if (compromissos.isEmpty()) {
            System.out.println("Nenhum compromisso agendado.");
        } else {
            System.out.println("\n=== Lista de Compromissos ===");
            for (int i = 0; i < compromissos.size(); i++) {
                System.out.println((i + 1) + ". " + compromissos.get(i));
            }
        }
    }

    private void carregarCompromissos() {
        List<String> linhas = ArquivoUtil.lerLinhas(ARQUIVO);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        for (String linha : linhas) {
            String[] partes = linha.split(" - ");
            if (partes.length == 2) {
                String descricao = partes[0];
                LocalDateTime dataHora = LocalDateTime.parse(partes[1], formatter);
                compromissos.add(new Compromisso(descricao, dataHora));
            }
        }
    }

    private void salvarCompromissos() {
        List<String> linhas = new ArrayList<>();
        for (Compromisso compromisso : compromissos) {
            linhas.add(compromisso.toString());
        }
        ArquivoUtil.escreverLinhas(ARQUIVO, linhas);
    }
}
