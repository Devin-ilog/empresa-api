package tech.devinhouse.empresa.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.empresa.dto.FuncionarioRequest;
import tech.devinhouse.empresa.dto.FuncionarioResponse;
import tech.devinhouse.empresa.dto.FuncionarioTesteRecord;
import tech.devinhouse.empresa.model.Departamento;
import tech.devinhouse.empresa.model.Funcionario;
import tech.devinhouse.empresa.service.DepartamentoService;
import tech.devinhouse.empresa.service.FuncionarioService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    private final DepartamentoService departamentoService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<FuncionarioResponse>> consultar() {
        List<Funcionario> lista = funcionarioService.consultar();
        List<FuncionarioResponse> resp = lista.stream().map(d -> mapper.map(d, FuncionarioResponse.class)).toList();
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponse> inserir(@RequestBody @Valid FuncionarioRequest request) {
        Funcionario funcionario = mapper.map(request, Funcionario.class);
        Departamento depto = departamentoService.consultar(request.getCodigoDepartamento());
        funcionario.setDepartamento(depto);
//        funcionario.setDepartamento(new Departamento(request.getSiglaDepartamento(), null)); // configurado model mapper
        funcionario = funcionarioService.inserir(funcionario);
        FuncionarioResponse resp = mapper.map(funcionario, FuncionarioResponse.class);
        return ResponseEntity.created(URI.create(funcionario.getCpf().toString())).body(resp);
    }

    @GetMapping("/records")
    public ResponseEntity<List<FuncionarioTesteRecord>> consultarRecords() {
        List<Funcionario> lista = funcionarioService.consultar();
        List<FuncionarioTesteRecord> resp = lista.stream()
                .map(func -> new FuncionarioTesteRecord(func.getCpf(), func.getNome())).toList();
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/records")
    public ResponseEntity<FuncionarioTesteRecord> inserirRecord(@RequestBody @Valid FuncionarioTesteRecord request) {
        FuncionarioTesteRecord resp = new FuncionarioTesteRecord(request.cpf(), request.nome());
        return ResponseEntity.ok(resp);
    }

}
