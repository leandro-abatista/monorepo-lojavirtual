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

import com.backend.lojavirtual.entities.Marca;
import com.backend.lojavirtual.services.MarcaService;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;
	
	@GetMapping("/listarTodos")
	public List<Marca> listarMarcas(){
		return marcaService.listarMarcas();
	}
	
	@PostMapping("/inserir")
	public Marca inserir(@RequestBody Marca marca) {
		return marcaService.inserir(marca);
	}
	
	@PutMapping("/alterar")
	public Marca alterar(@RequestBody Marca marca) {
		return marcaService.alterar(marca);
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
		marcaService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
