package com.lp.examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lp.examen.model.Paciente;
import com.lp.examen.repository.PacienteRepository;
@Service
public class PacienteService implements SPaciente{
@Autowired
private PacienteRepository pacienteRepository;
	@Override
	public Paciente create(Paciente p) {
		// TODO Auto-generated method stub
		return pacienteRepository.save(p);
	}

	@Override
	public Paciente update(Paciente p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> readAll() {
		// TODO Auto-generated method stub
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente read(Long id) {
		// TODO Auto-generated method stub
		return pacienteRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pacienteRepository.deleteById(id);
		
	}
}