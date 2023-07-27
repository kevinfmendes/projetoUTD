package com.br.projetoUTD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.projetoUTD.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
