
package com.semeru_jsf_maven03.controle;

import com.semeru_jsf_maven03.model.dao.HibernateDao;
import com.semeru_jsf_maven03.model.dao.InterfaceDao;
import com.semeru_jsf_maven03.model.entities.Cidade;
import com.semeru_jsf_maven03.util.FacesContexUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 * @author Emerson | 25/04/13
 */

@ManagedBean(name="nbCidade")
@SessionScoped
public class NbCidade implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Cidade cidade = new Cidade();
    private List<Cidade>cidades;
    
    public NbCidade(){
        
    }
    
    private InterfaceDao<Cidade> cidadeDao(){
      
        InterfaceDao<Cidade> cidadeDao = new HibernateDao<Cidade>(Cidade.class, FacesContexUtil.getRequestSession());
        return cidadeDao;
        
    }
    
    
    public String limpCidade() {
       cidade = new Cidade(); 
       return "/restric/cadastrarcidade.faces";
    }     
    
    
    public String editCidade(){
        return "/restric/cadastrarcidade.faces";
    }
    public String addCidade(){
     if(cidade.getIdCidade() == null || cidade.getIdCidade() == 0){
         insertCidade();
     }else{
         updateCidade();
     }
     limpCidade(); 
     return null;
    }

    private void insertCidade() {
       cidadeDao().save(cidade);
       FacesContext.getCurrentInstance().addMessage(null,
          new FacesMessage(FacesMessage.SEVERITY_INFO,"Gravação efetuada com sucesso",""));
    }

    private void updateCidade() {
        cidadeDao().update(cidade);
        FacesContext.getCurrentInstance().addMessage(null,
          new FacesMessage(FacesMessage.SEVERITY_INFO,"Atualização efetuada com sucesso",""));
    }
   public void deleteCidade(){
       cidadeDao().remove(cidade);
   }

   public List<Cidade> getCidades() {
       cidades = cidadeDao().getEntities();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    
   
   
}
