package com.semeru_jsf_maven03.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;
/*
 * @author Emerson 19/04/13
 * http://www.youtube.com/watch?v=ZghqMGl5KrE
 */
public class PhaseListenerSemeru implements PhaseListener{
   
    //antes de Fase
    @Override
    public void beforePhase(PhaseEvent fase) {
       if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
           System.out.println("Antes da fase " + fase.getPhaseId());
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContexUtil.setRequestSession(session);
       }
    }

    //depois da fase
    @Override
    public void afterPhase(PhaseEvent fase) {
        System.out.println("Depois da fase " + fase.getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            Session session = FacesContexUtil.getRequestSession();
            try{
              session.getTransaction().commit();  
            }catch(Exception e){
                if(session.getTransaction().isActive()){
                   session.getTransaction().rollback(); 
                }
            }finally{
               session.close();
        }
        }
 
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
