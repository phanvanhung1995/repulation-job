package com.example.reputationjobbe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(225)")
    private String name ;
    @Column(columnDefinition = "text")
    private String description;
    @Column(columnDefinition = "varchar(225)")
    private String filePath;
    @Column(columnDefinition = "DECIMAL(10,2)")
    private double price;
    @ManyToOne
    @JoinColumn(name = "position_id" ,referencedColumnName = "id")
    private Position position;
    @OneToMany(mappedBy = "cv")
    @JsonBackReference
    private Set<Cart> cartSet;

    @OneToMany(mappedBy = "cv")
    @JsonBackReference
    private Set<ImgCv> imgCvSet;

    public Set<ImgCv> getImgCvSet() {
        return imgCvSet;
    }

    public void setImgCvSet(Set<ImgCv> imgCvSet) {
        this.imgCvSet = imgCvSet;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Set<Cart> getCartSet() {
        return cartSet;
    }

    public void setCartSet(Set<Cart> cartSet) {
        this.cartSet = cartSet;
    }
}
