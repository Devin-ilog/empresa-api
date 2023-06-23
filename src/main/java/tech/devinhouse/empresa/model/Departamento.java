package tech.devinhouse.empresa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "DEPARTAMENTOS")
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {

    @Id
    private String codigo;

    private String descricao;

}
