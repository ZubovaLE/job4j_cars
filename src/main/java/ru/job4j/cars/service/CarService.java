package ru.job4j.cars.service;

import ru.job4j.cars.SessionFactoryInitializer;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.persistence.CarStore;

import java.util.List;

public class CarService implements Service<Car> {
    private final CarStore carStore = new CarStore(SessionFactoryInitializer.instOf().getSf());

    private static final class Lazy {
        private static final CarService INST = new CarService();
    }

    public static CarService instOf() {
        return CarService.Lazy.INST;
    }

    @Override
    public Car add(Car car) {
        return carStore.add(car);
    }

    @Override
    public List<Car> findAll() {
        return carStore.findAll();
    }

    @Override
    public Car findById(int id) {
        return carStore.findById(id);
    }

    @Override
    public void update(int id, Car car) {

    }

    @Override
    public void delete(int id) {
        carStore.delete(id);
    }
}