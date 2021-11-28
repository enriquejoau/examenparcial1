package com.lp.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lp.examen.model.Paciente;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
