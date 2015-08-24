package edu.obymas.projekt.domain.dao;

/**
 * Generic interface for basic CRUD operation
 * @author michal
 *
 * @param <T> type of the object
 */
public interface GenericDao<T> {

    T create(T t);
    void delete(Object id);
    T find(Object id);
    T update(T t);   
    
}