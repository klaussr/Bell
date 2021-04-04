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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "docNumber")
    private Long docNumber;

    @Column(name = "docName", length = 25)
    private String docName;

    @Column(name = "docDate")
    private Date docDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docNumber")
    private Doc doc;

    private List<DocProperties> docProperties;

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

    public Set<DocProperties> getDocProperties() {
        if (docProperties == null) {
            docProperties = new HashSet<>();
        }
        return docProperties;
    }

    public void addDocProperty(DocProperties docProperty) {
        getDocProperties().add(docProperty);
        docProperty.getDocProperties().add(this);
    }

    public void removeDocProperty(DocProperties docProperty) {
        getDocProperties().remove(docProperty);
        docProperty.getDocProperties().remove(this);
    }
}
