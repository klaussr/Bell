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
    @Column(name = "Id")
    private Long id;

    @Column(name = "name", length = 25, nullable = false)
    private String name;

    @Column(name = "fullName", length = 25)
    private String fullName;

    @Column(name = "inn", length = 25)
    private int inn;

    @Column(name = "kpp", length = 25)
    private int kpp;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "phone", length = 20)
    private int phone;

    @Column(name = "isActive", length = 10)
    private boolean isActive;

    @OneToMany(cascade =
            CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "orgId")
    private List<Office> offices;

    /**
     * Конструктор для hibernate
     */
    public Organization() {}

    public Organization(Long id, String name, String fullName, int inn, int kpp, String address, int phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        isActive = true;
    }

    public Long getId() {
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

    public int getInn() {
        return inn;
    }

    public void setInn(int age) {
        this.inn = age;
    }

    public int getKpp() {
        return kpp;
    }

    public void setKpp(int age) {
        this.kpp = age;
    }

    public String  getAddress() {
        return address;
    }

    public void setAddress(String age) {
        this.address = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int age) {
        this.phone = age;
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

    public void addOffice(Office office) {
        getOffices().add(office);
    }

    public void removeOffice(Office office) {
        getOffices().remove(office);
    }


}
