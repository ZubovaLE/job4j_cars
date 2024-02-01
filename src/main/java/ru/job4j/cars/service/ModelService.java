package ru.job4j.cars.service;

import ru.job4j.cars.SessionFactoryInitializer;
import ru.job4j.cars.model.Model;
import ru.job4j.cars.persistence.ModelStore;

import java.util.List;

public class ModelService implements Find<Model> {
    private final ModelStore modelStore = new ModelStore(SessionFactoryInitializer.instOf().getSf());

    private static final class Lazy {
        private static final ModelService INST = new ModelService();
    }

    public static ModelService instOf() {
        return ModelService.Lazy.INST;
    }

    @Override
    public List<Model> findAll() {
        return modelStore.findAll();
    }

    @Override
    public Model findById(int id) {
        return modelStore.findById(id);
    }
}