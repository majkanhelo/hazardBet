 package edu.obymas.projekt.domain.dao.implement;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import edu.obymas.projekt.domain.dao.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    @Autowired
    protected EntityManager entityManager;

    private Class<T> type;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

	@Override
    public T create(final T t) {
 
        this.entityManager.getTransaction().begin();
		this.entityManager.persist(t);
		this.entityManager.getTransaction().commit();
		
        return t;
    }

    @Override
    public void delete(final Object id) {
    	this.entityManager.getTransaction().begin();
        this.entityManager.remove(this.entityManager.getReference(type, id));
        this.entityManager.getTransaction().commit();
    }

    @Override
    public T find(final Object id) {
        return (T) this.entityManager.find(type, id);
    }

    @Override
    public T update(final T t) {
    	this.entityManager.getTransaction().begin();
        T tmp=this.entityManager.merge(t);    
        this.entityManager.getTransaction().commit();
        
        return tmp;
    }
}