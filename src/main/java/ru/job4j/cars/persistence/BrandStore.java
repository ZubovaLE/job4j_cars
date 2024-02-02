package ru.job4j.cars.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.cars.model.Brand;

import java.util.List;

public class BrandStore {
    private final SessionFactory sf;

    public BrandStore(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Brand> findAll() {
        List<Brand> brands;
        Session session = sf.openSession();
        session.beginTransaction();
        brands = session.createQuery("select distinct b from Brand b " +
                        "join fetch b.models m ",
                Brand.class).list();
        session.getTransaction().commit();
        session.close();
        return brands;
    }

    public Brand findById(int id) {
        Brand brand;
        Session session = sf.openSession();
        session.beginTransaction();
        brand = session.createQuery("select distinct b from Brand b " +
                                "join fetch b.models m " +
                                "where b.id = :bId ",
                        Brand.class)
                .setParameter("bId", id)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return brand;
    }
}