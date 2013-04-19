
package com.semeru_jsf_maven03.util;

import javax.faces.context.FacesContext;
import org.hibernate.Session;


/*
 * @author Emerson | 18/04/13
 */
public class FacesContexUtil {
    
    private static final String HIBERNSTE_SESSION = "hibernate_session";
    
    public static void setRequestSession(Session session){
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNSTE_SESSION, session);
        
    }

    public static Session getRequestSession() {
        return (Session) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNSTE_SESSION);
    }

         
}
