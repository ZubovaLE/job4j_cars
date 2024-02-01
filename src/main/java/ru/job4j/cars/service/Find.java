package ru.job4j.cars.service;

import java.util.Collection;

public interface Find<E> {

    Collection<E> findAll();

    E findById(int id);
}