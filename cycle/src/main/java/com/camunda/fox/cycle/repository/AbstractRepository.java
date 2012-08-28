package com.camunda.fox.cycle.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.camunda.fox.cycle.entity.AbstractEntity;
import com.camunda.fox.cycle.util.ClassUtil;


/**
 * Abstract repository which holds the base information
 * 
 * @author nico.rehwaldt
 */
public class AbstractRepository<T extends AbstractEntity> {

  @PersistenceContext
  protected EntityManager em;
  
  private Class<T> entityClass;
  
  @SuppressWarnings("unchecked")
  protected AbstractRepository() {
    this.entityClass = (Class<T>) ClassUtil.extractParameterizedType(getClass());
  }
  
  /**
   * Save the given entity and flush
   * 
   * @return 
   */
  @Transactional
  public T saveAndFlush(T entity) {
    
    // Persist entity unless it exists
    if (!em.contains(entity)) {
      em.persist(entity);
    }
    
    em.flush();
    return entity;
  }

  /**
   * Delete a given entity by id
   * 
   * @return 
   */
  @Transactional
  public void delete(Long id) {
    T e = em.find(entityClass, id);
    if (e != null) {
      em.remove(e);
    }
  }
  
  /**
   * Delete a given entity from
   * 
   * @return 
   */
  @Transactional 
  public void delete(T entity) {
    if (em.contains(entity)) {
      em.remove(entity);
    } else {
      delete(entity.getId());
    }
  }
  
  /**
   * Find a given entity by id
   * 
   * @return 
   */
  public T findById(long id) {
    return em.find(entityClass, id);
  }
  
  /**
   * Find all entities
   * 
   * @return 
   */
  public List<T> findAll() {
    return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
  }
  
  /**
   * Delete all entities 
   * 
   * @return 
   */
  @Transactional
  public int deleteAll() {
    return em.createQuery("DELETE FROM " + entityClass.getSimpleName()).executeUpdate();
  }
}
