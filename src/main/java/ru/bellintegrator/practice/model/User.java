package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")

    private Set<User> users;

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

    public Set<User> getUsers() {
        if (users == null) {
            users = new HashSet<>();
        }
        return users;
    }

    public void addUser(User user) {
        getUsers().add(user);
        user.getDocProperties().add(this);
    }

    public void removeOrganization(User user) {
        getUsers().remove(user);
        user.getDocProperties().remove(this);
    }
}
