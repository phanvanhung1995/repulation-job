package com.example.reputationjobbe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String name;
    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private Set<CV> cvSet;

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

    public Set<CV> getCvSet() {
        return cvSet;
    }

    public void setCvSet(Set<CV> cvSet) {
        this.cvSet = cvSet;
    }
}
