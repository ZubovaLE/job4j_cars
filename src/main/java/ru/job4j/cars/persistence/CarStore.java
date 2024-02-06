package ru.job4j.cars.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.cars.model.Car;

import java.util.List;

public class CarStore extends AbstractStore<Car> {

    public CarStore(SessionFactory sf) {
        super(sf);
    }

    @Override
    public Car add(Car car) {
        return this.tx(
                session -> {
                    session.save(car);
                    return car;
                }
        );
    }

    @Override
    public void update(int id, Car car) {
        Session session = sf.openSession();
        session.beginTransaction();
        car.setId(id);
        session.update(car);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Car> findAll() {
        return this.tx(
                session -> session.createQuery("select distinct c from Car c " +
                                        "join fetch c.engine e " +
                                        "join fetch c.brand b " +
                                        "join fetch b.models bm " +
                                        "join fetch c.model m " +
                                        "join fetch c.body bd ",
                                Car.class)
                        .list()
        );
    }

    @Override
    public Car findById(int id) {
        return this.tx(
                session -> session.createQuery("select distinct c from Car c inner join fetch c.engine e " +
                                "where c.id = :cId", Car.class)
                        .setParameter("cId", id)
                        .uniqueResult()
        );
    }

    @Override
    public void delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Car removableCar = new Car();
        removableCar.setId(id);
        session.delete(removableCar);
        session.getTransaction().commit();
        session.close();
    }
}