package br.ufscar.dc.dsw.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import br.ufscar.dc.dsw.domain.Consulta;
 
@SuppressWarnings("unchecked")
public interface IConsultaDAO extends CrudRepository<Consulta, Long> {
 
    public List<Consulta> getByPacienteId(@Param("id") Long id);
    
    public List<Consulta> getByMedicoId(@Param("id") Long id);
    
	Consulta save(Consulta c);
	
	@Query("Select c from Consulta c inner join Medico m on c.medico = m.id where m.username = :email")
	public List<Consulta> findByMedicoEmail(@Param("email") String email);
}