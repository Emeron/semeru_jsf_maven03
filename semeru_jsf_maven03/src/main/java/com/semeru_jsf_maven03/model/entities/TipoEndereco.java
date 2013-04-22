
package com.semeru_jsf_maven03.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.ForeignKey;

/**
 *https://github.com/leandrocgsi/semeru_jsf_maven/tree/master/semeru_jsf_maven/src/main/java/br/com/semeru/model/entities
 * @author Emerson | 21/04
 */

@Entity
@Table(name="tipoendereco")
public class TipoEndereco implements Serializable{
    
     private static final long serialVersionUID = 1L;
     
     @Id
     @GeneratedValue
     @Column(name= "IdTipiEndereco", nullable=false)
     private Integer idTipoEndereco;
     @Column(name= "DescricaoTipiEndereco", nullable=false, length=35)
     private String descricaoTipiEndereco;
     
     @OneToMany(mappedBy = "tipoendereco", fetch = FetchType.LAZY)
     @ForeignKey(name="EnderecoTipoEndereco")
     private List<Endereco> enderecos;
     
     public TipoEndereco(){
         
     }

    public String getDescricaoTipiEndereco() {
        return descricaoTipiEndereco;
    }

    public void setDescricaoTipiEndereco(String descricaoTipiEndereco) {
        this.descricaoTipiEndereco = descricaoTipiEndereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Integer getIdTipoEndereco() {
        return idTipoEndereco;
    }

    public void setIdTipoEndereco(Integer idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoEndereco other = (TipoEndereco) obj;
        if (this.idTipoEndereco != other.idTipoEndereco && (this.idTipoEndereco == null || !this.idTipoEndereco.equals(other.idTipoEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.idTipoEndereco != null ? this.idTipoEndereco.hashCode() : 0);
        return hash;
    }
     
     
    
}
