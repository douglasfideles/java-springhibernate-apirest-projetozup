package br.com.zup.registerbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.registerbank.model.ContaPessoa;

public interface ContaPessoaRepository extends JpaRepository<ContaPessoa, Long>{

}
