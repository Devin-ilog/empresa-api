package tech.devinhouse.empresa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.empresa.exception.RegistroNaoEncontradoException;
import tech.devinhouse.empresa.model.Departamento;
import tech.devinhouse.empresa.repository.DepartamentoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository repo;

    public List<Departamento> consultar() {
        return repo.findAll();
    }

    public Departamento consultar(String codigo) {
        return repo.findById(codigo)
                .orElseThrow(RegistroNaoEncontradoException::new);
    }

}
