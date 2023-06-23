package tech.devinhouse.empresa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "FUNCIONARIOS")
public class Funcionario {

    @Id
    private Long cpf;

    private String nome;

    @ManyToOne
    @JoinColumn(name="cod_depto", referencedColumnName = "codigo")
    private Departamento departamento;

}
