/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.semeru_jsf_maven03.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author maria
 */

@Entity
@Table(name="tipoLogradouro")        
public class TipoLogradouro implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdTipoLogradouro", nullable=false)
    private Integer idTipoLogradouro;
    @Column(name="DescricaoTipoLogradouro", nullable=false, length=40)
    private String descricaoTipoLogradouro;
    
    @OneToMany(mappedBy="tipoLogradouro", fetch= FetchType.LAZY)
    @ForeignKey(name="EnderecoTipoLogradouro") 
    private List<Endereco> enderecos;
    
    public TipoLogradouro(){
        
    }

    public String getDescricaoTipoLogradouro() {
        return descricaoTipoLogradouro;
    }

    public void setDescricaoTipoLogradouro(String descricaoTipoLogradouro) {
        this.descricaoTipoLogradouro = descricaoTipoLogradouro;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Integer getIdTipoLogradouro() {
        return idTipoLogradouro;
    }

    public void setIdTipoLogradouro(Integer idTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (this.idTipoLogradouro != other.idTipoLogradouro && (this.idTipoLogradouro == null || !this.idTipoLogradouro.equals(other.idTipoLogradouro))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.idTipoLogradouro != null ? this.idTipoLogradouro.hashCode() : 0);
        return hash;
    }
    
    
    
    
    
}
