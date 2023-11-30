package com.backend.lojavirtual.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.lojavirtual.entities.Categoria;
import com.backend.lojavirtual.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	/**
	 * Lista todas as categorias
	 * @return
	 */
	public List<Categoria> listarCategorias(){
		return categoriaRepository.findAll();
	}
	
	/**
	 * Inseri uma nova categoria
	 * @param categoria
	 * @return
	 */
	public Categoria inserir(Categoria categoria) {
		categoria.setDataCriacao(LocalDateTime.now());
		Categoria cNovo = categoriaRepository.saveAndFlush(categoria);
		return cNovo;
	}
	
	/**
	 * Atualiza uma categoria existente
	 * @param categoria
	 * @return
	 */
	public Categoria alterar(Categoria categoria) {
		Categoria categoriaExistente = categoriaRepository.findById(categoria.getId()).get();
		LocalDateTime data = categoriaExistente.getDataCriacao();
		categoria.setDataCriacao(data);
		categoria.setDataAtualizacao(LocalDateTime.now());
		Categoria cNovo = categoriaRepository.saveAndFlush(categoria);
		return cNovo;
	}
	
	/**
	 * Exclui uma categoria
	 * @param id
	 */
	public void excluir(Long id) {
		Categoria categoriaExistente = categoriaRepository.findById(id).get();
		categoriaRepository.delete(categoriaExistente);
	}
}
