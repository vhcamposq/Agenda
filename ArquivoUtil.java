package Agenda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {
    public static List<String> lerLinhas(String caminho) {
        try {
            return Files.readAllLines(Paths.get(caminho));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void escreverLinhas(String caminho, List<String> linhas) {
        try {
            Files.write(Paths.get(caminho), linhas, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("Erro ao salvar compromissos: " + e.getMessage());
        }
    }
}
