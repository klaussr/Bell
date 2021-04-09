package ru.bellintegrator.practice.model;

import io.swagger.models.auth.In;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Свойства документов
 */
@Entity
@Table(name = "DocProperties")
public class DocProperties {
    @Id
    @Column(name = "userId")
    private Integer id;

    private Integer docId;

    private Integer docNumber;

    private String docName;

    private Date docDate;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade =
            CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId")
    private Doc doc;

    /**
     * Конструктор для hibernate
     */
    public DocProperties() {}

    public DocProperties(Integer docNumber, String docName, Date docDate) {
        this.docNumber = docNumber;
        this.docName = docName;
        this.docDate = docDate;
    }

    public Integer getDocNumber() {
        return docNumber;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Date getDocDate() {
        return docDate;
    }

    public Date setDocDate(Date docDate) {
        return this.docDate = docDate;
    }
}
