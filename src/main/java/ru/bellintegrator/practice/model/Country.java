package ru.bellintegrator.practice.model;

import javax.persistence.*;

/**
 * Страна
 */
@Entity
@Table(name = "Country")
public class Country {
    @Id
    @Column(name = "code", length = 10)
    private int code;

    @Column(name = "name", length = 25)
    private String name;

    @OneToMany(mappedBy = "country", cascade = cascadeType.ALL, orphanRemoval = false)
    private List<User> users;
}
