/*
 * Emerson | 17/04/13
 * and open the template in the editor.
 */
package com.semeru_jsf_maven03.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
  * @author maria
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static {
        try {
            System.err.println("Tentando configurar a Session Factory...");
            Configuration configuration = new Configuration().configure();
            
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
            applySettings(configuration.getProperties()).buildServiceRegistry();
            
           sessionFactory = configuration.buildSessionFactory(serviceRegistry);
           
           System.err.println("Session Factory criada com sucesso..." );
           // sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
