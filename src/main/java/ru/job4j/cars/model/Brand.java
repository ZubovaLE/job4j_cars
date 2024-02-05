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
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "brands_models", joinColumns = {
            @JoinColumn(name = "brand_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "model_id")
    })
    private List<Model> models = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "brands_engines", joinColumns = {
            @JoinColumn(name = "brand_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "engine_id")
    })
    private List<Engine> engines = new ArrayList<>();

    public static Brand of(String name) {
        Brand brand = new Brand();
        brand.name = name;
        return brand;
    }

    public void addModel(Model model) {
        this.models.add(model);
    }
}