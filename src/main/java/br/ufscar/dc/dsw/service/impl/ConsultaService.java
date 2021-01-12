package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IConsultaDAO;
import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.service.spec.IConsultaService;


@Service
@Transactional(readOnly = false)
public class ConsultaService implements IConsultaService {

	@Autowired
	IConsultaDAO dao;
	
//	@Override
//	public List<Consulta> buscarPorMedico(Long id) {
//		return dao.getByMedicoId(id);
//	}
//
//	@Override
//	public List<Consulta> buscarPorPaciente(Long id) {
//		return dao.getByPacienteId(id);
//	}

	@Override
	public void salvar(Consulta c) {
		dao.save(c);
	}

	@Override
	public List<Consulta> buscarPorMedicoEmail(String email) {
		return dao.findByMedicoEmail(email);
	}

}
