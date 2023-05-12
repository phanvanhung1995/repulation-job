package com.example.reputationjobbe.model;

import javax.persistence.*;

@Entity
public class ImgCv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(225)")
    private String link ;

    @ManyToOne
    @JoinColumn(name = "cv_id" ,referencedColumnName = "id")
    private CV cv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }
}
