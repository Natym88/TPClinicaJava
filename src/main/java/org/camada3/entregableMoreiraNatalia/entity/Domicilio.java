package org.camada3.entregableMoreiraNatalia.entity;

import javax.persistence.*;

@Entity
@Table( name = "domicilio")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String calle;
    private  int numero;
    private String dpto;
    private String ciudad;
    private String cp;
    @OneToOne(mappedBy = "domicilio")
    private Paciente paciente;
}
