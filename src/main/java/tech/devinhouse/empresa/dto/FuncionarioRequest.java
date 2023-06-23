package tech.devinhouse.empresa.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FuncionarioRequest {

    @NotNull(message = "Campo obrigatório")
    private Long cpf;

    @NotEmpty(message = "Campo obrigatório")
    private String nome;

    @NotEmpty(message = "Campo obrigatório")
    private String codigoDepartamento;

}
