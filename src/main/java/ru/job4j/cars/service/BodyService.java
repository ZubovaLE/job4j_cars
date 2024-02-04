package ru.job4j.cars.service;

import ru.job4j.cars.SessionFactoryInitializer;
import ru.job4j.cars.model.Body;
import ru.job4j.cars.persistence.BodyStore;

import java.util.List;

public class BodyService implements Find<Body> {
    private final BodyStore bodyStore = new BodyStore(SessionFactoryInitializer.instOf().getSf());

    private static final class Lazy {
        private static final BodyService INST = new BodyService();
    }

    public static BodyService instOf() {
        return BodyService.Lazy.INST;
    }

    @Override
    public List<Body> findAll() {
        return bodyStore.findAll();
    }

    @Override
    public Body findById(int id) {
        return bodyStore.findById(id);
    }
}