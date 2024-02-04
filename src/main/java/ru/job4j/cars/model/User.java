package ru.job4j.cars.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;
    private String email;
    private String password;
    private String phone;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts = new HashSet<>();

    public static User of(String name, String email, String password, String phone) {
        User user = new User();
        user.name = name;
        user.email = email;
        user.password = password;
        user.phone = phone;
        return user;
    }
}