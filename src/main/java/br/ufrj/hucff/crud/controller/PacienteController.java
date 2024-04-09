package br.ufrj.hucff.crud.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufrj.hucff.crud.modelo.Endereco;
import br.ufrj.hucff.crud.modelo.Paciente;
import br.ufrj.hucff.crud.modelo.Profissao;
import br.ufrj.hucff.crud.repository.PacienteRepository;
import br.ufrj.hucff.crud.repository.ProfissaoRepository;
import jakarta.validation.Valid;

@Controller
public class PacienteController {
	
	@Autowired
	PacienteRepository PacienteRepository;
	@Autowired
	ProfissaoRepository profissaoRepository;
	
	@RequestMapping("/")
	public String index(){
		return "index";
		
	}

	@RequestMapping("listapaciente")
	public String listaPaciente(Model model) {
		Iterable<Paciente> pacientes = PacienteRepository.findAll();
		Iterable<Profissao> profissoes = profissaoRepository.findAll();
		model.addAttribute("pacientes",pacientes);
		model.addAttribute("prof",profissoes);
		return "listapacientes";
	}
	
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("idade") Integer idade, @RequestParam("prontuarios") 
	String[] prontuarios ,@RequestParam("profissoes") List<Profissao> profissoes, @RequestParam Map<String,String> allParams, Model model) {
	    Integer numero = Integer.valueOf((allParams.get("numero")));
	    Integer cep = Integer.valueOf((allParams.get("cep")));
		Endereco endereco = new Endereco(allParams.get("rua"), numero, allParams.get("bairro"), cep);
		Paciente paciente = new Paciente(nome, idade, prontuarios, profissoes, endereco);
		PacienteRepository.save(paciente);
		Iterable<Paciente> pacientes = PacienteRepository.findAll();
		model.addAttribute("pacientes",pacientes);
		return "redirect:/listapaciente";
	}
	
	@GetMapping("apagarpaciente/{id}")
	public String apagarpaciente(@PathVariable("id") UUID id, Model model) {
		Paciente paciente = PacienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		PacienteRepository.delete(paciente);
		Iterable<Paciente> pacientes = PacienteRepository.findAll();
		model.addAttribute("pacientes",pacientes);
		return "redirect:/listapaciente";
	}
	
	@GetMapping("editarpaciente/{id}")
	public String editarpaciente(@PathVariable("id") UUID id, Model model) {
	    Paciente paciente = PacienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    model.addAttribute("paciente", paciente);
	    Iterable<Profissao> profissoes = profissaoRepository.findAll();
	    model.addAttribute("prof",profissoes);
	    return "carregarpacientes";
	}
	
	@PostMapping("/update/{id}")
	public String updatePaciente(@PathVariable("id") UUID id, @Valid Paciente paciente, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        paciente.setId(id);
	        return "update-user";
	    }
	    PacienteRepository.save(paciente);
	    Iterable<Paciente> pacientes = PacienteRepository.findAll();
		model.addAttribute("pacientes",pacientes);
		return "redirect:/listapaciente";
	}
}
