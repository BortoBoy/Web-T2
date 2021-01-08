package br.ufscar.dc.dsw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IMedicoDAO;
import br.ufscar.dc.dsw.dao.IPacienteDAO;
import br.ufscar.dc.dsw.dao.IUserDAO;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.domain.User;

@SpringBootApplication
public class ConsultasMedicasMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultasMedicasMvcApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(
		IMedicoDAO medicoDAO,
		IPacienteDAO pacienteDAO,
		IUserDAO userDAO,
		BCryptPasswordEncoder encoder
	) {
		return (args) -> {
						
			Medico m = new Medico();
			m.setCrm("23123-SP");
			m.setNome("Carlos Alberto Albertinazzi");
			m.setEspecialidade(Medico.Especialidades.CIRURGIAO);
			m.setUsername("medico1@email.com");
			m.setPassword(encoder.encode("123123"));
			m.setRole("ROLE_MEDICO");
			m.setEnabled(true);
			medicoDAO.save(m);
				
			m = new Medico();
			m.setCrm("12312-BA");
			m.setNome("Mia Congratulis Silva");
			m.setEspecialidade(Medico.Especialidades.PEDIATRA);
			m.setUsername("medico2@email.com");
			m.setPassword(encoder.encode("123123"));
			m.setRole("ROLE_MEDICO");
			m.setEnabled(true);
			medicoDAO.save(m);
			
			m = new Medico();
			m.setCrm("542332-AC");
			m.setNome("Van Shwartchz");
			m.setEspecialidade(Medico.Especialidades.CURANDEIRO);
			m.setUsername("medico3@email.com");
			m.setPassword(encoder.encode("123123"));
			m.setRole("ROLE_MEDICO");
			m.setEnabled(true);
			medicoDAO.save(m);
			
			
			Paciente p = new Paciente();
			p.setCpf("3215421743");
			p.setNome("Gabriel Bortolote Pitarelli");
			p.setTelefone("19996076736");
			p.setDia(4);
			p.setMes(6);
			p.setAno(1998);
			p.setSexo(Paciente.Sexos.MASCULINO);
			p.setUsername("paciente1@email.com");
			p.setPassword(encoder.encode("123123"));
			p.setRole("ROLE_PACIENTE");
			p.setEnabled(true);
			pacienteDAO.save(p);
			
			p = new Paciente();
			p.setCpf("342345321");
			p.setNome("Pedro Stone Rocha");
			p.setTelefone("99999999");
			p.setDia(5);
			p.setMes(7);
			p.setAno(2002);
			p.setSexo(Paciente.Sexos.OUTRO);
			p.setUsername("paciente2@email.com");
			p.setPassword(encoder.encode("123123"));
			p.setRole("ROLE_PACIENTE");
			p.setEnabled(true);
			pacienteDAO.save(p);

			p = new Paciente();
			p.setCpf("1231231231");
			p.setNome("Lara dos Santos");
			p.setTelefone("54542323");
			p.setDia(20);
			p.setMes(12);
			p.setAno(1885);
			p.setSexo(Paciente.Sexos.FEMENINO);
			p.setUsername("paciente3@email.com");
			p.setPassword(encoder.encode("123123"));
			p.setRole("ROLE_PACIENTE");
			p.setEnabled(true);
			pacienteDAO.save(p);
			
			User u = new User();
			u.setUsername("admin");
			u.setPassword(encoder.encode("admin"));
			u.setEnabled(true);
			u.setRole("ROLE_ADMIN");
			userDAO.save(u);
			
		};
	}
}
