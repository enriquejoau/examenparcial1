package com.lp.examen.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp.examen.model.Paciente;
import com.lp.examen.service.PacienteService;

@RestController
@RequestMapping("/api")
public class PacienteController {
@Autowired
PacienteService pacienteService;

	@PostMapping("create")
	public ResponseEntity<Paciente> save(@RequestBody Paciente paciente) {
		try {
			Paciente p = pacienteService. create(new Paciente(paciente.getIdPaciente(), paciente.getDni(),paciente.getNombres(), paciente.getApellidos(), paciente.getDireccion(), paciente.getTelefono()));
			return new ResponseEntity<>(p, HttpStatus.CREATED);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/pacientes")
	public ResponseEntity<List<Paciente>> getAllPaciente(){
		try {
			List<Paciente> paciente = new ArrayList<Paciente>();
			paciente = pacienteService.readAll();
			if(paciente.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);				
			}
			return new ResponseEntity<>(paciente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
	}
	@GetMapping("/pacientes/{id}")
	public ResponseEntity<Paciente> getUser(@PathVariable("id") Long id){
		Paciente paciente = pacienteService.read(id);
			if(paciente.getIdPaciente()>0) {
				return new ResponseEntity<>(paciente, HttpStatus.OK);				
			}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
		try {
			pacienteService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Paciente> update(@RequestBody Paciente pa, @PathVariable("id") Long id){
		try {
			Paciente paciente = pacienteService.read(id);
			if(paciente.getIdPaciente()>0) {
				paciente.setDni(pa.getDni());
				paciente.setNombres(pa.getNombres());
				paciente.setApellidos(pa.getApellidos());
				paciente.setDireccion(pa.getDireccion());
				paciente.setTelefono(pa.getTelefono());
				return new ResponseEntity<>(pacienteService.create(paciente),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}

