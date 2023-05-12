package com.example.reputationjobbe.model;

import javax.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(nullable = false, columnDefinition = "int")
    private int quantity;
    private boolean flagDelete;

    @ManyToOne
    @JoinColumn(name = "cv_id",referencedColumnName = "id")
    private CV cv;
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Orders order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public boolean isPaid() {
        return flagDelete;
    }

    public void setPaid(boolean paid) {
        flagDelete = paid;
    }
}
