package ru.job4j.cars.service;

public interface Service<E> extends Find<E>{
    E add(E e);

    void update(int id, E e);

    void delete(int id);
}