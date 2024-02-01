package ru.job4j.cars.persistence;

import java.util.Collection;

public interface Findable<E> {

    Collection<E> findAll();

    E findById(int id);
}
