package br.ufscar.dc.dsw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ufscar.dc.dsw.dao.IMedicoDAO;
import br.ufscar.dc.dsw.dao.IPacienteDAO;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;

@SpringBootApplication
public class ConsultasMedicasMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultasMedicasMvcApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(IMedicoDAO medicoDAO, IPacienteDAO pacienteDAO) {
		return (args) -> {
						
			Medico m1 = new Medico();
			m1.setEmail("medico1@gmail.com");
			m1.setSenha("123123");
			m1.setCrm("23123-SP");
			m1.setNome("Carlos Alberto Albertinazzi");
			m1.setEspecialidade(0);
			medicoDAO.save(m1);
			
			m1 = new Medico();
			m1.setEmail("medico2@gmail.com");
			m1.setSenha("123123");
			m1.setCrm("12312-BA");
			m1.setNome("Mia Congratulis Silva");
			m1.setEspecialidade(1);
			medicoDAO.save(m1);
			
			m1 = new Medico();
			m1.setEmail("medico3@gmail.com");
			m1.setSenha("123123");
			m1.setCrm("542332-AC");
			m1.setNome("Van Shwartchz");
			m1.setEspecialidade(2);
			medicoDAO.save(m1);
			
			Paciente p = new Paciente();
			p.setEmail("paciente1@gmail.com");
			p.setSenha("123123");
			p.setCpf("3215421743");
			p.setNome("Gabriel Bortolote Pitarelli");
			p.setTelefone("19996076736");
			p.setDia(4);
			p.setMes(6);
			p.setAno(1998);
			p.setSexo(Paciente.Sexos.MASCULINO.ordinal());
			pacienteDAO.save(p);
			
			p = new Paciente();
			p.setEmail("paciente2@gmail.com");
			p.setSenha("123123");
			p.setCpf("342345321");
			p.setNome("Pedro Stone Rocha");
			p.setTelefone("99999999");
			p.setDia(5);
			p.setMes(7);
			p.setAno(2002);
			p.setSexo(Paciente.Sexos.OUTRO.ordinal());
			pacienteDAO.save(p);
			
			p = new Paciente();
			p.setEmail("paciente3@gmail.com");
			p.setSenha("123123");
			p.setCpf("1231231231'");
			p.setNome("Lara dos Santos");
			p.setTelefone("54542323");
			p.setDia(20);
			p.setMes(12);
			p.setAno(1885);
			p.setSexo(Paciente.Sexos.FEMENINO.ordinal());
			pacienteDAO.save(p);
		};
	}
}
