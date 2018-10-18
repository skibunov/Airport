package com.blisse.repository.passengers;

import com.blisse.model.Passengers;
import com.blisse.model.Types;
import com.blisse.repository.common.CrudRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository("passengersRepository")
@Transactional
public class PassengersRepository implements CrudRepository<Passengers> {

    private final SessionFactory sessionFactory;

    @Autowired
    public PassengersRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Types types = session.load(Types.class, id);
        session.remove(types);
    }

    @Override
    public void update(Passengers passengers) {
        sessionFactory.getCurrentSession().update(passengers);
    }

    @Override
    public Passengers create(Passengers passengers) {
        return (Passengers) sessionFactory.getCurrentSession().save(passengers);
    }

    @Override
    public List<Passengers> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery(
                        "select a from Passengers a", Passengers.class)
                .list();
    }

    @Override
    public Passengers getById(Long id) {
        Passengers passengers = sessionFactory.getCurrentSession().get(Passengers.class, id);
        return passengers;
    }
}
