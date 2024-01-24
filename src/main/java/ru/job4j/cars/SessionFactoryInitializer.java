package ru.job4j.cars;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryInitializer implements AutoCloseable {
    private final StandardServiceRegistry registry;
    private final SessionFactory sf;

    private SessionFactoryInitializer() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public SessionFactory getSf() {
        return sf;
    }

    private static final class Lazy {
        private static final SessionFactoryInitializer INST = new SessionFactoryInitializer();
    }

    public static SessionFactoryInitializer instOf() {
        return Lazy.INST;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
