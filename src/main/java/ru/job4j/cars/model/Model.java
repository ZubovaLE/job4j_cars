package ru.job4j.cars.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "models_bodies", joinColumns = {
            @JoinColumn(name = "body_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "model_id", nullable = false)
    })
    private List<Body> bodies = new ArrayList<>();


    public void addBody(Body body) {
        this.bodies.add(body);
    }

    public static Model of(String name) {
        Model model = new Model();
        model.name = name;
        return model;
    }
}