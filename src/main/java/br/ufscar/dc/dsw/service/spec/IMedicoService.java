package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.User;

public interface IMedicoService {

	Medico buscarPorId(Long id);
	
	List<Medico> buscarTodos();
	
	void salvar(Medico medico);
	
	void excluir(Long id);

	List<Medico> buscarPorEspecialidade(Medico.Especialidades especialidade);

}
