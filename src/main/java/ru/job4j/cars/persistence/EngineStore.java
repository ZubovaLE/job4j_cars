package ru.job4j.cars.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.cars.model.Engine;

import java.util.Collection;

public class EngineStore extends AbstractStore<Engine> {
    public EngineStore(SessionFactory sf) {
        super(sf);
    }

    @Override
    public Engine add(Engine engine) {
        return this.tx(
                session -> {
                    session.save(engine);
                    return engine;
                }
        );
    }

    @Override
    public void update(int id, Engine engine) {
        Session session = sf.openSession();
        session.beginTransaction();
        engine.setId(id);
        session.update(engine);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Collection<Engine> findAll() {
        return this.tx(
                session -> session.createQuery("from Engine ")
                        .list()
        );
    }

    @Override
    public Engine findById(int id) {
        return this.tx(
                session -> session.createQuery("from Engine where id = :eId", Engine.class)
                        .setParameter("eId", id)
                        .uniqueResult()
        );
    }

    @Override
    public void delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Engine removableEngine = new Engine();
        removableEngine.setId(id);
        session.delete(removableEngine);
        session.getTransaction().commit();
        session.close();
    }
}
