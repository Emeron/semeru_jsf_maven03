
package com.semeru_jsf_maven03.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 * @author Emerson | 21/04/13
 */
@Entity
@Table(name="endereco")
public class Endereco implements Serializable{
    
     private static final long serialVersionUID = 1L;
     
     @Id
     @Column(name="IdEndereco", nullable=false)
     private Integer IdEndereco;
     @Column(name="Bairro",length=80)
     private String bairro;
     @Column(name="NomeLogradouro",length=80)
     private String nomeLogradouro;
     @Column(name="CEP",length=9)
     private String cep;
     @Column(name="Numero")
     private String numero;
     @Column(name="Complemento")
     private String complemento;
     
     @OneToOne(optional=true, fetch= FetchType.LAZY)
     @ForeignKey(name="EnderecoPessoa")
     @JoinColumn(name="IdPessoa", referencedColumnName="IdPessoa")
     private Pessoa pessoa;
     
     @ManyToOne(optional=false, fetch= FetchType.LAZY)
     @ForeignKey(name="EnderecoTipoLogradouro") 
     @JoinColumn(name="IdTipoLogradouro", referencedColumnName="IdTipoLogradouro")
     private TipoLogradouro tipoLogradouro;
          
     @ManyToOne(optional=false, fetch = FetchType.LAZY)
     @ForeignKey(name="EnderecoEstado")  
     @JoinColumn(name="IdEstado", nullable=false)
     private Estado estado;
     
     @ManyToOne(optional=false, fetch = FetchType.LAZY)
     @ForeignKey(name="EnderecoTipoEndereco")  
     @JoinColumn(name="IdTipoEndereco", referencedColumnName="IdTipoEndereco")
     private TipoEndereco tipoendereco;
     
     @ManyToOne(optional=false, fetch = FetchType.LAZY)
     @ForeignKey(name="EnderecoCidade")  
     @JoinColumn(name="IdCidade", referencedColumnName="IdCidade")
     private Cidade cidade;
     
     
     @ManyToOne(optional=false, fetch= FetchType.LAZY)
     @ForeignKey(name="EnderecoTipoLogradouro") 
     @JoinColumn(name="IdTipoLogradouro", referencedColumnName="IdTipoLogradouro")
     private TipoLogradouro tipoEndereco; 
    
    
     
     
    public Endereco(){
        this.cidade = new Cidade();
        this.estado = new Estado();
        this.tipoLogradouro = new TipoLogradouro ();
        this.tipoEndereco = new TipoLogradouro();
        this.pessoa = new Pessoa();
    }

    public TipoLogradouro getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoLogradouro tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    
    
    public Integer getIdEndereco() {
        return IdEndereco;
    }

    public void setIdEndereco(Integer IdEndereco) {
        this.IdEndereco = IdEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoEndereco getTipoendereco() {
        return tipoendereco;
    }

    public void setTipoendereco(TipoEndereco tipoendereco) {
        this.tipoendereco = tipoendereco;
    }


    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (this.IdEndereco != other.IdEndereco && (this.IdEndereco == null || !this.IdEndereco.equals(other.IdEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.IdEndereco != null ? this.IdEndereco.hashCode() : 0);
        return hash;
    }
     
     
}
