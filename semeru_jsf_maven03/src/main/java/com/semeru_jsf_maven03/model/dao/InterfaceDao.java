/*
 * Emerson | 18/04/13
 * and open the template in the editor.
 */
package com.semeru_jsf_maven03.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

public interface InterfaceDao<T> {

    void save(T entity);
    void update(T entity);
    void remove(T entity);
    void marge(T entity);
    T getEntity(Serializable id);
    T getEntityByDetachedCriteria(DetachedCriteria criteria);
    List<T>getEntities();
    List<T>getListByDetachedCriteria(DetachedCriteria criteria);
    
}
