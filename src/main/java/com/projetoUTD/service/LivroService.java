package com.projetoUTD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.br.projetoUTD.entity.Livro;
import com.br.projetoUTD.repository.LivroRepository;

@Component
@Service
public class LivroService {

	@Autowired
	LivroRepository repo;
	
	public LivroService(LivroRepository livroRepository) {
		// TODO Auto-generated constructor stub
	}

	public void adicionar(Livro livro) {
		
		repo.save(livro);
		
	}
	
	public List<Livro> listarLivros(){
		
		return repo.findAll();
		
	}
	
	public Livro editar(long id) {
		
		return repo.findById(id).get();
		
	}
	
	public void deletar (long id) {
		
		repo.deleteById(id);
		
	}
	
}
