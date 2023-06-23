package tech.devinhouse.empresa.dto;

import jakarta.validation.constraints.NotNull;

public record FuncionarioTesteRecord(
        Long cpf,
        @NotNull String nome
    ) {
}
