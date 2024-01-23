package ru.job4j.cars.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String description;

    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private double price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}