package com.javarush.kaminsky.dao;

import com.javarush.kaminsky.domain.City;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class CityDAO extends GenericDAO<City> {
    private final SessionFactory sessionFactory;

    public CityDAO(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public City getByName(String name) {
        Query<City> query = sessionFactory.getCurrentSession().createQuery("select c from City c where c.city = :NAME", City.class);
        query.setParameter("NAME", name);
        return query.getSingleResult();

    }
}
