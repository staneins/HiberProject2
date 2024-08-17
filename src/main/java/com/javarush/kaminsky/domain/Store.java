package com.javarush.kaminsky.domain;

import jakarta.persistence.*;

@Entity
@Table(schema = "actor_base", name = "store")
public class Store {
    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte storeId;

    @OneToOne
    @JoinColumn(name = "manager_staff_id")
    private Staff staff;
}
