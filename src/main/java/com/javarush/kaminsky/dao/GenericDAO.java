package com.javarush.kaminsky.dao;

import jakarta.persistence.Query;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class GenericDAO<T> {
    private final Class<T> clazz;
    private SessionFactory sessionFactory;

    public GenericDAO(final Class<T> clazzToSet, SessionFactory sessionFactory) {
        this.clazz = clazzToSet;
        this.sessionFactory = sessionFactory;
    }

    public T getById(final Long id) {
        return (T) sessionFactory.getCurrentSession().get(clazz, id);
    }

    public List<T> getItems(int offset, int count) {
        Query query = sessionFactory.getCurrentSession().createQuery("from " + clazz.getName(), clazz);
        query.setFirstResult(offset);
        query.setMaxResults(count);
        return query.getResultList();
    }

    public List<T> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from " + clazz.getName(), clazz).list();
    }

    public T save(final T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    public T update(final T entity) {
        return (T) sessionFactory.getCurrentSession().merge(entity);
    }

    public void delete(final T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
