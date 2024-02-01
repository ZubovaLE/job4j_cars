package ru.job4j.cars.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostStoreTest {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

//    @Test
//    void findNewPosts() {
//        EngineStore engineStore = new EngineStore(sf);
//        Engine engineOne = Engine.of("engine ");
//        Engine engineTwo = Engine.of("engine two");
//        engineStore.add(engineOne);
//        engineStore.add(engineTwo);
//
//        CarStore carStore = new CarStore(sf);
//        Brand brandOne = "brand ONE";
//        Brand brandTwo = "brand TWO";
//        Car carOne = Car.of(brandOne, "a", "type 1");
//        carOne.setEngine(engineOne);
//        Car carTwo = Car.of(brandTwo, "a", "type 1");
//        carOne.setEngine(engineTwo);
//        carStore.add(carOne);
//        carStore.add(carTwo);
//
//        UserStore userStore = new UserStore(sf);
//        User userOne = new User();
//        User userTwo = new User();
//        userStore.add(userOne);
//        userStore.add(userTwo);
//
//        Post one = Post.of("descr1", 123000.3);
//        one.setCreated(LocalDateTime.now().minusDays(2));
//        one.setCar(carOne);
//        one.setUser(userOne);
//
//        Post two = Post.of("descr2", 123000.3);
//        two.setCar(carTwo);
//        two.setUser(userTwo);
//
//        PostStore store = new PostStore(sf);
//        store.add(one);
//        store.add(two);
//        assertEquals(List.of(two), store.findNewPosts());
//    }
//
//    @Test
//    void findPostsWithPhotos() {
//        EngineStore engineStore = new EngineStore(sf);
//        Engine engineOne = Engine.of("engine ");
//        Engine engineTwo = Engine.of("engine two");
//        engineStore.add(engineOne);
//        engineStore.add(engineTwo);
//
//        CarStore carStore = new CarStore(sf);
//        Brand brandOne = "brand ONE";
//        Brand brandTwo = "brand TWO";
//        Car carOne = Car.of(brandOne, "a", "type 1");
//        carOne.setEngine(engineOne);
//        Car carTwo = Car.of(brandTwo, "a", "type 1");
//        carOne.setEngine(engineTwo);
//        carStore.add(carOne);
//        carStore.add(carTwo);
//
//        UserStore userStore = new UserStore(sf);
//        User userOne = new User();
//        User userTwo = new User();
//        userStore.add(userOne);
//        userStore.add(userTwo);
//
//        PostStore store = new PostStore(sf);
//
//        Post one = Post.of("descr1", 123000.3);
//        one.setPhoto("Photo one");
//        one.setCar(carOne);
//        one.setUser(userOne);
//
//        Post two = Post.of("descr2", 123000.3);
//        two.setCar(carTwo);
//        two.setUser(userTwo);
//
//        store.add(one);
//        store.add(two);
//        assertEquals(List.of(one), store.findPostsWithPhotos());
//    }
//
//    @Test
//    void findPostsWithBrand() {
//        EngineStore engineStore = new EngineStore(sf);
//        Engine engineOne = Engine.of("engine ");
//        Engine engineTwo = Engine.of("engine two");
//        engineStore.add(engineOne);
//        engineStore.add(engineTwo);
//
//        CarStore carStore = new CarStore(sf);
//        Brand brandOne = Brand.of("brand ONE");
//        Brand brandTwo = Brand.of("brand TWO");
//        Car carOne = Car.of(brandOne, "a", "type 1");
//        carOne.setEngine(engineOne);
//        Car carTwo = Car.of(brandTwo, "a", "type 1");
//        carOne.setEngine(engineTwo);
//        carStore.add(carOne);
//        carStore.add(carTwo);
//
//        UserStore userStore = new UserStore(sf);
//        User userOne = new User();
//        User userTwo = new User();
//        userStore.add(userOne);
//        userStore.add(userTwo);
//
//        Post one = Post.of("descr1", 123000.3);
//        one.setCar(carOne);
//        one.setUser(userOne);
//        Post two = Post.of("descr2", 124000.3);
//        two.setCar(carTwo);
//        two.setUser(userTwo);
//        Post three = Post.of("descr3", 133000.3);
//        three.setCar(carTwo);
//        three.setUser(userOne);
//        Post four = Post.of("descr4", 125000.3);
//        four.setCar(carOne);
//        four.setUser(userTwo);
//
//        PostStore store = new PostStore(sf);
//        store.add(one);
//        store.add(two);
//        store.add(three);
//        store.add(four);
//        assertEquals(List.of(one, four), store.findPostsWithBrand(brandOne));
//        assertEquals(List.of(two, three), store.findPostsWithBrand(brandTwo));
//    }
}