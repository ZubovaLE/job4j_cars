package ru.job4j.cars.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.cars.model.Body;

import java.util.List;

public class BodyStore implements Findable<Body> {
    private final SessionFactory sf;

    public BodyStore(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<Body> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Body> bodies = session.createQuery("from Body", Body.class).list();
        session.getTransaction().commit();
        session.close();
        return bodies;
    }

    @Override
    public Body findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Body bodies = session.createQuery("from Body b where b.id = :bId ", Body.class)
                .setParameter("bId", id)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return bodies;
    }
}