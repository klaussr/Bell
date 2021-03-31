package ru.bellintegrator.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Doc")
public class Doc {
    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "code", length = 10)
    private int code;
}
