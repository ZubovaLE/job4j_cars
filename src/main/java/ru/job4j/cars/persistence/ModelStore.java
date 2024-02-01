package ru.job4j.cars.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.cars.model.Model;

import java.util.List;

public class ModelStore implements Findable<Model> {
    private final SessionFactory sf;

    public ModelStore(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<Model> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Model> models = session.createQuery("select distinct m from Model m " +
                        "join fetch m.bodies  ",
                Model.class).list();
        session.getTransaction().commit();
        session.close();
        return models;
    }

    @Override
    public Model findById(int id) {
        Session session = sf.openSession();
        Model model = session.createQuery("select distinct m from Model m " +
                                "join fetch m.bodies  " +
                                "where m.id = :mId ",
                        Model.class)
                .setParameter("mId", id)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return model;
    }
}