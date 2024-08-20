package com.javarush.kaminsky.dao;

import com.javarush.kaminsky.domain.City;
import jakarta.persistence.Query;
import org.hibernate.SessionFactory;

public class CityDAO extends GenericDAO<City> {
    public CityDAO(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }

    public City getByName(String name) {
        Query<City> query = sessionFactory.getCurrentSession().createQuery("select c from City c where c.cityId = :NAME", City.class);
        query.setParameter("NAME", name);
        return query.getSingleResult();

    }
}
