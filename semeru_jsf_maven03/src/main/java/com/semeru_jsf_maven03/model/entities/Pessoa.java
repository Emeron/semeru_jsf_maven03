
package com.semeru_jsf_maven03.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @author Emerson | 19/04/13
 * http://www.youtube.com/watch?v=0iRvh-whhBY
 */
@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue
    @Column(name="idPessoa", nullable=false)    
    private Integer idPessoa;
    @Column(name="Name", nullable=false, length=80)
    private String nome;    
     @Column(name="Email", nullable=false, length=80)
    private String email;   
     @Column(name="Telefone", nullable=false, length=15)//(034)-8888-8888
    private String telefone;
    @Column(name="CPF", nullable=false, length=14)
    private String cpf;
    @Column(name="DataNascimento", nullable=false, length=80)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Column(name="dataCadastro", nullable=false, length=80) 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;

    public Pessoa() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
        return hash;
    }
    
    
    
    
    
    
}
