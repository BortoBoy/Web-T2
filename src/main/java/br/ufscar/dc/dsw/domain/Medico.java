package br.ufscar.dc.dsw.domain;

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
@Table(name = "Medico")
public class Medico extends AbstractEntity<Long> {
           
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
    private String crm;

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(nullable = false, unique = false)
    private String nome;

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(nullable = false, unique = false)
    private String especialidade;
    
    @ManyToMany
    @JoinTable(
      name = "medico_consultas", 
      joinColumns = @JoinColumn(name = "medico_id"), 
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }
    
    
    
}
