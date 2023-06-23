package tech.devinhouse.empresa.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.empresa.dto.DepartamentoResponse;
import tech.devinhouse.empresa.model.Departamento;
import tech.devinhouse.empresa.service.DepartamentoService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService service;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<DepartamentoResponse>> consultar() {
        List<Departamento> lista = service.consultar();
        List<DepartamentoResponse> resp = lista.stream().map(d -> mapper.map(d, DepartamentoResponse.class)).toList();
        return ResponseEntity.ok(resp);
    }

}
