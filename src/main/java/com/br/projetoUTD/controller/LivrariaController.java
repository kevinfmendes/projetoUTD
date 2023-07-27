package com.br.projetoUTD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.projetoUTD.entity.Livro;
import com.projetoUTD.service.LivroService;

@Controller
public class LivrariaController {

	@Autowired
	private LivroService livroService;
	
	//metodo que carrega pagina inicial e exibe os livros
	@GetMapping("/")
	//aqui traz o Model model que eh basicamente o retorno do BD
	public String paginaInicial(Model model) {
		//crio a lista de livros pra exibir, livroService 
		List <Livro> livros = livroService.listarLivros();
		
		model.addAttribute("livros", livros);
		
		return "index";
	}
	
	//carregar a pagina de novo cadastro
	@GetMapping("/novo")
	public String novoLivro(Model model) {
		Livro livro = new Livro();
		model.addAttribute("livro", livro);
		return "cadastrar-livro";
	}
	
	//metodo que vai salvar POST
	@PostMapping("/salvar")
		public String salvarLivro(@ModelAttribute("livro") Livro livro) {
		
		livroService.adicionar(livro);
		
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editarLivro(@PathVariable("id") long id) {
		
		ModelAndView mav = new ModelAndView();
		Livro livro = livroService.editar(id);
		mav.setViewName("editar-cadastro-livro");
		mav.addObject("livro", livro);
		return mav;
	}
	
	@RequestMapping("/deletar/{id}")
	public String deletar(@PathVariable(name = "id") long id) {
		livroService.deletar(id);
		return "redirect:/";
	}
	
	
}
