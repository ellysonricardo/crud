package br.ufrj.hucff.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufrj.hucff.crud.modelo.Profissao;
import br.ufrj.hucff.crud.repository.ProfissaoRepository;

@Controller
public class ProfissaoController {
	
	@Autowired
	ProfissaoRepository profissaoRepository;
	
	
	@RequestMapping("formprofissao")
	public String formProfissao() {
		return "formprofissao";
	}
	
	@RequestMapping(value = "salvarProf", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome) {
		Profissao profissao = new Profissao(nome);
		profissaoRepository.save(profissao);
		return "redirect:/formprofissao";
	}

}
