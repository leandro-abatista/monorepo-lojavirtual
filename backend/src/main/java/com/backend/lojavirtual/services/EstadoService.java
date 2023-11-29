package com.backend.lojavirtual.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.InstantFormatter;
import org.springframework.stereotype.Service;

import com.backend.lojavirtual.entities.Estado;
import com.backend.lojavirtual.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired // injeção de dependência(o spring gerencia essas dependências
	private EstadoRepository estadoRepository;
	
	/**
	 * Lista todos os estados cadastrados no banco de dados
	 * @return
	 */
	public List<Estado> listarEstados(){
		return estadoRepository.findAll();
	}

	/**
	 * Inseri um novo estado no banco de dados
	 * @param estado
	 * @return
	 */
	public Estado inserir(Estado estado) {
		estado.setDataCriacao(LocalDateTime.now());
		Estado eNovo = estadoRepository.saveAndFlush(estado);
		return eNovo;
	}

	/**
	 * Atualiza um estado existente no banco de dados pelo id
	 * @param estado
	 * @return
	 */
	public Estado alterar(Estado estado) {
		estado.setDataAtualizacao(LocalDateTime.now());
		Estado eNovo = estadoRepository.saveAndFlush(estado);
		return eNovo;
	}

	/**
	 * Excluir um estado do banco de dados
	 * @param id
	 * @return
	 */
	public void excluir(Long id) {
		Estado eExistente = estadoRepository.findById(id).get();
		estadoRepository.delete(eExistente);
	}
}
