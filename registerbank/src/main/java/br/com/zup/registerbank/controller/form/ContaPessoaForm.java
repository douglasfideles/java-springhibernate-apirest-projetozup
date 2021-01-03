package br.com.zup.registerbank.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

import com.sun.istack.NotNull;

import br.com.zup.registerbank.model.*;

public class ContaPessoaForm {

	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty @Email
	private String email;
	
	@NotNull @NotEmpty @CPF
	private String cpf;
	
	@NotNull @NotEmpty
	private String dataNasc;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public ContaPessoa converter() {
		
		return new ContaPessoa(nome,email,cpf, dataNasc);
	}
	
}
