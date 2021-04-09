package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.util.List;

/**
 * Страна
 */
@Entity
@Table(name = "Countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int code;

    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<User> users;
}
