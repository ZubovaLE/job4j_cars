package ru.job4j.cars.service;

import ru.job4j.cars.SessionFactoryInitializer;
import ru.job4j.cars.model.Engine;
import ru.job4j.cars.persistence.EngineStore;

import java.util.List;

public class EngineService implements Find<Engine> {
    private final EngineStore engineStore = new EngineStore(SessionFactoryInitializer.instOf().getSf());

    private static final class Lazy {
        private static final EngineService INST = new EngineService();
    }

    public static EngineService instOf() {
        return EngineService.Lazy.INST;
    }

    @Override
    public List<Engine> findAll() {
        return engineStore.findAll();
    }

    @Override
    public Engine findById(int id) {
        return engineStore.findById(id);
    }
}