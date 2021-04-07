package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Документ
 */
@Entity
@Table(name = "Doc")
public class Doc {
    @Id
    private Integer id;
    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "code", length = 10)
    private int code;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private DocProperties property;

}
