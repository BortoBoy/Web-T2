package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Medico;

public interface ILivroService {

	Medico buscarPorId(Long id);
	
	List<Medico> buscarTodos();
	
	void salvar(Medico livro);
	
	void excluir(Long id);
	
}
