package com.br.projetoUTD.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.projetoUTD.repository.LivroRepository;
import com.projetoUTD.service.LivroService;

@Configuration
public class LivroConfig {

    @Autowired
    LivroRepository livroRepository;
    
    @Bean
    public LivroService livroService() {
        return new LivroService(livroRepository);
    }
}