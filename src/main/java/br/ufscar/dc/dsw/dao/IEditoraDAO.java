package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Paciente;

@SuppressWarnings("unchecked")
public interface IEditoraDAO extends CrudRepository<Paciente, Long>{

	Paciente findById(long id);

	List<Paciente> findAll();
	
	Paciente save(Paciente editora);

	void deleteById(Long id);
}