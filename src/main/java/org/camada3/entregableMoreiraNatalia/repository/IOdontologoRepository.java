package org.camada3.entregableMoreiraNatalia.repository;

import org.camada3.entregableMoreiraNatalia.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface IOdontologoRepository extends JpaRepository <Odontologo, Integer> {

//    @Query("FROM odontologo o WHERE o.apellido LIKE %:apellido%")
//    Set<Odontologo> buscarPorApellido (@Param("apellido") String apellido);
}
