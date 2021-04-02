package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Пользователь
 */
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officeId")
    private Long id;

    @Column(name = "firstName", length = 25)
    private String firstName;

    @Column(name = "lastName", length = 25)
    private String lastName;

    @Column(name = "middleName", length = 25)
    private String middleName;

    @Column(name = "position", length = 25)
    private String position;

    @Column(name = "docCode", length = 15)
    private int docCode;

    @Column(name = "citizenshipCode", length = 5)
    private int citizenshipCode;

    @Column(name = "isIdentified", length = 10)
    private boolean isIdentified;

    @OneToMany(cascade =
            CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "docNumber")
    private List<DocProperties> properties;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private DocProperties docProperties;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Country country;

    /**
     * Конструктор для hibernate
     */
    public User() {}

    public User(Long id, String firstName, String lastName, String middleName, String position,  int docCode, int citizenshipCode, boolean isIdentified) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.docCode = docCode;
        this.citizenshipCode = citizenshipCode;
        isIdentified = true;
    }

    public Long getId() {
        return id;
    }

    public String getFirstNameName() {
        return firstName;
    }

    public void setFirstNameName(String firstName) {
        this.firstName = firstName;
    }

    public String  getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String  getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String  getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDocCode() { return docCode; }

    public void setDocCode(int docCode) {
        this.docCode = docCode;
    }

    public int getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(int citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(boolean isIdentified) {
        this.isIdentified = isIdentified;
    }

    public List<DocProperties> getProperties() {
        if (properties == null) {
            properties = new ArrayList<>();
        }
        return properties;
    }

    public void addProperty(DocProperties property) {
        getProperties().add(property);
    }

    public void removeProperty(DocProperties property) {
        getProperties().remove(property);
    }
}
