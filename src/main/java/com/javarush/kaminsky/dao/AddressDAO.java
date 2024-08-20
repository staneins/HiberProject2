package com.javarush.kaminsky.dao;

import com.javarush.kaminsky.domain.Address;
import org.hibernate.SessionFactory;

public class AddressDAO extends GenericDAO<Address> {
    public AddressDAO(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}
