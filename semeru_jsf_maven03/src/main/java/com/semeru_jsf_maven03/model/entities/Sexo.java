
package com.semeru_jsf_maven03.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.ForeignKey;

/*
 * @author Emerson | 20/04/13
 * http://www.youtube.com/watch?v=vRcJJy8Ir5U
 */
@Entity
@Table(name="sexo")
public class Sexo implements Serializable{
    
     private static final long serialVersionUID = 1L;
     
     @Id
     @GeneratedValue
     @Column(name="IdSexo",  nullable=false)
     private Integer idSexo;
     @Column(name="Descricao", unique=true, nullable=false, length=9)
     private String descricao;
    
     
     @OneToMany(mappedBy = "sexo", fetch = FetchType.LAZY)
     @ForeignKey(name = "PessoaSexo")
     private List<Pessoa> pessoas;
     
     
     
     public Sexo(){
         
     }
     
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sexo other = (Sexo) obj;
        if (this.idSexo != other.idSexo && (this.idSexo == null || !this.idSexo.equals(other.idSexo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.idSexo != null ? this.idSexo.hashCode() : 0);
        return hash;
    }
     
    
     
}
