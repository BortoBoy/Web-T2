package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Consulta;

public interface IConsultaService {
	
	void salvar(Consulta c);

	List<Consulta> buscarPorMedicoEmail(String email);
}
