package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.domain.User;
import br.ufscar.dc.dsw.dao.IUserDAO;
import br.ufscar.dc.dsw.service.spec.IUserService;

@Service
@Transactional(readOnly = false)
public class UserService implements IUserService {

	@Autowired
	IUserDAO dao;
	
	public void salvar(User u) {
		dao.save(u);
	}

}
