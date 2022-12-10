package org.camada3.entregableMoreiraNatalia.persistence.repository;

import org.camada3.entregableMoreiraNatalia.persistence.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
}
