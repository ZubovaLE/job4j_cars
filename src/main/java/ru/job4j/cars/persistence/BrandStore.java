package ru.job4j.cars.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.cars.model.Brand;
import ru.job4j.cars.model.Model;

import java.util.List;

public class BrandStore {
    private final SessionFactory sf;

    public BrandStore(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Brand> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Brand> brands = session.createQuery("select distinct b from Brand b " +
                        "join fetch b.models  ",
                Brand.class).list();
        session.getTransaction().commit();
        session.close();
        return brands;
    }

    public Brand findById(int id) {
        Session session = sf.openSession();
        Brand brand = session.createQuery("select distinct b from Brand b " +
                        "join fetch b.models  " +
                        "where b.id = :bId ",
                Brand.class)
                .setParameter("bId", id)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return brand;
    }
}
