package com.backend.lojavirtual.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.lojavirtual.entities.Estado;
import com.backend.lojavirtual.services.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	@GetMapping("/listarTodos")
	public List<Estado> listarEstados() {
		return estadoService.listarEstados();
	}

	@PostMapping("/inserir")
	public Estado inserir(@RequestBody Estado estado) {
		return estadoService.inserir(estado);
	}

	@PutMapping("/alterar")
	public Estado alterar(@RequestBody Estado estado) {
		return estadoService.alterar(estado);
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		estadoService.excluir(id);
		return ResponseEntity.ok().build();
	}

}
