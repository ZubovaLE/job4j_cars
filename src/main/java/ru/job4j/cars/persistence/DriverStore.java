package ru.job4j.cars.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.cars.model.Driver;

import java.util.Collection;

public class DriverStore extends AbstractStore<Driver> {
    public DriverStore(SessionFactory sf) {
        super(sf);
    }

    @Override
    public Driver add(Driver driver) {
        return this.tx(
                session -> {
                    session.save(driver);
                    return driver;
                }
        );
    }

    @Override
    public void update(int id, Driver driver) {
        Session session = sf.openSession();
        session.beginTransaction();
        driver.setId(id);
        session.update(driver);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Collection<Driver> findAll() {
        return this.tx(
                session -> session.createQuery("from Driver ", Driver.class)
                        .list()
        );
    }

    @Override
    public Driver findById(int id) {
        return this.tx(
                session -> session.createQuery("from Driver where id = :dId", Driver.class)
                        .setParameter("dId", id)
                        .uniqueResult()
        );
    }

    @Override
    public void delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Driver removableDriver = new Driver();
        removableDriver.setId(id);
        session.delete(removableDriver);
        session.getTransaction().commit();
        session.close();
    }
}