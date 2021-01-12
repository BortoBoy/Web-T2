package br.ufscar.dc.dsw.dao;

import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.User;
 
@SuppressWarnings("unchecked")
public interface IUserDAO extends CrudRepository<User, Long> {
    
	User findByUsername(String username);
	
	User save(User u);
}