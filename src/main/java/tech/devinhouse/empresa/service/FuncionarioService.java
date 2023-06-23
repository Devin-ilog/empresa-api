package tech.devinhouse.empresa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.empresa.exception.RegistroExistenteException;
import tech.devinhouse.empresa.model.Funcionario;
import tech.devinhouse.empresa.repository.FuncionarioRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repo;

    public List<Funcionario> consultar() {
        return repo.findAll();
    }

    public Funcionario inserir(Funcionario funcionario) {
        if (repo.existsById(funcionario.getCpf()))
            throw new RegistroExistenteException();
        return repo.save(funcionario);
    }

}
