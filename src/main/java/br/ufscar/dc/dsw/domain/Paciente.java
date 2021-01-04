package br.ufscar.dc.dsw.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Paciente")
public class Paciente extends AbstractEntity<Long> {
    
    @NotBlank
    @Size(min = 6, max = 300, message = "{Size.email}")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(min = 6, max = 100, message = "{Size.password}")
    @Column(nullable = false, unique = false)
    private String senha;

    @NotBlank
    @Size(max = 30, message = "{Size.cpf}")
    @Column(nullable = false, unique = true)
    private String cpf;

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(nullable = false, unique = false)
    private String nome;

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(nullable = false, unique = false)
    private String telefone;

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(nullable = false, unique = false)
    private String sexo;

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(nullable = false, unique = false)
    private String data_de_nascimento;

    @ManyToMany
    @JoinTable(
      name = "paciente_consultas", 
      joinColumns = @JoinColumn(name = "paciente_id"), 
      inverseJoinColumns = @JoinColumn(name = "consulta_id")
    )
    Set<Consulta> consultas;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(String data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }
        
        
	
}
