package tech.devinhouse.empresa.dto;

import lombok.Data;

@Data
public class FuncionarioResponse {

    private Long cpf;

    private String nome;

    private String codigoDepartamento;

    private String nomeDepartamento;

}
