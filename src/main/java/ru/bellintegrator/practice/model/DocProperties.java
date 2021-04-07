package ru.bellintegrator.practice.model;

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
    private Integer id;

    @Column(name = "docNumber")
    private Long docNumber;

    @Column(name = "docName", length = 25)
    private String docName;

    @Column(name = "docDate")
    private Date docDate;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @OneToOne(mappedBy = "property", fetch = FetchType.LAZY, cascade =
            CascadeType.ALL, optional = false)
    private Doc doc;

    /**
     * Конструктор для hibernate
     */
    public DocProperties() {}

    public DocProperties(Long docNumber, String docName, Date docDate) {
        this.docNumber = docNumber;
        this.docName = docName;
        this.docDate = docDate;
    }

    public Long getDocNumber() {
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
