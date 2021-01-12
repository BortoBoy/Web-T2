package br.ufscar.dc.dsw.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@SuppressWarnings("serial")
@Entity
@Table(name = "Consultas")
public class Consulta extends AbstractEntity<Long> {
    
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "medico_id", referencedColumnName = "id")
    private Medico medico;
    
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;
    
    @Min(1875)
	@Max(2021)
    private int ano;
    
    @Min(1)
	@Max(12)
    private int mes;
    
    @Min(1)
	@Max(31)
    private int dia;
    
    @Min(0)
	@Max(23)
    private int hora;
    
    @Min(0)
	@Max(59)
    private int minuto;

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

}
