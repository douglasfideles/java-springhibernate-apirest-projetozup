package br.com.zup.registerbank.controller;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.registerbank.controller.form.ContaPessoaForm;
import br.com.zup.registerbank.model.ContaPessoa;
import br.com.zup.registerbank.repository.ContaPessoaRepository;

@RestController
@RequestMapping("/contapessoa")
public class ContaPessoaController {
	
	@Autowired
	private ContaPessoaRepository pessoaRepository;
	
	@GetMapping
	public List<ContaPessoa> lista() {
		
		List<ContaPessoa> listaContaPessoa = pessoaRepository.findAll();
		
		return listaContaPessoa;
		
	}
	
	
	@PostMapping
	public ResponseEntity<ContaPessoa> cadastar(@RequestBody @Valid ContaPessoaForm form, UriComponentsBuilder uriBuilder) {
		
		ContaPessoa contaPessoa = form.converter();
		pessoaRepository.save(contaPessoa);
		
		URI uri = uriBuilder.path("/contapessoa/{id}").buildAndExpand(contaPessoa.getId()).toUri();
		
		
		
		return ResponseEntity.created(uri).body(contaPessoa);
		
		
		
	}
	
}
