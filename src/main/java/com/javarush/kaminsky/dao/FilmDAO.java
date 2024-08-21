package com.javarush.kaminsky.dao;

import com.javarush.kaminsky.domain.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class FilmDAO extends GenericDAO<Film> {
    SessionFactory sessionFactory;

    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public Film getFirstAvailableFilmForRent() {
        Query<Film> query = sessionFactory.getCurrentSession().createQuery("select f from Film f " +
                "where f.filmId not in (select distinct film.filmId from Inventory)", Film.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
