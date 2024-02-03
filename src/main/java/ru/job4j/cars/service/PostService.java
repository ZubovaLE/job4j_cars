package ru.job4j.cars.service;

import ru.job4j.cars.SessionFactoryInitializer;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.persistence.PostStore;

import java.util.List;

public class PostService implements Service<Post> {
    private final PostStore postStore = new PostStore(SessionFactoryInitializer.instOf().getSf());

    private static final class Lazy {
        private static final PostService INST = new PostService();
    }

    public static PostService instOf() {
        return Lazy.INST;
    }

    @Override
    public Post add(Post post) {
        return postStore.add(post);
    }

    @Override
    public List<Post> findAll() {
        return postStore.findAll();
    }

    public List<Post> findNewPosts() {
        return postStore.findNewPosts();
    }

    @Override
    public Post findById(int id) {
        return postStore.findById(id);
    }

    @Override
    public void update(int id, Post post) {
        postStore.update(id, post);
    }

    @Override
    public void delete(int id) {
        postStore.delete(id);
    }
}