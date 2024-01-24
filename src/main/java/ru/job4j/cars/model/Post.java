package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "description")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private double price;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static Post of(String description, LocalDateTime created, double price, String photo) {
        Post post = new Post();
        post.description = description;
        post.created = created;
        post.price = price;
        post.photo = photo;
        return post;
    }
}