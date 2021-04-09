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

    @OneToOne(mappedBy = "doc", fetch = FetchType.LAZY)
    private DocProperties property;

}
 