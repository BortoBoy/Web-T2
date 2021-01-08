package br.ufscar.dc.dsw.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Medicos")
@PrimaryKeyJoinColumn(name = "user_id")
public class Medico extends User {
	public enum Especialidades {
	    CARDIOLOGISTA,
	    PEDIATRA,
	    GINECOLOGISTA,
	    CIRURGIAO,
	    OFTALMOLOGISTA,
	    CURANDEIRO
	}
    
    @NotBlank
    @Size(max = 30)
    @Column(nullable = false)
    private String crm;

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Especialidades especialidade;
    
    @ManyToMany
    @JoinTable(
      name = "medico_consultas", 
      joinColumns = @JoinColumn(name = "medico_id"), 
      inverseJoinColumns = @JoinColumn(name = "consulta_id")
    )
    Set<Consulta> consultas;

	public void setEspecialidade(Especialidades especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Especialidades getEspecialidade() {
		return especialidade;
	}

	public Set<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}
    
    
}
