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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    private User user;
}
