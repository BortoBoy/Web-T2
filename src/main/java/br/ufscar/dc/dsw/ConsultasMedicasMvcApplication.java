package br.ufscar.dc.dsw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IConsultaDAO;
import br.ufscar.dc.dsw.dao.IMedicoDAO;
import br.ufscar.dc.dsw.dao.IPacienteDAO;
import br.ufscar.dc.dsw.dao.IUserDAO;
import br.ufscar.dc.dsw.domain.Consulta;
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
		IConsultaDAO consultaDAO,
		BCryptPasswordEncoder encoder
	) {
		return (args) -> {
						
			Medico m1 = new Medico();
			m1.setCrm("23123-SP");
			m1.setNome("Carlos Alberto Albertinazzi");
			m1.setEspecialidade(Medico.Especialidades.CIRURGIAO);
			m1.setUsername("medico1@email.com");
			m1.setPassword(encoder.encode("123123"));
			m1.setRole("ROLE_MEDICO");
			m1.setEnabled(true);
			medicoDAO.save(m1);
				
			Medico m2 = new Medico();
			m2.setCrm("12312-BA");
			m2.setNome("Mia Congratulis Silva");
			m2.setEspecialidade(Medico.Especialidades.PEDIATRA);
			m2.setUsername("medico2@email.com");
			m2.setPassword(encoder.encode("123123"));
			m2.setRole("ROLE_MEDICO");
			m2.setEnabled(true);
			medicoDAO.save(m2);
			
			Medico m3 = new Medico();
			m3.setCrm("542332-AC");
			m3.setNome("Van Shwartchz");
			m3.setEspecialidade(Medico.Especialidades.CURANDEIRO);
			m3.setUsername("medico3@email.com");
			m3.setPassword(encoder.encode("123123"));
			m3.setRole("ROLE_MEDICO");
			m3.setEnabled(true);
			medicoDAO.save(m3);
			
			
			Paciente p1 = new Paciente();
			p1.setCpf("3215421743");
			p1.setNome("Gabriel Bortolote Pitarelli");
			p1.setTelefone("19996076736");
			p1.setDia(4);
			p1.setMes(6);
			p1.setAno(1998);
			p1.setSexo(Paciente.Sexos.MASCULINO);
			p1.setUsername("paciente1@email.com");
			p1.setPassword(encoder.encode("123123"));
			p1.setRole("ROLE_PACIENTE");
			p1.setEnabled(true);
			pacienteDAO.save(p1);
			
			Paciente p2 = new Paciente();
			p2.setCpf("342345321");
			p2.setNome("Pedro Stone Rocha");
			p2.setTelefone("99999999");
			p2.setDia(5);
			p2.setMes(7);
			p2.setAno(2002);
			p2.setSexo(Paciente.Sexos.OUTRO);
			p2.setUsername("paciente2@email.com");
			p2.setPassword(encoder.encode("123123"));
			p2.setRole("ROLE_PACIENTE");
			p2.setEnabled(true);
			pacienteDAO.save(p2);

			Paciente p3 = new Paciente();
			p3.setCpf("1231231231");
			p3.setNome("Lara dos Santos");
			p3.setTelefone("54542323");
			p3.setDia(20);
			p3.setMes(12);
			p3.setAno(1885);
			p3.setSexo(Paciente.Sexos.FEMENINO);
			p3.setUsername("paciente3@email.com");
			p3.setPassword(encoder.encode("123123"));
			p3.setRole("ROLE_PACIENTE");
			p3.setEnabled(true);
			pacienteDAO.save(p3);
			
			User u = new User();
			u.setUsername("admin");
			u.setPassword(encoder.encode("admin"));
			u.setEnabled(true);
			u.setRole("ROLE_ADMIN");
			userDAO.save(u);
			
		};
	}
}
