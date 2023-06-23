package tech.devinhouse.empresa;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.devinhouse.empresa.dto.FuncionarioRequest;
import tech.devinhouse.empresa.dto.FuncionarioResponse;
import tech.devinhouse.empresa.model.Departamento;
import tech.devinhouse.empresa.model.Funcionario;

@SpringBootApplication
public class EmpresaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaApiApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.typeMap(Funcionario.class, FuncionarioResponse.class).addMappings(mapper -> {
			mapper.map(src -> src.getDepartamento().getCodigo(),
					FuncionarioResponse::setCodigoDepartamento);
			mapper.map(src -> src.getDepartamento().getDescricao(),
					FuncionarioResponse::setNomeDepartamento);
		});
		modelMapper.typeMap(FuncionarioRequest.class, Funcionario.class).addMapping(
				src -> src.getCodigoDepartamento(), (dest, v) -> dest.setDepartamento(new Departamento((String)v, null)));
		return modelMapper;
	}

}
