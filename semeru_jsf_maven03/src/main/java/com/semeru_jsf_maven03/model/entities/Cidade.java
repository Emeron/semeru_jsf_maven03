
package com.semeru_jsf_maven03.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.ForeignKey;

/*
 * @author Emerson | 20/04/13
 * http://www.youtube.com/watch?v=vNfQSSI0rcI
 */

@Entity
@Table(name="cidade")
public class Cidade implements Serializable{
    
    private static final long serialVersionUID = 1L;
     
     @Id
     @GeneratedValue
     @Column(name="IdCidade",  nullable=false)
     private Integer idCidade;
     @Column(name="Nome", length=10 , nullable=false)
     private String nome;
     
     @OneToMany
     @ForeignKey(name="CidadeEndereco")
     private List<Endereco>enderecos;
     
     public Cidade(){
         
     }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.idCidade != other.idCidade && (this.idCidade == null || !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.idCidade != null ? this.idCidade.hashCode() : 0);
        return hash;
    }
     
     
}
