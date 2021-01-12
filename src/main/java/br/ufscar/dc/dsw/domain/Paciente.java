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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;    

@SuppressWarnings("serial")
@Entity
@Table(name = "Pacientes")
@PrimaryKeyJoinColumn(name = "userId")
public class Paciente extends User {
    
	public enum Sexos {
	    MASCULINO,
	    FEMENINO,
	    OUTRO
	}
	
    @NotBlank
    @Size(max = 30)
    @Column(nullable = false, unique = true)
    private String cpf;

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexos sexo;

    @Min(1)
	@Max(31)
    private int dia;
    
    @Min(1)
	@Max(12)
    private int mes;
    
    @Min(1875)
	@Max(2021)
    private int ano;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Sexos getSexo() {
		return sexo;
	}

	public void setSexo(Sexos sexo) {
		this.sexo = sexo;
	}

	public int getDia() {
		return dia;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
