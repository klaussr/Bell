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
    private int orgId;

    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    private int phone;

    private boolean isActive;

    @OneToMany(cascade =
            CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "officeId")
    private List<User> users;

    /**
     * Конструктор для hibernate
     */
    public Office() {}

    public Office(int orgId, String name, String address, char phone, boolean isActive) {
        this.orgId = orgId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        isActive = true;
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

    public void setPhone(char phone) {
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

    public List<User> getUsers() {
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;
    }
}
