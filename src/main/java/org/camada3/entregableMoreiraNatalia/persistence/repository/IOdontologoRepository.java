package org.camada3.entregableMoreiraNatalia.persistence.repository;

import org.camada3.entregableMoreiraNatalia.persistence.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface IOdontologoRepository extends JpaRepository <Odontologo, Integer> {

    @Query(value = "SELECT * FROM odontologo o WHERE o.apellido LIKE %?1%", nativeQuery = true)
    Set<Odontologo> buscarPorApellido ( String apellido);
}
