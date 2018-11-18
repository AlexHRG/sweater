package com.example.sweater.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "username", nullable = false)
    private User userName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "name")
    private Set<Bird> birdList;
}
