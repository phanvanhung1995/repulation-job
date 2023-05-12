package com.example.reputationjobbe.dto;

import javax.validation.constraints.NotBlank;

public class CandidateDto {
    private  Long id;

    @NotBlank(message = "không được để trống")
    private String name;

    @NotBlank(message = "không được để trống")
    private String idCard;

    @NotBlank(message = "không được để trống")
    private String dateOfBirth;

    @NotBlank(message = "không được để trống")
    private String email;

    @NotBlank(message = "không được để trống")
    private String address;

    @NotBlank(message = "không được để trống")
    private String phoneNumber;

    private boolean gender;

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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
