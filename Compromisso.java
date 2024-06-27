package Agenda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compromisso {
    private String descricao;
    private LocalDateTime dataHora;

    public Compromisso(String descricao, LocalDateTime dataHora) {
        this.descricao = descricao;
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return descricao + " - " + dataHora.format(formatter);
    }
}

