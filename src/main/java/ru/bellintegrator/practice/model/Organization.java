package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Организация
 */
@Entity
@Table(name = "Organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    private String fullName;

    private String inn;

    private String kpp;

    private String address;

    private int phone;

    private boolean isActive;

    @OneToMany(cascade =
            CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "orgId")
    private List<Office> offices;

    /**
     * Конструктор для hibernate
     */
    public Organization() {}

    public Organization(Integer id, String name, String fullName, String  inn, String  kpp, String address, int phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
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

    public String  getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String  kpp) {
        this.kpp = kpp;
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

    public List<Office> getOffices() {
        if (offices == null) {
            offices = new ArrayList<>();
        }
        return offices;
    }
}
