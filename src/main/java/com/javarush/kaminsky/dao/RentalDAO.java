package com.javarush.kaminsky.dao;

import com.javarush.kaminsky.domain.Rental;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class RentalDAO extends GenericDAO<Rental> {
    SessionFactory sessionFactory;

    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public Rental getAnyUnreturnedRental() {
        Query<Rental> query = sessionFactory.getCurrentSession().createQuery("select r from Rental r where r.returnDate is null", Rental.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
