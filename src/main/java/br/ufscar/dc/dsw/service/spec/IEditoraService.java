package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Paciente;

public interface IEditoraService {

	Paciente buscarPorId(Long id);

	List<Paciente> buscarTodos();

	void salvar(Paciente editora);

	void excluir(Long id);
	
	boolean editoraTemLivros(Long id);
}
