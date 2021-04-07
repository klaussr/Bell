package ru.bellintegrator.practice.model;

import sun.misc.Cache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Офис
 */
@Entity
@Table(name = "Office")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "orgId", length = 25)
    private int orgId;

    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "phone", length = 20)
    private int phone;

    @Column(name = "isActive", length = 10)
    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orgId")
    private Organization organization;

    @OneToMany(mappedBy = "office", cascade =
            CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

    /**
     * Конструктор для hibernate
     */
    public Office() {}

    public Office(Integer id, int orgId, String name, String address, int phone, boolean isActive) {
        this.id = id;
        this.orgId = orgId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        isActive = true;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public List<User> getUsers() {
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;
    }

    public void addUser(User user) {
        getUsers().add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

}
