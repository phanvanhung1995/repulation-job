package com.example.reputationjobbe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(columnDefinition = "date", nullable = false)
    private String dateOfBirth;

    @Column(length = 20, nullable = false, unique = true)
    private String phoneNumber;

    @Column(length = 45, nullable = false, unique = true)
    private String idCard;

    @Column(length = 100, nullable = false, unique = true)
    private String address;

    private boolean gender;

    @Column(length = 45, unique = true)
    private String email;

    @OneToOne(mappedBy = "candidate")
    @JsonBackReference
    private Account account;

    @OneToMany(mappedBy = "candidate")
    @JsonBackReference
    private Set<Orders> orderSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Orders> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Orders> orderSet) {
        this.orderSet = orderSet;
    }
}
