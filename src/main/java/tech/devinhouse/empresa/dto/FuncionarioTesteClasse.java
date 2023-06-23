package tech.devinhouse.empresa.dto;

import java.util.Objects;

public class FuncionarioTesteClasse {

    private Long cpf;

    private String nome;


    public FuncionarioTesteClasse(Long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuncionarioTesteClasse that = (FuncionarioTesteClasse) o;
        return Objects.equals(cpf, that.cpf) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome);
    }

    @Override
    public String toString() {
        return "FuncionarioTesteClasse{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                '}';
    }


    public Long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

}
