package ru.job4j.cars.service;


import ru.job4j.cars.SessionFactoryInitializer;
import ru.job4j.cars.model.Brand;
import ru.job4j.cars.persistence.BrandStore;

import java.util.List;

public class BrandService implements Find<Brand> {
    private final BrandStore brandStore = new BrandStore(SessionFactoryInitializer.instOf().getSf());

    private static final class Lazy {
        private static final BrandService INST = new BrandService();
    }

    public static BrandService instOf() {
        return BrandService.Lazy.INST;
    }

    @Override
    public List<Brand> findAll() {
        return brandStore.findAll();
    }

    @Override
    public Brand findById(int id) {
        return brandStore.findById(id);
    }
}