package ru.job4j.cars.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String model;

    @OneToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "history_owner", joinColumns = {
            @JoinColumn(name = "driver_id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "car_id", nullable = false, updatable = false)
    })
    private Set<Driver> drivers = new HashSet<>();

    public static Car of(String brand, String model) {
        Car car = new Car();
        car.brand = brand;
        car.model = model;
        return car;
    }
}