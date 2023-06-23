package tech.devinhouse.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.empresa.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, String> {
}
