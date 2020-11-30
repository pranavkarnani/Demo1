package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "type")
    private String type;

    @Column(name = "quantity")
    private String quantity;
}
