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

import com.backend.lojavirtual.entities.Categoria;
import com.backend.lojavirtual.services.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listarTodos")
	public List<Categoria> listarCategorias(){
		return categoriaService.listarCategorias();
	}
	
	@PostMapping("/inserir")
	public Categoria inserir(@RequestBody Categoria categoria) {
		return categoriaService.inserir(categoria);
	}
	
	@PutMapping("/alterar")
	public Categoria alterar(@RequestBody Categoria categoria) {
		return categoriaService.alterar(categoria);
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		categoriaService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
