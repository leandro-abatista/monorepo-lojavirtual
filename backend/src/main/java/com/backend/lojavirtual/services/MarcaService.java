package com.backend.lojavirtual.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.lojavirtual.entities.Marca;
import com.backend.lojavirtual.repositories.MarcaRepository;

@Service
public class MarcaService {

	@Autowired // injeção de dependência do spring
	private MarcaRepository marcaRepository;

	public List<Marca> listarMarcas() {
		return marcaRepository.findAll();
	}

	public Marca inserir(Marca marca) {
		marca.setDataCriacao(LocalDateTime.now());
		Marca mNovo = marcaRepository.saveAndFlush(marca);
		return mNovo;
	}

	public Marca alterar(Marca marca) {
		Marca marcaExistente = marcaRepository.findById(marca.getId()).get();
		LocalDateTime data = marcaExistente.getDataCriacao();
		marca.setDataCriacao(data);
		marca.setDataAtualizacao(LocalDateTime.now());
		Marca mAlterada = marcaRepository.saveAndFlush(marca);
		return mAlterada;
	}

	public void excluir(Long id) {
		Marca mExistente = marcaRepository.findById(id).get();
		marcaRepository.delete(mExistente);
	}
}
