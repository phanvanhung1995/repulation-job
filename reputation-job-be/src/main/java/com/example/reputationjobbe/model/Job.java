package com.example.reputationjobbe.model;

import javax.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(225)")
    private String title ;
    @Column(columnDefinition = "text")
    private String description ;
    @Column(columnDefinition = "varchar(225)")
    private String location ;
    @Column(columnDefinition = "DECIMAL(10,2)")
    private double salary ;
    @Column(columnDefinition = "DATE")
    private String postedDate ;

}
