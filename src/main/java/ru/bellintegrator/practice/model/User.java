package ru.bellintegrator.practice.model;

import io.swagger.models.auth.In;

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
    private Integer id;

    private Long officeId;

    private String firstName;

    private String lastName;

    private String middleName;

    private String position;

    private int docCode;

    private int citizenshipCode;

    private boolean isIdentified;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade =
            CascadeType.ALL, optional = false)
    private DocProperties property;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenshipCode")
    private Country country;

    /**
     * Конструктор для hibernate
     */
    public User() {}

    public User(Integer id, String firstName, String lastName, String middleName, String position, int docCode, int citizenshipCode, boolean isIdentified) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.docCode = docCode;
        this.citizenshipCode = citizenshipCode;
        isIdentified = true;
    }

    public Integer getId() {
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


}
