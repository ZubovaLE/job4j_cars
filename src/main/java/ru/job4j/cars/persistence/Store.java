package ru.job4j.cars.persistence;

public interface Store<E> extends Findable<E> {
    E add(E e);

    void update(int id, E e);

    void delete(int id);
}