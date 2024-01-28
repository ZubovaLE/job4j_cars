package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String description;

    private LocalDateTime created = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private double price;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static Post of(String description, double price) {
        Post post = new Post();
        post.description = description;
        post.price = price;
        return post;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", car=" + car +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                ", user=" + user +
                '}';
    }
}