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

    private String name;

    private int code;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private DocProperties property;

}
 