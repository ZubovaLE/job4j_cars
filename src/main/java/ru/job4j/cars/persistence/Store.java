package ru.job4j.cars.persistence;

import java.util.Collection;

public interface Store<E> {
    E add(E e);

    void update(int id, E e);

    Collection<E> findAll();

    E findById(int id);

    void delete(int id);
}