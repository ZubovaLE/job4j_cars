package ru.job4j.cars.service;

import ru.job4j.cars.SessionFactoryInitializer;
import ru.job4j.cars.model.User;
import ru.job4j.cars.persistence.UserStore;

import java.util.Collection;

public class UserService implements Service<User> {
    private final UserStore userStore = new UserStore(SessionFactoryInitializer.instOf().getSf());

    private static final class Lazy {
        private static final UserService INST = new UserService();
    }

    public static UserService instOf() {
        return Lazy.INST;
    }

    @Override
    public User add(User user) {
        return userStore.add(user);
    }

    @Override
    public Collection<User> findAll() {
        return userStore.findAll();
    }

    @Override
    public User findById(int id) {
        return userStore.findById(id);
    }

    public User findByEmail(String email) {
        return userStore.findByEmail(email);
    }

    @Override
    public void update(int id, User user) {
        userStore.update(id, user);
    }

    @Override
    public void delete(int id) {
        userStore.delete(id);
    }
}