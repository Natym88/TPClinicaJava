package org.camada3.entregableMoreiraNatalia.repository;

import org.camada3.entregableMoreiraNatalia.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
}
