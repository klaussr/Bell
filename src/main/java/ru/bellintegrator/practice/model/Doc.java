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
    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "code", length = 10)
    private int code;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "docName")
    private List<DocProperties> docProperties;

    public List<DocProperties> getDocProperties() {
        if (docProperties == null) {
            docProperties = new ArrayList<>();
        }
        return docProperties;
    }

    public void addDocProperty(DocProperties docProperty) {
        getDocProperties().add(docProperty);
    }

    public void removeDocProperty(DocProperties docProperty) {
        getDocProperties().remove(docProperty);
    }
}
