package com.lp.examen.service;

import java.util.List;

import com.lp.examen.model.Paciente;

public interface SPaciente {
	Paciente create(Paciente p);
	Paciente update(Paciente p);
	List<Paciente> readAll();
	Paciente read(Long id);
	void delete (Long id);
}
